package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class LoanCannotBeRegisterException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoanCannotBeRegisterException () {
		super(String.format("Limit has been reached"));
	}
}
