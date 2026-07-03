package com.expenseapp.controller;

import com.expenseapp.dto.SummaryResponse;
import com.expenseapp.service.SummaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    private final SummaryService summaryService;

    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping
    public ResponseEntity<SummaryResponse> getSummary(
            @RequestParam String department,
            @RequestParam Integer month,
            @RequestParam Integer year
    ) {
        SummaryResponse response = summaryService.getSummary(department, month, year);
        return ResponseEntity.ok(response);
    }
}
