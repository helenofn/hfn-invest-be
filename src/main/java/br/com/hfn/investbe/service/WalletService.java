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
	
	public void calculateWalletById(Long walletId) {
		//TODO calcular por ativo:
		//1 - Qtd
		//2 - Preço médio
		//OBS: Levar em consideração os eventos financeiros de cada ativo (desdobramento, agrupamento, bonificação, etc.)
		// Obter as transações ordenadas por ativo e data de ocorrencia
		// Obter os eventos contábeis dos ativos ordenados por data de ocorrencia
		// Odernar as transações + eventos contábeis por dara de ocorrencia
		// Calcular qtd e preço médio por ativo
		// Salvar item
	}
}
