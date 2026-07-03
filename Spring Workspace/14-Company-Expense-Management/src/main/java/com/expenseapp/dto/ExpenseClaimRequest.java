package com.expenseapp.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseClaimRequest {

    @NotBlank(message = "Employee name is required")
    @Pattern(
        regexp = "^[a-zA-Z\\s'.-]{2,100}$",
        message = "Employee name must contain only letters, spaces, hyphens, or apostrophes (2–100 characters)"
    )
    private String employeeName;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Expense category is required")
    private String expenseCategory;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    @DecimalMax(value = "9999999.99", message = "Amount cannot exceed 99,99,999.99")
    @Digits(integer = 7, fraction = 2, message = "Amount must have at most 7 integer digits and 2 decimal places")
    private BigDecimal amount;

    @NotNull(message = "Expense date is required")
    @PastOrPresent(message = "Expense date cannot be a future date")
    private LocalDate expenseDate;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    // Getters and setters with trimming on strings
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName != null ? employeeName.trim() : null;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        this.department = department != null ? department.trim() : null;
    }

    public String getExpenseCategory() { return expenseCategory; }
    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory != null ? expenseCategory.trim() : null;
    }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description != null ? description.trim() : null;
    }
}