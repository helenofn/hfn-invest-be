package br.com.hfn.investbe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.hfn.investbe.model.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Integer>, JpaSpecificationExecutor<Broker>{

	public Optional<Broker> findByEin(String ein);
	
	public Optional<Broker> findByInternalId(Integer internalId);
}
