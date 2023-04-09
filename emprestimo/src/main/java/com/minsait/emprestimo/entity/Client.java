package com.minsait.emprestimo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {
	@Id
	@CPF
	private String cpf;
	private String phoneNumber;
	private Long monthlyIncome;
	
	//Address

	private String cep;
	private String streetName;
	private String streetNumber;
	
	public Client(String cpf, String phoneNumber, Long monthlyIncome, String cep, String streetName, String streetNumber) {
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
	}

	public Client(String phoneNumber, Long monthlyIncome, String cep, String streetName, String streetNumber) {
		super();
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
	}
	
	
	
	
	
}
