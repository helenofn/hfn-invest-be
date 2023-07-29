package br.com.hfn.investbe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfn.investbe.model.FinancialAssetEvent;

public interface FinancialAssetEventRepository extends JpaRepository<FinancialAssetEvent, Long>{

	@Query("SELECT "
			+ "e from FinancialAssetEvent e "
			+ "left join fetch e.financialAsset f "
			+ "left join fetch f.company c "
			+ "where e.cseqId = :id ")
	Optional<FinancialAssetEvent> findById(Long id);
}
