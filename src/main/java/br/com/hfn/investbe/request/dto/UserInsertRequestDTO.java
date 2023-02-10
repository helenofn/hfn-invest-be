package br.com.hfn.investbe.request.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInsertRequestDTO implements Serializable{

	private static final long serialVersionUID = -8739169933838699838L;

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=100, message="O tamanho do nome deve ser entre 5 e 80 caracteres")
	private String name;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="E-mail inválido")
	@Length(min=10, max=150, message="O tamanho do e-mail deve ser entre 10 e 150 caracteres")
	private String email;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=8, max=12, message="O tamanho da senha deve ser entre 8 e 12 caracteres")
	private String password;
}
