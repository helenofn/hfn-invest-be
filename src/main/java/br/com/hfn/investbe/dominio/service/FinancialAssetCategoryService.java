package br.com.hfn.investbe.dominio.service;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import br.com.hfn.investbe.repository.FinancialAssetCategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinancialAssetCategoryService {

	private final FinancialAssetCategoryRepository financialAssetCategoryRepository;
	
	public FinancialAssetCategory save(FinancialAssetCategory obj) {
		return financialAssetCategoryRepository.save(obj);
	}
}
