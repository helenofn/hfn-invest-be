package br.com.hfn.investbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfn.investbe.model.user.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
