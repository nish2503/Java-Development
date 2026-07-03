package com.expenseapp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(
    name = "department_budgets",
    uniqueConstraints = @UniqueConstraint(
        name = "uq_department_month_year",
        columnNames = {"department", "month", "year"}
    )
)
public class DepartmentBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Integer month;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal budgetAmount;

    public DepartmentBudget() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public BigDecimal getBudgetAmount() { return budgetAmount; }
    public void setBudgetAmount(BigDecimal budgetAmount) { this.budgetAmount = budgetAmount; }
}
