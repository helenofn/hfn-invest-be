package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.UserStatus;

public interface UserStatusRepository extends JpaRepository<UserStatus, Long>{

}
