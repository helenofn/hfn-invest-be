package br.com.hfn.investbe.enums;

import br.com.hfn.investbe.model.Role;
import lombok.Getter;

@Getter
public enum RoleEnum {

	COMMOM(1,"COMMON"),
	ADM(2,"ADM");
	
	private Integer key;
	private String name;
	private Role model;
	
	private RoleEnum(Integer key, String name) {
		this.key = key;
		this.name = name;
		this.model = new Role(key, name, null);
	}
	
	public String getName() {
		return this.name.replace("ROLE_", "");
	}
	
	public static Role getRoleByName(String roleName) {
		for (RoleEnum item : RoleEnum.values()) {
			if(item.getName().equalsIgnoreCase(roleName)) {
				return item.getModel();
			}
		}
		return null;
	}
}
