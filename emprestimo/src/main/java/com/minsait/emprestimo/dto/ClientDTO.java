package com.minsait.emprestimo.dto;

import com.minsait.emprestimo.entity.Client;

public class ClientDTO {
	private String phoneNumber;
	private Long monthlyIncome;
	private String cep;
	private String streetName;
	private String streetNumber;
	
	public ClientDTO() {}

	public static ClientDTO returnClient(Client client) {
		ClientDTO clientDTO = new ClientDTO(
				client.getPhoneNumber(), 
				client.getMonthlyIncome(), client.getCep(),
				client.getStreetName(), client.getStreetNumber()
				);
		return clientDTO;
	}
	
	public static Client returnClient(ClientDTO clientDTO) {
		Client client = new Client(
				clientDTO.getPhoneNumber(),
				clientDTO.getMonthlyIncome(),clientDTO.getCep(),
				clientDTO.getStreetName(), clientDTO.getStreetNumber());
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

	
	
	public ClientDTO(String phoneNumber, Long monthlyIncome, String cep, String streetName, String streetNumber) {
		super();
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	
	
}
