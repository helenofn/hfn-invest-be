package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.FinancialAsset;

public interface FinancialAssetRepository extends JpaRepository<FinancialAsset, Long>{

}
