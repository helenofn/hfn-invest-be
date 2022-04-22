package br.com.hfn.investbe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.model.FinancialTransaction;
import br.com.hfn.investbe.model.Wallet;
import br.com.hfn.investbe.repository.FinancialTransactionRepository;
import br.com.hfn.investbe.repository.WalletRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletService {

	private final WalletRepository walletRepository;
	private final FinancialTransactionRepository financialTransactionRepository;
	
	public Wallet save(Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	public FinancialTransaction addTransaction(FinancialTransaction financialTransaction) {
		return financialTransactionRepository.save(financialTransaction);
	}
	
	public List<FinancialTransaction> addTransactions(List<FinancialTransaction> financialTransactions) {
		return financialTransactionRepository.saveAll(new ArrayList<>(financialTransactions));
	}
	
	
}
