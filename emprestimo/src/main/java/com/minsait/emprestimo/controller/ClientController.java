package com.minsait.emprestimo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.dto.ClientDTO;
import com.minsait.emprestimo.entity.Client;
import com.minsait.emprestimo.exception.ClientNotFoundException;
import com.minsait.emprestimo.service.ClientService;

@RestController
@RequestMapping("api/v1/loan-manager/clients")
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
	
	@GetMapping
	public List<Client> returnAllClient() {
		List<Client> clientList = this.clientService.returnAllClients();
		return clientList;
	}
	
	
	@GetMapping("/{cpf}")
	public Client retunOneClient(@PathVariable String cpf) throws ClientNotFoundException {
		Client clientReturn = this.clientService.returnOneClient(cpf);
		return clientReturn;
	}
	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClient(@PathVariable String cpf) {
		this.clientService.deleteClient(cpf);
	}
	
	@PutMapping("/{cpf}")
	public ClientDTO updateClient(@PathVariable String cpf, @Valid @RequestBody ClientDTO client) throws ClientNotFoundException {
		Client clientRequest = ClientDTO.returnClient(client);
		Client clientModified = this.clientService.updateClient(cpf, clientRequest);
		
		
		return ClientDTO.returnClient(clientModified);
	}
	
	
}
