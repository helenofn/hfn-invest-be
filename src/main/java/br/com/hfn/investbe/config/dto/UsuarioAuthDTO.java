package br.com.hfn.investbe.config.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import br.com.hfn.investbe.enums.RoleEnum;
import br.com.hfn.investbe.model.Role;
import br.com.hfn.investbe.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAuthDTO extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = -7204534684207673943L;

	private User user;
	
	public UsuarioAuthDTO(Object principal, Object credentials, Collection<GrantedAuthority> authorities, User user) {
		super(principal, credentials, authorities);
	    this.user = user;
	}
	
	public final List<Role> getRoles() {
		List<Role> listaRole = new ArrayList<Role>();
		for (GrantedAuthority g : getAuthorities()) {
			listaRole.add(RoleEnum.getRoleByName(g.getAuthority()));
		}
		return listaRole;
	}
}
