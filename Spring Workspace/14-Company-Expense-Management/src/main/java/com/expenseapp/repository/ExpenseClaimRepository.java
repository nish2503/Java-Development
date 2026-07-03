package com.expenseapp.repository;

import com.expenseapp.entity.ExpenseClaim;
import com.expenseapp.enums.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Long> {

    @Query("""
            SELECT c FROM ExpenseClaim c
            WHERE (:department IS NULL OR c.department = :department)
            AND (:status IS NULL OR c.status = :status)
            AND (:category IS NULL OR c.expenseCategory = :category)
            AND (:month IS NULL OR FUNCTION('MONTH', c.expenseDate) = :month)
            AND (:year IS NULL OR FUNCTION('YEAR', c.expenseDate) = :year)
            ORDER BY c.createdAt DESC
            """)
    List<ExpenseClaim> search(
            @Param("department") String department,
            @Param("status") ClaimStatus status,
            @Param("category") String category,
            @Param("month") Integer month,
            @Param("year") Integer year
    );

    @Query("""
            SELECT COALESCE(SUM(c.amount), 0) FROM ExpenseClaim c
            WHERE c.department = :department
            AND c.status = :status
            AND FUNCTION('MONTH', c.expenseDate) = :month
            AND FUNCTION('YEAR', c.expenseDate) = :year
            """)
    BigDecimal sumByDepartmentAndStatusAndMonthYear(
            @Param("department") String department,
            @Param("status") ClaimStatus status,
            @Param("month") Integer month,
            @Param("year") Integer year
    );

    @Query("""
            SELECT COUNT(c) FROM ExpenseClaim c
            WHERE c.department = :department
            AND c.status = :status
            AND FUNCTION('MONTH', c.expenseDate) = :month
            AND FUNCTION('YEAR', c.expenseDate) = :year
            """)
    long countByDepartmentAndStatusAndMonthYear(
            @Param("department") String department,
            @Param("status") ClaimStatus status,
            @Param("month") Integer month,
            @Param("year") Integer year
    );
}
