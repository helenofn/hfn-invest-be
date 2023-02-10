package br.com.hfn.investbe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.hfn.investbe.model.FinancialAssetCategory;

public interface FinancialAssetCategoryRepository extends JpaRepository<FinancialAssetCategory, Integer>, JpaSpecificationExecutor<FinancialAssetCategory>{

	public Optional<List<FinancialAssetCategory>> findByName(String name);
}
