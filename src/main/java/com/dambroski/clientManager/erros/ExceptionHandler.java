package com.dambroski.clientManager.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<ErrorMessage> ClientNotFoundException(ClientNotFoundException exception
			, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ClientSessionNotFoundException.class)
	public ResponseEntity<ErrorMessage> ClientSessionNotFoundException(ClientSessionNotFoundException exception
			, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ClientSessionsDaysNotFoundException.class)
	public ResponseEntity<ErrorMessage> ClientSessionDaysNotFoundException(ClientSessionsDaysNotFoundException
			exception, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(PagamentNotFoundException.class)
	public ResponseEntity<ErrorMessage> PagamentNotFoundException(PagamentNotFoundException
			exception, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> UserNotFoundException(UserNotFoundException
			exception, WebRequest request){
		
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
}