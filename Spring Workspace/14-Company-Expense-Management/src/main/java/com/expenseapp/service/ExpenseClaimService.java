package com.expenseapp.service;

import com.expenseapp.dto.ExpenseClaimRequest;
import com.expenseapp.dto.ExpenseClaimResponse;
import com.expenseapp.dto.ReviewRequest;
import com.expenseapp.entity.DepartmentBudget;
import com.expenseapp.entity.ExpenseClaim;
import com.expenseapp.enums.ClaimStatus;
import com.expenseapp.exception.BusinessValidationException;
import com.expenseapp.exception.ResourceNotFoundException;
import com.expenseapp.repository.DepartmentBudgetRepository;
import com.expenseapp.repository.ExpenseClaimRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseClaimService {

    private final ExpenseClaimRepository claimRepository;
    private final DepartmentBudgetRepository budgetRepository;

    public ExpenseClaimService(ExpenseClaimRepository claimRepository,
                                DepartmentBudgetRepository budgetRepository) {
        this.claimRepository = claimRepository;
        this.budgetRepository = budgetRepository;
    }

    public ExpenseClaimResponse submitClaim(ExpenseClaimRequest request) {
        ExpenseClaim claim = new ExpenseClaim();
        claim.setEmployeeName(request.getEmployeeName());
        claim.setDepartment(request.getDepartment());
        claim.setExpenseCategory(request.getExpenseCategory());
        claim.setAmount(request.getAmount());
        claim.setExpenseDate(request.getExpenseDate());
        claim.setDescription(request.getDescription());
        claim.setStatus(ClaimStatus.PENDING);

        ExpenseClaim saved = claimRepository.save(claim);
        return toResponse(saved);
    }

    public List<ExpenseClaimResponse> getClaims(String department, String status, String category,
                                                 Integer month, Integer year) {
        ClaimStatus statusEnum = null;
        if (status != null && !status.isBlank()) {
            try {
                statusEnum = ClaimStatus.valueOf(status.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new BusinessValidationException(
                        "Invalid status value '" + status + "'. Must be PENDING, APPROVED, or REJECTED.");
            }
        }

        return claimRepository.search(department, statusEnum, category, month, year)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public ExpenseClaimResponse approveClaim(Long id, ReviewRequest request) {
        ExpenseClaim claim = getClaimOrThrow(id);

        if (claim.getStatus() != ClaimStatus.PENDING) {
            throw new BusinessValidationException(
                    "Only pending claims can be approved. This claim is already " + claim.getStatus() + ".");
        }

        int month = claim.getExpenseDate().getMonthValue();
        int year = claim.getExpenseDate().getYear();
        String department = claim.getDepartment();

        DepartmentBudget budget = budgetRepository
                .findByDepartmentAndMonthAndYear(department, month, year)
                .orElseThrow(() -> new BusinessValidationException(
                        "No budget has been defined for department '" + department +
                        "' for " + month + "/" + year + ". Define a budget before approving claims."));

        BigDecimal alreadyApproved = claimRepository.sumByDepartmentAndStatusAndMonthYear(
                department, ClaimStatus.APPROVED, month, year);

        BigDecimal projectedTotal = alreadyApproved.add(claim.getAmount());

        if (projectedTotal.compareTo(budget.getBudgetAmount()) > 0) {
            BigDecimal remaining = budget.getBudgetAmount().subtract(alreadyApproved);
            throw new BusinessValidationException(
                    "Approving this claim would exceed the monthly budget for '" + department +
                    "' (" + month + "/" + year + "). Remaining budget: " + remaining +
                    ", claim amount: " + claim.getAmount());
        }

        claim.setStatus(ClaimStatus.APPROVED);
        claim.setReviewRemark(request != null ? request.getReviewRemark() : null);

        ExpenseClaim saved = claimRepository.save(claim);
        return toResponse(saved);
    }

    @Transactional
    public ExpenseClaimResponse rejectClaim(Long id, ReviewRequest request) {
        ExpenseClaim claim = getClaimOrThrow(id);

        if (claim.getStatus() != ClaimStatus.PENDING) {
            throw new BusinessValidationException(
                    "Only pending claims can be rejected. This claim is already " + claim.getStatus() + ".");
        }

        claim.setStatus(ClaimStatus.REJECTED);
        claim.setReviewRemark(request != null ? request.getReviewRemark() : null);

        ExpenseClaim saved = claimRepository.save(claim);
        return toResponse(saved);
    }

    private ExpenseClaim getClaimOrThrow(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense claim not found with id: " + id));
    }

    private ExpenseClaimResponse toResponse(ExpenseClaim claim) {
        ExpenseClaimResponse response = new ExpenseClaimResponse();
        response.setId(claim.getId());
        response.setEmployeeName(claim.getEmployeeName());
        response.setDepartment(claim.getDepartment());
        response.setExpenseCategory(claim.getExpenseCategory());
        response.setAmount(claim.getAmount());
        response.setExpenseDate(claim.getExpenseDate());
        response.setDescription(claim.getDescription());
        response.setStatus(claim.getStatus());
        response.setReviewRemark(claim.getReviewRemark());
        response.setCreatedAt(claim.getCreatedAt());
        return response;
    }
    
    @Transactional
    public ExpenseClaimResponse updateClaim(Long id, ExpenseClaimRequest request) {
        ExpenseClaim claim = getClaimOrThrow(id);

        if (claim.getStatus() != ClaimStatus.PENDING) {
            throw new BusinessValidationException(
                "Only pending claims can be edited. This claim is already " + claim.getStatus() + ".");
        }

        claim.setEmployeeName(request.getEmployeeName());
        claim.setDepartment(request.getDepartment());
        claim.setExpenseCategory(request.getExpenseCategory());
        claim.setAmount(request.getAmount());
        claim.setExpenseDate(request.getExpenseDate());
        claim.setDescription(request.getDescription());

        return toResponse(claimRepository.save(claim));
    }

    @Transactional
    public void deleteClaim(Long id) {
        ExpenseClaim claim = getClaimOrThrow(id);

        if (claim.getStatus() != ClaimStatus.PENDING) {
            throw new BusinessValidationException(
                "Only pending claims can be withdrawn. This claim is already "
                + claim.getStatus() + " and cannot be deleted.");
        }

        claimRepository.delete(claim);
    }
}
