package com.cg.employeepayroll.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.employeepayroll.dto.ResponseDTO;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
				 					MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessages = errorList.stream()
									.map(errorObject -> errorObject.getDefaultMessage())
									.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while handling REST Request", errorMessages);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}