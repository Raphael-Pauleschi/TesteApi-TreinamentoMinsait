package com.minsait.emprestimo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Client;
import com.minsait.emprestimo.entity.Loan;
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

		if (validateLimit(client)) {
			loan.setFinalValue(calculateFinalValue(loan));
			Loan loanReturn = loanRepository.save(loan);
			return loanReturn;
		}

		throw new LoanCannotBeRegisterException();
	}

	public List<Loan> returnAllLoan(String cpf) { 
		List<Loan> loanList = loanRepository.findAllByCpfClient(cpf);
		return loanList;
	}

	//Calcular o valor final com base no relacionamento
	private Double calculateFinalValue(Loan loan) {

		return loan.getRelation().calculateFinalValue(loan, 
				loanRepository.findAllByCpfClient(loan.getCpfClient()).size() <= 1 ?
						true : false);
	}

	//Verificar se  o limite foi ultrapassado
	private boolean validateLimit(Client client) {
		Double limitValue = 0.0;
		List<Loan> loanList = this.returnAllLoan(client.getCpf());

		for (Loan loan : loanList) {
			limitValue += loan.getInitialValue();
		}

		if ((10 * client.getMonthlyIncome()) > limitValue)
		return true;
		
		return false;
	}

	public Loan returnOneLoan(String cpf, Long id) throws LoanNotFoundException {
		if (loanRepository.existsById(id)) {
			Loan loanReturn = loanRepository.findByIdAndCpfClient(id, cpf);
			return loanReturn;
		}
		throw new LoanNotFoundException(id);
	}

	@Transactional
	public void deleteLoan(String cpf, Long id) {
		loanRepository.deleteByIdAndCpfClient(id, cpf);
	}

}
