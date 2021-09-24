package br.com.hfn.investbe.commom.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.hfn.investbe.commom.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
