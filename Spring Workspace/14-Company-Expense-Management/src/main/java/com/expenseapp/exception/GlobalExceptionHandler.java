package com.expenseapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Map<String, Object> baseBody(String error) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", error);
        body.put("timestamp", LocalDateTime.now().toString());
        return body;
    }

    // Bean validation (@Valid) errors -> field level messages
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> body = baseBody("Validation failed");
        Map<String, String> details = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                details.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        body.put("details", details);
        return ResponseEntity.badRequest().body(body);
    }

    // Claim not found / budget not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        Map<String, Object> body = baseBody(ex.getMessage());
        body.put("details", Map.of());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // Invalid status transitions, budget exceeded, etc.
    @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessValidation(BusinessValidationException ex) {
        Map<String, Object> body = baseBody(ex.getMessage());
        body.put("details", Map.of());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    // Duplicate department+month+year budget
    @ExceptionHandler(DuplicateBudgetException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicateBudget(DuplicateBudgetException ex) {
        Map<String, Object> body = baseBody(ex.getMessage());
        body.put("details", Map.of());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    // Catch-all so no raw stack trace ever reaches the client
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        Map<String, Object> body = baseBody("An unexpected error occurred");
        body.put("details", Map.of("message", ex.getMessage() == null ? "" : ex.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
