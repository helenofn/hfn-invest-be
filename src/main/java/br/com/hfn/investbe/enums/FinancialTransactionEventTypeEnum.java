package br.com.hfn.investbe.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.hfn.investbe.model.FinancialTransactionEventType;
import lombok.Getter;

@Getter
public enum FinancialTransactionEventTypeEnum {

	@JsonProperty("BUY")
	BUY(1,"Buy"),
	@JsonProperty("SELL")
	SELL(2,"Sell"),
	@JsonProperty("SPLIT")
	SPLIT(3,"Split"),
	@JsonProperty("INPLIT")
	INPLIT(4,"Inplit"),
	@JsonProperty("BONUS SHARE")
	BONUS_SHARE(5,"Bonus Share");
	
	private Integer code;
	private String name;
	private FinancialTransactionEventType model;
	
	private FinancialTransactionEventTypeEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
		this.model = new FinancialTransactionEventType(code, name);
	}
}
