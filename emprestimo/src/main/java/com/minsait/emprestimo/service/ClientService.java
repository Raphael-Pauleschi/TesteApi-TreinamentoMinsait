package com.minsait.emprestimo.service;

import java.util.List;

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
	
	public List<Client> returnAllClients(){
		return this.clientRepository.findAll();
	}

	public Client returnOneClient(String cpf) {
		Client clientReturn = this.clientRepository.findById(cpf).get();
		return clientReturn;
	}

	public void deleteClient(String cpf) {
		clientRepository.deleteById(cpf);
		
	}
	
}
