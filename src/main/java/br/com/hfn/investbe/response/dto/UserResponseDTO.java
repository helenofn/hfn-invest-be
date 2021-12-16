package br.com.hfn.investbe.response.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserResponseDTO extends ResponseDTO implements Serializable{
	private static final long serialVersionUID = -1981657228272235064L;
	
	private String name;
	private Long id;
	private String email;
	private Integer statusCode;
	private String statusName;
	private List<RoleResponseDTO> roles;
}
