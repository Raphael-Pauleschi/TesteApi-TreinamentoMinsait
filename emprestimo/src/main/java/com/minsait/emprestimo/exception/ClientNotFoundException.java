package com.minsait.emprestimo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ClientNotFoundException(String cpf) {
		super(String.format("Id %s not found", cpf));
	}
}
