package br.com.hfn.investbe.security.enums;

import br.com.hfn.investbe.model.user.Role;
import lombok.Getter;

@Getter
public enum RoleEnum {

	COMMOM(1,"COMMON"),
	ADM(2,"ADM");
	
	private Integer codigo;
	private String key;
	private Role model;
	
	private RoleEnum(Integer codigo, String key) {
		this.codigo = codigo;
		this.key = key;
		this.model = new Role(codigo,key,null);
	}
	
	public String getKey() {
		return this.key.replace("ROLE_", "");
	}
}
