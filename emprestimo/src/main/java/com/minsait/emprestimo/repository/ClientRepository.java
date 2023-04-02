package com.minsait.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.minsait.emprestimo.entity.Client;

public interface ClientRepository extends JpaRepository<Client,String> {

}
