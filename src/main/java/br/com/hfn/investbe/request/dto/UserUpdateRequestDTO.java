package br.com.hfn.investbe.request.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.hfn.investbe.response.dto.RoleResponseDTO;
import lombok.Data;

@Data
public class UserUpdateRequestDTO {
	
	private Long id;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=100, message="O tamanho do nome deve ser entre 5 e 80 caracteres")
	private String name;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="E-mail inválido")
	@Length(min=10, max=150, message="O tamanho do e-mail deve ser entre 10 e 150 caracteres")
	private String email;
	private Integer statusCode;
	private String statusName;
	private List<RoleResponseDTO> roles;
}
