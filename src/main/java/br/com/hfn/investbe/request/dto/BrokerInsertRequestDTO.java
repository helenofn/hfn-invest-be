package br.com.hfn.investbe.request.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrokerInsertRequestDTO implements Serializable{

	private static final long serialVersionUID = 212948023244966420L;
	
	@NotEmpty(message="O campo nome tem preenchimento Obrigatório")
	@Length(min=5, max=150, message="O tamanho do nome deve ser entre 5 e 150 caracteres")
	private String name;
	@NotNull(message="O campo id interno tem preenchimento Obrigatório")
	private Integer internalId;
	@NotEmpty(message="O campo cnpj tem preenchimento obrigatório")
	@Length(min=5, max=20, message="O tamanho código da pessoa jurídica dever entre 5 e 20 caracteres")
	private String ein;
		
}
