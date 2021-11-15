package br.com.hfn.investbe.dto;

import java.io.Serializable;

import br.com.hfn.investbe.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDTO implements Serializable{

	private static final long serialVersionUID = -881286942556371406L;
	
	private Integer code;
	private String name;
	
	public RoleDTO(Role model) {
		this.code = model.getCode();
		this.name = model.getName();
	}

}
