package com.minsait.emprestimo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Client;
import com.minsait.emprestimo.service.ClientService;

@RestController
@RequestMapping("api/v1/emprestimo/client")
public class ClientController {

	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client registerClient(@Valid @RequestBody Client client) {
		Client clientSaved = this.clientService.registerClient(client);
		return clientSaved;
		
	}
	
}
