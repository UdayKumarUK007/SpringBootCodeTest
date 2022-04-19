package com.mbi.chatroom.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ChatRoomExceptionHanlder extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {UnknownCreatorException.class})
	public ResponseEntity<Object> handleNoCreatorException(Exception ex){
		String errorMessage = "No Content";
		return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(value = {InvalidRequestException.class})
	public ResponseEntity<Object> handleInvalidRequestException(Exception ex){
		String errorMessage="BAD Request";
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyExcpetion(Exception ex){
		String errorMessage="Internal Server Error";
		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
