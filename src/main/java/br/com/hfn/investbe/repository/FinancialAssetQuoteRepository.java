package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.FinancialAssetQuote;
import br.com.hfn.investbe.model.pk.FinancialAssetQuotePK;

public interface FinancialAssetQuoteRepository extends JpaRepository<FinancialAssetQuote, FinancialAssetQuotePK>{

}
