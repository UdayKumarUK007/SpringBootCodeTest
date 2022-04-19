package com.mbi.chatroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NO_CONTENT, reason="Invalid Creator")
public class UnknownCreatorException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnknownCreatorException(String message) {
		super(message);
	}

	public UnknownCreatorException(String message, Throwable exception) {
		super(message);
	}
}
