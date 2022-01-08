package br.com.hfn.investbe.response.dto;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponseDTO extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -4742465532751221671L;
	
	private UserResponseDTO user;
	
	public AuthenticationResponseDTO(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, UserResponseDTO user) {
		super(principal, credentials, authorities);
		this.user = user;
	}

	
	
	

}
