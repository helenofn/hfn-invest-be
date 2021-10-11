package br.com.hfn.investbe.dominio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hfn.investbe.commom.model.UserStatus;
import br.com.hfn.investbe.commom.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DominioService {

	private final UserStatusRepository userStatusRepository;
	
	public List<UserStatus> userStatusListAll(){
		return userStatusRepository.findAll();
	}
	
}
