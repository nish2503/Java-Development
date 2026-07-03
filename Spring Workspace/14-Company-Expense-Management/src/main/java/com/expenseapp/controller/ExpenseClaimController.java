package com.expenseapp.controller;

import com.expenseapp.dto.ExpenseClaimRequest;
import com.expenseapp.dto.ExpenseClaimResponse;
import com.expenseapp.dto.ReviewRequest;
import com.expenseapp.service.ExpenseClaimService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ExpenseClaimController {

    private final ExpenseClaimService claimService;

    public ExpenseClaimController(ExpenseClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ResponseEntity<ExpenseClaimResponse> submitClaim(@Valid @RequestBody ExpenseClaimRequest request) {
        ExpenseClaimResponse response = claimService.submitClaim(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseClaimResponse>> getClaims(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String category
    ) {
        List<ExpenseClaimResponse> claims = claimService.getClaims(department, status, category, month, year);
        return ResponseEntity.ok(claims);
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<ExpenseClaimResponse> approveClaim(
            @PathVariable Long id,
            @RequestBody(required = false) ReviewRequest request
    ) {
        ExpenseClaimResponse response = claimService.approveClaim(id, request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<ExpenseClaimResponse> rejectClaim(
            @PathVariable Long id,
            @RequestBody(required = false) ReviewRequest request
    ) {
        ExpenseClaimResponse response = claimService.rejectClaim(id, request);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseClaimResponse> updateClaim(
            @PathVariable Long id,
            @Valid @RequestBody ExpenseClaimRequest request) {
        return ResponseEntity.ok(claimService.updateClaim(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}
