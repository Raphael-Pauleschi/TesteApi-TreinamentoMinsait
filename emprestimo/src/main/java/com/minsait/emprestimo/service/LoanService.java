package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Loan;
import com.minsait.emprestimo.repository.LoanRepository;

@Service
public class LoanService {
	private final LoanRepository loanRepository;

	@Autowired
	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	public Loan registerLoan(Loan loan) {
		Loan loanReturn = loanRepository.save(loan);
		return loanReturn;
	}

	public List<Loan> returnAllLoan(String cpf) {
		List<Loan> loanList = loanRepository.findAllByCpfCliente(cpf);
		return loanList;
	}
	
	public Loan returnOneLoan(String cpf, Long id) {
		Loan loanReturn = loanRepository.findByIdAndCpfCliente(id, cpf);
		return loanReturn;
	}
	
}
