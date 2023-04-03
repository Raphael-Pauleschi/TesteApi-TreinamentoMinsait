package com.minsait.emprestimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Client;
import com.minsait.emprestimo.entity.Loan;
import com.minsait.emprestimo.entity.Relation;
import com.minsait.emprestimo.exception.LoanCannotBeRegisterException;
import com.minsait.emprestimo.exception.LoanNotFoundException;
import com.minsait.emprestimo.repository.ClientRepository;
import com.minsait.emprestimo.repository.LoanRepository;

@Service
public class LoanService {
	private final LoanRepository loanRepository;
	private final ClientRepository clientRepository;

	@Autowired
	public LoanService(LoanRepository loanRepository, ClientRepository clientRepository) {
		this.loanRepository = loanRepository;
		this.clientRepository = clientRepository;
	}

	public Loan registerLoan(String cpf, Loan loan) throws LoanCannotBeRegisterException {
		Client client = clientRepository.findById(cpf).get();

		if ((10 * client.getMonthlyIncome()) > (calculateLimit(cpf))) {
			loan.setValorFinal(calculateValorFinal(loan, cpf));
			Loan loanReturn = loanRepository.save(loan);
			return loanReturn;
		}

		throw new LoanCannotBeRegisterException();
	}

	public List<Loan> returnAllLoan(String cpf) {
		List<Loan> loanList = loanRepository.findAllByCpfCliente(cpf);
		return loanList;
	}

	//Calcular o valor final com base no relacionamento
	private Double calculateValorFinal(Loan loan, String cpf) {
		Double valorFinal = 0.0;
		
		if (loan.getRelation() == Relation.BRONZE) {
			valorFinal = loan.getValorInicial() * 1.8;
		} else if (loan.getRelation() == Relation.PRATA) {
			if(loan.getValorInicial() > 5000)
				valorFinal = loan.getValorInicial() * 1.4;
			else
				valorFinal = loan.getValorInicial() * 1.6;
		} else if (loan.getRelation() == Relation.OURO) {
			if(returnAllLoan(cpf).size() == 1)
				valorFinal = loan.getValorInicial() * 1.2;
			else
				valorFinal = loan.getValorInicial() * 1.3;
		}

		return valorFinal;
	}

	//Verificar se  o limite foi ultrapassado
	private Double calculateLimit(String cpf) {
		Double value = 0.0;
		List<Loan> loanList = this.returnAllLoan(cpf);

		for (Loan loan : loanList) {
			value += loan.getValorInicial();
		}

		return value;
	}

	public Loan returnOneLoan(String cpf, Long id) throws LoanNotFoundException {
		if (loanRepository.existsById(id)) {
			Loan loanReturn = loanRepository.findByIdAndCpfCliente(id, cpf);
			return loanReturn;
		}
		throw new LoanNotFoundException(id);
	}

	public void deleteLoan(String cpf, Long id) {
		loanRepository.deleteByIdAndCpfCliente(id, cpf);
	}

}
