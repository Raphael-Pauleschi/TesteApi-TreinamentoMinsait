package com.minsait.emprestimo.entity;

import java.util.Date;

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
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpfCliente;
	private Double ValorInicial;
	private Double ValorFinal;
	private Date DataInicial;
	private Date DataFinal;
	private Relation relation;
	
	public Loan(String cpfCliente, Double valorInicial, Double valorFinal, Date dataInicial, Date dataFinal,
			Relation relation) {
		this.cpfCliente = cpfCliente;
		ValorInicial = valorInicial;
		ValorFinal = valorFinal;
		DataInicial = dataInicial;
		DataFinal = dataFinal;
		this.relation = relation;
	}
	
	
	
	
	
}
