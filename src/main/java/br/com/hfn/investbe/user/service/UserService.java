package br.com.hfn.investbe.user.service;

import br.com.hfn.investbe.commom.model.User;
import br.com.hfn.investbe.commom.security.dto.AuthenticationResponseDTO;

public interface UserService {

	public AuthenticationResponseDTO authenticate(String username, String password);
	
	public User save(User user);
	
	public User findById(Long id);
	
}
