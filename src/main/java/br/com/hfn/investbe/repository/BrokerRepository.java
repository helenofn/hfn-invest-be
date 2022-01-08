package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Long>{

}
