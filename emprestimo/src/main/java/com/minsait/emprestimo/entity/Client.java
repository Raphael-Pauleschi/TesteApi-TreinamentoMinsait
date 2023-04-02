package com.minsait.emprestimo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {
	@Id
	private String cpf;
	private String phoneNumber;
	private Long monthlyIncome;
	
	//Address
	private String cep;
	private String street;
	private String number;
	
	public Client(String cpf, String phoneNumber, Long monthlyIncome, String cep, String street, String number) {
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.street = street;
		this.number = number;
	}

	public Client(String phoneNumber, Long monthlyIncome, String cep, String street, String number) {
		super();
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.street = street;
		this.number = number;
	}
	
	
	
	
	
}
