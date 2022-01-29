package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
