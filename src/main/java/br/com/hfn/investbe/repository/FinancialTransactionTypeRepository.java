package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.FinancialTransactionType;

public interface FinancialTransactionTypeRepository extends JpaRepository<FinancialTransactionType, Integer>{

}
