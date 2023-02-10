package br.com.hfn.investbe.request.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialAssetCategoryInsertRequestDTO {

	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=4, max=100, message="O tamanho do nome deve ser entre 4 e 100 caracteres")
	private String name;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=4, max=500, message="O tamanho da descrição deve ser entre 4 e 500 caracteres")
	private String description;
}
