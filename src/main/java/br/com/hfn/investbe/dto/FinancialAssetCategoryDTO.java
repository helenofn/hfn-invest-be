package br.com.hfn.investbe.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialAssetCategoryDTO implements Serializable{
	
	private static final long serialVersionUID = 5682656261061078667L;

	private Integer id;
	private String name;
	private String description;
}
