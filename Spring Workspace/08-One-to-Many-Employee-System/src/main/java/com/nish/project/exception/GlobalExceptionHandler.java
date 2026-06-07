package com.nish.project.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException e){
		logger.error(e.getMessage());
		return response(HttpStatus.NOT_FOUND,e.getMessage());
	}

	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<?> handleDuplicateResource(DuplicateResourceException e){
		logger.error(e.getMessage());
		return response(HttpStatus.CONFLICT,e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidation(MethodArgumentNotValidException e){
		Map<String,Object> map=new HashMap<>();
		map.put("timestamp",LocalDateTime.now());
		map.put("status",400);
		map.put("error","BAD_REQUEST");

		Map<String,String> errors=new HashMap<>();

		e.getBindingResult().getFieldErrors().forEach(error->
			errors.put(error.getField(),error.getDefaultMessage()));

		map.put("messages",errors);

		logger.error("Validation failed");

		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrity(DataIntegrityViolationException e){
		logger.error(e.getMessage());
		return response(HttpStatus.BAD_REQUEST,"Database constraint violation");
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handleAccessDenied(AccessDeniedException e){
		logger.error(e.getMessage());
		return response(HttpStatus.FORBIDDEN,"Access denied");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneric(Exception e){
		logger.error(e.getMessage());
		return response(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
	}

	private ResponseEntity<?> response(HttpStatus status,String message){

		Map<String,Object> map=new HashMap<>();

		map.put("timestamp",LocalDateTime.now());
		map.put("status",status.value());
		map.put("error",status.name());
		map.put("message",message);

		return new ResponseEntity<>(map,status);
	}
}