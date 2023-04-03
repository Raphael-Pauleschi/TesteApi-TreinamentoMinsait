package com.minsait.emprestimo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.emprestimo.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findAllByCpfCliente(String cpfCliente);
	Loan findByIdAndCpfCliente(Long id, String cpfCliente);
	void deleteByIdAndCpfCliente(Long id, String CpfCliente);


}
