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
	private Double valorInicial;
	private Double valorFinal;
	private Date dataInicial;
	private Date dataFinal;
	private Relation relation;
	
	
	public Loan( Double valorInicial, Double valorFinal, Date dataInicial, Date dataFinal,
			Relation relation) {
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.relation = relation;
	}
	
}
