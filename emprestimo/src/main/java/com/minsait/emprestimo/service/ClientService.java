package com.minsait.emprestimo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Client;
import com.minsait.emprestimo.repository.ClientRepository;

@Service
public class ClientService {
	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	public Client registerClient(Client client) {
		Client clientReturn = this.clientRepository.save(client);
		return clientReturn;
	}
	
}
