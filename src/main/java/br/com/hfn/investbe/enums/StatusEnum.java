package br.com.hfn.investbe.enums;

import br.com.hfn.investbe.response.dto.StatusResponseDTO;
import lombok.Getter;

@Getter
public enum StatusEnum {

	ATIVO(1,"Ativo"),
	INATIVO(2,"Inativo");
	
	private Integer code;
	private String name;
	private StatusResponseDTO dto;
	
	private StatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
		this.dto = new StatusResponseDTO(code, name);
	}
}
