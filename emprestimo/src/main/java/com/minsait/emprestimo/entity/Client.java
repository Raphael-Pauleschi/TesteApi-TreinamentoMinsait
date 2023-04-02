package com.minsait.emprestimo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cpf;
	private String phoneNumber;
	//private Address address;
	private double monthlyIncome;
	
	public Client(String cpf, String phoneNumber, double monthlyIncome) {
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.monthlyIncome = monthlyIncome;
	}
	
	/*
	public Client(String cpf, String phoneNumber, Address address, double monthlyIncome) {
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.monthlyIncome = monthlyIncome;
	}
	*/
	
}
