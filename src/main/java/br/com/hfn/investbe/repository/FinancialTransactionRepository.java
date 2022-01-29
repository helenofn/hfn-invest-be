package br.com.hfn.investbe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.FinancialTransaction;

public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Long>{

	public List<FinancialTransaction> findByWalletSeqId(Long walletId);
}
