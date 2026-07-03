package com.expenseapp.controller;

import com.expenseapp.dto.DepartmentBudgetRequest;
import com.expenseapp.dto.DepartmentBudgetResponse;
import com.expenseapp.service.DepartmentBudgetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class DepartmentBudgetController {

    private final DepartmentBudgetService budgetService;

    public DepartmentBudgetController(DepartmentBudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping
    public ResponseEntity<DepartmentBudgetResponse> createBudget(@Valid @RequestBody DepartmentBudgetRequest request) {
        DepartmentBudgetResponse response = budgetService.createBudget(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentBudgetResponse>> getBudgets(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year
    ) {
        List<DepartmentBudgetResponse> budgets = budgetService.getBudgets(department, month, year);
        return ResponseEntity.ok(budgets);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentBudgetResponse> updateBudget(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentBudgetRequest request) {
        return ResponseEntity.ok(budgetService.updateBudget(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }
}
