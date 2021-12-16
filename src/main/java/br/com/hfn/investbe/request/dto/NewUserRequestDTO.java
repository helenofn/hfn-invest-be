package br.com.hfn.investbe.request.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.hfn.investbe.user.validation.UserInsert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@UserInsert
public class NewUserRequestDTO implements Serializable{

	private static final long serialVersionUID = -8739169933838699838L;

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=80, message="O tamanho do nome deve ser entre 5 e 80 caracteres")
	private String name;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Email(message="E-mail inválido")
	private String email;
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=8, max=12, message="O tamanho da senha deve ser entre 8 e 12 caracteres")
	private String password;
}
