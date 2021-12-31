package br.com.hfn.investbe.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.hfn.investbe.model.FinancialAssetCategory;
import lombok.Getter;

@Getter
public enum FinancialAssetCategoryEnum {

	@JsonProperty("AÇÔES")
	ACOES(1,"Ações", ""),
	@JsonProperty("FIIS")
	FIIS(2, "FIIs", ""),
	@JsonProperty("TESOURO DIRETO")
	TESOURO_DIRETO(3, "Tesouro Direto", ""),
	@JsonProperty("AÇÔES")
	STOCKS(4, "Stocks", ""),
	@JsonProperty("AÇÔES")
	REITS(5, "REITs", "");
	
	private Integer code;
	private String name;
	private String description;
	private FinancialAssetCategory model;
		
	private FinancialAssetCategoryEnum(Integer code, String name, String description) {
		this.code = code;
		this.description = description;
		this.model = new FinancialAssetCategory(code, name, description);
	}
	
}
