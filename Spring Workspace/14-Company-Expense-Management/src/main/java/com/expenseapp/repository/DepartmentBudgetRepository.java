package com.expenseapp.repository;

import com.expenseapp.entity.DepartmentBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentBudgetRepository extends JpaRepository<DepartmentBudget, Long> {

    Optional<DepartmentBudget> findByDepartmentAndMonthAndYear(String department, Integer month, Integer year);

    boolean existsByDepartmentAndMonthAndYear(String department, Integer month, Integer year);

    @Query("""
            SELECT b FROM DepartmentBudget b
            WHERE (:department IS NULL OR b.department = :department)
            AND (:month IS NULL OR b.month = :month)
            AND (:year IS NULL OR b.year = :year)
            ORDER BY b.year DESC, b.month DESC
            """)
    List<DepartmentBudget> search(
            @Param("department") String department,
            @Param("month") Integer month,
            @Param("year") Integer year
    );
}
