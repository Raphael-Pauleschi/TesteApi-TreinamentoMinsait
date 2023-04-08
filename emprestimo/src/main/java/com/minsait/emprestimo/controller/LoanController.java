package com.minsait.emprestimo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.entity.Loan;
import com.minsait.emprestimo.exception.LoanCannotBeRegisterException;
import com.minsait.emprestimo.exception.LoanNotFoundException;
import com.minsait.emprestimo.service.LoanService;

@RestController
@RequestMapping("api/v1/loan-manager/clients")
public class LoanController {
	private LoanService loanService;

	@Autowired
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}
	
	@PostMapping("/{cpf}/loans")
	@ResponseStatus(HttpStatus.CREATED)
	public Loan registerLoan(@PathVariable("cpf") String cpf, @Valid @RequestBody Loan loan) throws LoanCannotBeRegisterException
	{
		loan.setCpfClient(cpf);
		return this.loanService.registerLoan(cpf,loan);
	}
	
	@GetMapping("/{cpf}/loans")
	public List<Loan> returnAllLoan(@PathVariable("cpf") String cpf) {
		return this.loanService.returnAllLoan(cpf);
	}
	
	@GetMapping("/{cpf}/loans/{id}")
	public Loan returnOneLoan(@PathVariable("cpf") String cpf, @PathVariable("id") Long id) throws LoanNotFoundException {
		return this.loanService.returnOneLoan(cpf, id);
	}
	
	@DeleteMapping("/{cpf}/loans/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLoan(@PathVariable("cpf") String cpf, @PathVariable("id") Long id) {
		 this.loanService.deleteLoan(cpf,id);
	}

}
