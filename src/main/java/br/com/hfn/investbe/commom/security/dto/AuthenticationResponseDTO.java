package br.com.hfn.investbe.commom.security.dto;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import br.com.hfn.investbe.common.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponseDTO extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -4742465532751221671L;
	
	private UserDTO user;
	
	public AuthenticationResponseDTO(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, UserDTO user) {
		super(principal, credentials, authorities);
		this.user = user;
	}

	
	
	

}
