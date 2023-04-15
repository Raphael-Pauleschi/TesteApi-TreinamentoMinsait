package com.minsait.emprestimo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String phoneNumber;
	@NotNull
	private Long monthlyIncome;
	@NotNull
	private String name;
	
	//Address
	@NotNull
	private String cep;
	@NotNull
	private String streetName;
	@NotNull
	private String streetNumber;
	
	public Client(String cpf, String phoneNumber, Long monthlyIncome, String cep, String streetName, String streetNumber, String name) {
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.name = name;
	}

	public Client(String phoneNumber, Long monthlyIncome, String cep, String streetName, String streetNumber, String name) {
		super();
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
		this.cep = cep;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.name = name;
	}
	
	
	
	
	
}
