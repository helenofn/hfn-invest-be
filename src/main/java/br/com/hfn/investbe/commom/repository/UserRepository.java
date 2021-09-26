package br.com.hfn.investbe.commom.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.hfn.investbe.commom.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public Optional<User> findByEmail(String email);
}
