package com.expenseapp.service;

import com.expenseapp.dto.SummaryResponse;
import com.expenseapp.entity.DepartmentBudget;
import com.expenseapp.enums.ClaimStatus;
import com.expenseapp.exception.BusinessValidationException;
import com.expenseapp.repository.DepartmentBudgetRepository;
import com.expenseapp.repository.ExpenseClaimRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SummaryService {

    private final ExpenseClaimRepository claimRepository;
    private final DepartmentBudgetRepository budgetRepository;

    public SummaryService(ExpenseClaimRepository claimRepository,
                           DepartmentBudgetRepository budgetRepository) {
        this.claimRepository = claimRepository;
        this.budgetRepository = budgetRepository;
    }

    public SummaryResponse getSummary(String department, Integer month, Integer year) {
        if (department == null || department.isBlank()) {
            throw new BusinessValidationException("Department is required for the summary.");
        }
        if (month == null || month < 1 || month > 12) {
            throw new BusinessValidationException("A valid month (1-12) is required for the summary.");
        }
        if (year == null) {
            throw new BusinessValidationException("Year is required for the summary.");
        }

        BigDecimal monthlyBudget = budgetRepository
                .findByDepartmentAndMonthAndYear(department, month, year)
                .map(DepartmentBudget::getBudgetAmount)
                .orElse(BigDecimal.ZERO);

        BigDecimal totalApproved = claimRepository.sumByDepartmentAndStatusAndMonthYear(
                department, ClaimStatus.APPROVED, month, year);
        BigDecimal totalPending = claimRepository.sumByDepartmentAndStatusAndMonthYear(
                department, ClaimStatus.PENDING, month, year);

        long pendingCount = claimRepository.countByDepartmentAndStatusAndMonthYear(
                department, ClaimStatus.PENDING, month, year);
        long approvedCount = claimRepository.countByDepartmentAndStatusAndMonthYear(
                department, ClaimStatus.APPROVED, month, year);
        long rejectedCount = claimRepository.countByDepartmentAndStatusAndMonthYear(
                department, ClaimStatus.REJECTED, month, year);

        SummaryResponse response = new SummaryResponse();
        response.setDepartment(department);
        response.setMonth(month);
        response.setYear(year);
        response.setMonthlyBudget(monthlyBudget);
        response.setTotalApprovedExpense(totalApproved);
        response.setTotalPendingExpense(totalPending);
        response.setRemainingBudget(monthlyBudget.subtract(totalApproved));
        response.setPendingCount(pendingCount);
        response.setApprovedCount(approvedCount);
        response.setRejectedCount(rejectedCount);

        return response;
    }
}
