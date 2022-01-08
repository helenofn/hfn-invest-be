package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {

}
