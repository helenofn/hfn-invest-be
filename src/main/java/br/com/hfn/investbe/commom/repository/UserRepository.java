package br.com.hfn.investbe.commom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.commom.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public Optional<User> findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmail(String email);
}
