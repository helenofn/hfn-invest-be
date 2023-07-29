package br.com.hfn.investbe.financial.asset.event.service;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.model.FinancialAssetEventDividend;
import br.com.hfn.investbe.repository.FinancialAssetEventDividendRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinancialAssetEventDividendService {

	private final FinancialAssetEventDividendRepository financialAssetEventDividendRepository;
	
	public void save(FinancialAssetEventDividend obj) {
		financialAssetEventDividendRepository.save(obj);
	}
	
	public FinancialAssetEventDividend findById(Long id) {
		return financialAssetEventDividendRepository.findById(id).orElseGet(null);
	}
}
