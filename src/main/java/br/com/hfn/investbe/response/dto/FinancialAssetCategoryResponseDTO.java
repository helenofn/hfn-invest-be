package br.com.hfn.investbe.response.dto;

import java.io.Serializable;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialAssetCategoryResponseDTO implements Serializable{
	
	private static final long serialVersionUID = 5682656261061078667L;

	private Integer id;
	private String name;
	private String description;
	
	public FinancialAssetCategoryResponseDTO(FinancialAssetCategory model) {
		if(null!=model) {
			this.id = model.getId();
			this.name = model.getName();
			this.description = model.getDescription();
		}
	}
}
