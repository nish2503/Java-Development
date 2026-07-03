package com.expenseapp.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class DepartmentBudgetRequest {

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "Month is required")
    @Min(value = 1, message = "Month must be between 1 and 12")
    @Max(value = 12, message = "Month must be between 1 and 12")
    private Integer month;

    @NotNull(message = "Year is required")
    @Min(value = 2000, message = "Year must be 2000 or later")
    @Max(value = 2100, message = "Year must be 2100 or earlier")
    private Integer year;

    @NotNull(message = "Budget amount is required")
    @DecimalMin(value = "0.01", message = "Budget amount must be greater than zero")
    @DecimalMax(value = "99999999.99", message = "Budget amount cannot exceed 9,99,99,999.99")
    @Digits(integer = 8, fraction = 2, message = "Budget must have at most 8 integer digits and 2 decimal places")
    private BigDecimal budgetAmount;

    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        this.department = department != null ? department.trim() : null;
    }

    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public BigDecimal getBudgetAmount() { return budgetAmount; }
    public void setBudgetAmount(BigDecimal budgetAmount) { this.budgetAmount = budgetAmount; }
}