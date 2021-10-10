package br.com.hfn.investbe.commom.security.service;

import br.com.hfn.investbe.commom.security.dto.AuthenticationResponseDTO;

public interface AuthenticationService {

	public AuthenticationResponseDTO authenticate(String username, String password);
}
