package br.com.hfn.investbe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET_EVENT_BONUS_SHARE")
public class FinancialAssetEventBonusShare extends FinancialAssetEvent {
	
	@Column(name = "VL_UNIT_COST", length = 20, precision = 2)
	private Double vlUnitCost;
	
	@Column(name = "QTD_ASSET_BONUS", length = 4)
	private Integer qtdStockBonus;
	
	@Column(name = "QTD_ASSET_EACH", length = 4)
	private Integer qtdStockEach;
}
