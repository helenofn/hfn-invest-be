package br.com.hfn.investbe.response.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
	
	private Long id;
	private String email;
	private String name;
	private Integer statusCode;
	private String statusName;
	private List<RoleResponseDTO> roles;
}
