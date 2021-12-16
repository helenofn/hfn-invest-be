package br.com.hfn.investbe.request.dto;

import java.io.Serializable;
import java.util.List;

import br.com.hfn.investbe.response.dto.RoleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO implements Serializable{

	private static final long serialVersionUID = 718446095895175493L;
	
	private String name;
	private Long id;
	private String email;
	private Integer statusCode;
	private String statusName;
	private List<RoleResponseDTO> roles;
}
