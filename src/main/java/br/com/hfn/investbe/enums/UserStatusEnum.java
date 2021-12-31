package br.com.hfn.investbe.enums;

import br.com.hfn.investbe.model.user.UserStatus;
import br.com.hfn.investbe.response.dto.UserStatusResponseDTO;
import lombok.Getter;

@Getter
public enum UserStatusEnum {

	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo");
	
	private Integer code;
	private String name;
	private UserStatusResponseDTO dto;
	private UserStatus model;
	
	private UserStatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
		this.dto = new UserStatusResponseDTO(code, name);
		this.model = new UserStatus(code, name);
	}
}
