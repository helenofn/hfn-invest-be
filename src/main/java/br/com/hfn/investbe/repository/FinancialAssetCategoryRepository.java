package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.hfn.investbe.model.FinancialAssetCategory;

public interface FinancialAssetCategoryRepository extends JpaRepository<FinancialAssetCategory, Integer>, JpaSpecificationExecutor<FinancialAssetCategory>{

	
}
