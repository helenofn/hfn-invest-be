package br.com.hfn.investbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="FINANCIAL_ASSET_EVENT_DIVIDEND")
public class FinancialAssetEventDividend extends FinancialAssetEvent {
	
	@Column(name = "teste", length = 18)
	private String teste;

}
