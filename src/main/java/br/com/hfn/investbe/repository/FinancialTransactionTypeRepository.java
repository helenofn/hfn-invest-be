package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.FinancialTransactionEventType;

public interface FinancialTransactionTypeRepository extends JpaRepository<FinancialTransactionEventType, Integer>{

}
