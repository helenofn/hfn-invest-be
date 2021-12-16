package br.com.hfn.investbe.response.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleResponseDTO implements Serializable{

	private static final long serialVersionUID = -881286942556371406L;
	
	private Integer code;
	private String name;

}
