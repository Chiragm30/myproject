package com.microservices.ui.Exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestGlobalException {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiError> RestGlobalExceptionhamdler(EmployeeNotFoundException e ,HttpServletRequest request )
	{
		ApiError aer=new ApiError();
		aer.setTimestamp(new Date());
		aer.setStatus(HttpStatus.NOT_FOUND.value());
		aer.setMessage(e.getMessage());
		aer.setError(HttpStatus.NOT_FOUND);
		aer.setPath(request.getRequestURI());
		return new ResponseEntity<ApiError>(aer,HttpStatus.NOT_FOUND);
	}
	
//model me jo message diye hai vo message error ke sath console me dikhne chahiye
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlerMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
//error with respective message console pe ana cahiye
		Map<String, String> resp =new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldname=((FieldError)error).getField();
		   String message=error.getDefaultMessage();
		   resp.put(fieldname, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
				
	}
	
}
