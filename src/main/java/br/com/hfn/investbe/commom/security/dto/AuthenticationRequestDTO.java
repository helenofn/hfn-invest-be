package br.com.hfn.investbe.commom.security.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Email
	@Size(min=3, max=150)
	private String username;
	
	@Size(min=3, max=60)
	private String password;
}
