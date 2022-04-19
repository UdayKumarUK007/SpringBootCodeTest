package com.mbi.chatroom.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NO_CONTENT, reason="Invalid GroupId")
public class UnknownGroupIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnknownGroupIdException(String message) {
		super(message);
	}

	public UnknownGroupIdException(String message, Throwable exception) {
		super(message);
	}
}
