package com.masaischool.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	
	  
	   @ExceptionHandler(NoHandlerFoundException.class)
	   public ResponseEntity<ErrorDetail> noHandlerFound(NoHandlerFoundException nhf,WebRequest wr){
		   log.error("NoHandlerFoundException : "+nhf.getHttpMethod()+" "+nhf.getRequestURL());
		   
		   
		    //builder lombok property to easily create objects
		   ErrorDetail ed = ErrorDetail.builder().message(nhf.getMessage()).uri(wr.getDescription(false)).build(); 
		   
		   return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		   
	   }
	   
	   @ExceptionHandler(Exception.class)
	   public ResponseEntity<ErrorDetail> exceptionFound(Exception nhf,WebRequest wr){
		   
		   log.error("An Exception occured");
		   ErrorDetail ed = ErrorDetail.builder().message(nhf.getMessage()).uri(wr.getDescription(false)).build();
		   
		   return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		   
	   }
	   
	   @ExceptionHandler(IllegalArgumentException.class)
	   public ResponseEntity<ErrorDetail> illegalExceptionFound(IllegalArgumentException nhf,WebRequest wr){
		   log.error("An IllegalArgumentException error occured");

		   ErrorDetail ed = ErrorDetail.builder().message(nhf.getMessage()).uri(wr.getDescription(false)).build();
		   
		   return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
		   
	   }
	   
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<List<String>> illegalExceptionFound(MethodArgumentNotValidException nhf,WebRequest wr){
		   
		   log.error("An Exception found in MethodArgumentNotValidException");
		   
		   List<ObjectError> allErrors = nhf.getAllErrors();
		   List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);
		   
		   return new ResponseEntity<>(errorsToStringList,HttpStatus.BAD_REQUEST);
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}
