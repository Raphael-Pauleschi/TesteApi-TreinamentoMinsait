package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Client;
import com.minsait.emprestimo.exception.ClientNotFoundException;
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

	public List<Client> returnAllClients() {
		return this.clientRepository.findAll();
	}

	public Client returnOneClient(String cpf) throws ClientNotFoundException {
		if (this.clientRepository.existsById(cpf)) {
			Client clientReturn = this.clientRepository.findById(cpf).get();
			return clientReturn;
		}

		throw new ClientNotFoundException(cpf);

	}

	public void deleteClient(String cpf) {
		clientRepository.deleteById(cpf);

	}

	public Client updateClient(String cpf, Client client) throws ClientNotFoundException {
		Client clientToBeModified = returnOneClient(cpf);

		client.setCpf(cpf);

		client.setMonthlyIncome(
				client.getMonthlyIncome() == null ? clientToBeModified.getMonthlyIncome() : client.getMonthlyIncome());
		client.setPhoneNumber(
				client.getPhoneNumber() == null ? clientToBeModified.getPhoneNumber() : client.getPhoneNumber());
		client.setStreetName(
				client.getStreetName() == null ? clientToBeModified.getStreetName() : client.getStreetName());
		client.setStreetNumber(
				client.getStreetNumber() == null ? clientToBeModified.getStreetNumber() : client.getStreetNumber());
		client.setCep(client.getCep() == null ? clientToBeModified.getCep() : client.getCep());

		return this.clientRepository.save(client);
	}

}
