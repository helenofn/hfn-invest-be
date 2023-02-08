package br.com.hfn.investbe.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import br.com.hfn.investbe.repository.FinancialAssetCategoryRepository;
import br.com.hfn.investbe.validator.annotations.InsertFinancialAssetCategory;
import lombok.RequiredArgsConstructor;

@Validated
@Service
@RequiredArgsConstructor
public class FinancialAssetCategoryService {

	private final FinancialAssetCategoryRepository financialAssetCategoryRepository;
	
	public FinancialAssetCategory insert(@Valid @InsertFinancialAssetCategory FinancialAssetCategory obj) {
		return financialAssetCategoryRepository.save(obj);
	}
	
	public Optional<FinancialAssetCategory> findById(Integer id) {
		return financialAssetCategoryRepository.findById(id);
	}
	
	public Optional<List<FinancialAssetCategory>> findByName(String name) {
		return financialAssetCategoryRepository.findByName(name);
	}
}
