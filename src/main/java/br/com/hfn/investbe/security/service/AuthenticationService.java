package br.com.hfn.investbe.security.service;

import br.com.hfn.investbe.security.dto.AuthenticationResponseDTO;

public interface AuthenticationService {

	public AuthenticationResponseDTO authenticate(String username, String password);
}
