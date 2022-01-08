package br.com.hfn.investbe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.hfn.investbe.model.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>{

	public Optional<User> findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmail(String email);
	//public Page<User> findAll(Specification<User> specification, PageRequest pageRequest);
	
	//public Page<User> findAllPage(Specification<User> spec, Pageable pageable);
}
