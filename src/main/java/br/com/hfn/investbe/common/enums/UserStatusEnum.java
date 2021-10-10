package br.com.hfn.investbe.common.enums;

import br.com.hfn.investbe.commom.model.UserStatus;
import br.com.hfn.investbe.common.dto.UserStatusDTO;
import lombok.Getter;

@Getter
public enum UserStatusEnum {

	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo");
	
	private Integer code;
	private String name;
	private UserStatusDTO dto;
	private UserStatus model;
	
	private UserStatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
		this.dto = new UserStatusDTO(code, name);
		this.model = new UserStatus(code, name);
	}
}
