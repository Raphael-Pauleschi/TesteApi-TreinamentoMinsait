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
	private String cpfClient;
	private Double initialValue;
	private Double finalValue;
	private Date initialDate;
	private Date finalDate;
	private Relation relation;
	public Loan(Double initialValue, Date initialDate, Date finalDate, Relation relation) {
		this.initialValue = initialValue;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.relation = relation;
	}
	
	
	
}
