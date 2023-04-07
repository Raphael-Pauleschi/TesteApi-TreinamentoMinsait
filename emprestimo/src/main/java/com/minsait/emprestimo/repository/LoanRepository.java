package com.minsait.emprestimo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minsait.emprestimo.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findAllByCpfClient(String cpfClient);
	Loan findByIdAndCpfClient(Long id, String cpfClient);
	void deleteByIdAndCpfClient(Long id, String CpfClient);


}
