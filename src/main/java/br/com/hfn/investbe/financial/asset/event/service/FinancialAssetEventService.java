package br.com.hfn.investbe.financial.asset.event.service;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.model.FinancialAssetEvent;
import br.com.hfn.investbe.repository.FinancialAssetEventRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinancialAssetEventService {

	private final FinancialAssetEventRepository financialAssetEventRepository;
	
	public void save(FinancialAssetEvent obj) {
		financialAssetEventRepository.save(obj);
	}
	
	public FinancialAssetEvent findById(Long id) {
		return financialAssetEventRepository.findById(id).orElseGet(null);
	}
}
