package com.minsait.emprestimo.dto;

import com.minsait.emprestimo.entity.Client;

public class ClientDTO {
	private String phoneNumber;
	private Long monthlyIncome;
	private String cep;
	private String street;
	private String number;
	
	public ClientDTO() {}

	public static ClientDTO returnClient(Client client) {
		ClientDTO clientDTO = new ClientDTO(
				client.getPhoneNumber(), 
				client.getMonthlyIncome(), client.getCep(),
				client.getStreet(), client.getNumber()
				);
		return clientDTO;
	}
	
	public static Client returnClient(ClientDTO clientDTO) {
		Client client = new Client(
				clientDTO.getPhoneNumber(),
				clientDTO.getMonthlyIncome(),clientDTO.getCep(),
				clientDTO.getStreet(), clientDTO.getNumber());
		return client;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	
	
	public ClientDTO(String phoneNumber, Long monthlyIncome, String cep, String street, String number) {
		super();
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.street = street;
		this.number = number;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
