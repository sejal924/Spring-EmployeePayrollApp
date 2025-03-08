package com.bridgelabz.employeepayrollapp.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler{
	private static final String message = "Exception while processing REST Request";
	 @ExceptionHandler(HttpMessageNotReadableException.class)
	    public ResponseEntity<Map<String,String>> handleHttpMessageNotReadableException(
	            HttpMessageNotReadableException exception){
	        log.error("Invalid Date format ", exception);
	        Map<String,String> response=new HashMap<>();
	        String message="Exception while processing REST Request";
	        String messageResponse="Should have Date in the  format dd MMM yyyy";
	        response.put(message,messageResponse);
	        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	    }
@ExceptionHandler (MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,Object>> handleValidationException(MethodArgumentNotValidException ex){
    Map<String,String> errors=new HashMap<>();

    for (FieldError error:ex.getBindingResult().getFieldErrors()){
        errors.put(error.getField(),error.getDefaultMessage());
    }

    Map<String,Object> response=new HashMap<>();
    response.put("status", HttpStatus.BAD_REQUEST.value());
    response.put("message","Validation failed for one or more fields.");
    response.put("errors",errors);

    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
}


@ExceptionHandler(EmployeePayrollException.class)
public ResponseEntity<Map<String, Object>> handleEmployeeNotFoundException(EmployeePayrollException ex) {
    Map<String, Object> response = new HashMap<>();
    response.put("status", HttpStatus.NOT_FOUND.value());
    response.put("message", ex.getMessage());

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}

}