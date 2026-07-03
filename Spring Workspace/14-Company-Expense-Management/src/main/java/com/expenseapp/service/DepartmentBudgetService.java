package com.expenseapp.service;

import com.expenseapp.dto.DepartmentBudgetRequest;
import com.expenseapp.dto.DepartmentBudgetResponse;
import com.expenseapp.entity.DepartmentBudget;
import com.expenseapp.enums.ClaimStatus;
import com.expenseapp.exception.BusinessValidationException;
import com.expenseapp.exception.DuplicateBudgetException;
import com.expenseapp.exception.ResourceNotFoundException;
import com.expenseapp.repository.DepartmentBudgetRepository;
import com.expenseapp.repository.ExpenseClaimRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DepartmentBudgetService {

    private final DepartmentBudgetRepository budgetRepository;
    private final ExpenseClaimRepository claimRepository;

    public DepartmentBudgetService(DepartmentBudgetRepository budgetRepository,
                                   ExpenseClaimRepository claimRepository) {
        this.budgetRepository = budgetRepository;
        this.claimRepository = claimRepository;
    }

    public DepartmentBudgetResponse createBudget(DepartmentBudgetRequest request) {
        if (budgetRepository.existsByDepartmentAndMonthAndYear(
                request.getDepartment(), request.getMonth(), request.getYear())) {
            throw new DuplicateBudgetException(
                "A budget already exists for '" + request.getDepartment()
                + "' for " + request.getMonth() + "/" + request.getYear()
                + ". Use the Edit option to update it.");
        }
        DepartmentBudget budget = new DepartmentBudget();
        budget.setDepartment(request.getDepartment());
        budget.setMonth(request.getMonth());
        budget.setYear(request.getYear());
        budget.setBudgetAmount(request.getBudgetAmount());
        return toResponse(budgetRepository.save(budget));
    }

    @Transactional
    public DepartmentBudgetResponse updateBudget(Long id, DepartmentBudgetRequest request) {
        DepartmentBudget budget = budgetRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Budget not found with id: " + id));

        // If department/month/year changed, check the new combination isn't a duplicate
        boolean combinationChanged =
            !budget.getDepartment().equals(request.getDepartment())
            || !budget.getMonth().equals(request.getMonth())
            || !budget.getYear().equals(request.getYear());

        if (combinationChanged && budgetRepository.existsByDepartmentAndMonthAndYear(
                request.getDepartment(), request.getMonth(), request.getYear())) {
            throw new DuplicateBudgetException(
                "A budget already exists for '" + request.getDepartment()
                + "' for " + request.getMonth() + "/" + request.getYear() + ".");
        }

        // Safety check: new amount must not be less than already-approved expense
        BigDecimal alreadyApproved = claimRepository.sumByDepartmentAndStatusAndMonthYear(
            budget.getDepartment(), ClaimStatus.APPROVED, budget.getMonth(), budget.getYear());

        if (request.getBudgetAmount().compareTo(alreadyApproved) < 0) {
            throw new BusinessValidationException(
                "Cannot set budget to " + request.getBudgetAmount()
                + " — already " + alreadyApproved
                + " has been approved for this department/period. "
                + "New budget must be at least " + alreadyApproved + ".");
        }

        budget.setDepartment(request.getDepartment());
        budget.setMonth(request.getMonth());
        budget.setYear(request.getYear());
        budget.setBudgetAmount(request.getBudgetAmount());
        return toResponse(budgetRepository.save(budget));
    }

    @Transactional
    public void deleteBudget(Long id) {
        DepartmentBudget budget = budgetRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Budget not found with id: " + id));

        // Block deletion if any approved claims exist against this budget period
        BigDecimal alreadyApproved = claimRepository.sumByDepartmentAndStatusAndMonthYear(
            budget.getDepartment(), ClaimStatus.APPROVED, budget.getMonth(), budget.getYear());

        if (alreadyApproved.compareTo(BigDecimal.ZERO) > 0) {
            throw new BusinessValidationException(
                "Cannot delete this budget — " + alreadyApproved
                + " has already been approved against it for "
                + budget.getDepartment() + " (" + budget.getMonth() + "/" + budget.getYear()
                + "). Reject or remove those claims first.");
        }

        budgetRepository.delete(budget);
    }

    public List<DepartmentBudgetResponse> getBudgets(String department, Integer month, Integer year) {
        return budgetRepository.search(department, month, year)
            .stream().map(this::toResponse).toList();
    }

    private DepartmentBudgetResponse toResponse(DepartmentBudget b) {
        DepartmentBudgetResponse r = new DepartmentBudgetResponse();
        r.setId(b.getId()); r.setDepartment(b.getDepartment());
        r.setMonth(b.getMonth()); r.setYear(b.getYear());
        r.setBudgetAmount(b.getBudgetAmount());
        return r;
    }
}