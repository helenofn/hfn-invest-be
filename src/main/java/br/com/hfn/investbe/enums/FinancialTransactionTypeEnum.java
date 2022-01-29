package br.com.hfn.investbe.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.hfn.investbe.model.FinancialTransactionType;
import lombok.Getter;

@Getter
public enum FinancialTransactionTypeEnum {

	@JsonProperty("BUY")
	BUY(1,"Buy"),
	@JsonProperty("SELL")
	SELL(2,"Sell");
	
	private Integer code;
	private String name;
	private FinancialTransactionType model;
	
	private FinancialTransactionTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
		this.model = new FinancialTransactionType(code, name);
	}
}
