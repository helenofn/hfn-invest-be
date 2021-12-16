package br.com.hfn.investbe.enums;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import br.com.hfn.investbe.response.dto.FinancialAssetCategoryResponseDTO;
import lombok.Getter;

@Getter
public enum FinancialAssetCategoryEnum {

	ACOES(1,"Ações", ""),
	FIIS(2, "FIIs", ""),
	TESOURO_DIRETO(3, "Tesouro Direto", ""),
	STOCKS(4, "Stocks", ""),
	REITS(5, "REITs", "");
	
	private Integer code;
	private String name;
	private String description;
	private FinancialAssetCategory model;
	private FinancialAssetCategoryResponseDTO dto;
	
	private FinancialAssetCategoryEnum(Integer code, String name, String description) {
		this.code = code;
		this.description = description;
		this.model = new FinancialAssetCategory(code, name, description);
		this.dto = new FinancialAssetCategoryResponseDTO(code, name, description);
	}
	
}
