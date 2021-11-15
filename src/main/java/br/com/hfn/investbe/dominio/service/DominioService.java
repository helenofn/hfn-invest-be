package br.com.hfn.investbe.dominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.UserStatus;
import br.com.hfn.investbe.repository.RoleRepository;
import br.com.hfn.investbe.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DominioService {

	private final UserStatusRepository userStatusRepository;
	private final RoleRepository roleRepository;
	
	public Optional<List<UserStatus>> userStatusListAll(){
		return Optional.ofNullable(userStatusRepository.findAll());
	}
	
	public Optional<List<Role>> roleListAll(){
		return Optional.ofNullable(roleRepository.findAll());
	}
}
