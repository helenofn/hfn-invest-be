package br.com.hfn.investbe.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET_EVENT_BONUS_SHARE")
public class FinancialAssetEventBonusShare {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset_bonus_share", length = 18)
	private Long cseqId;
	
	@ManyToOne
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	
	@JoinColumn(name = "dh_ocurrence")
	private LocalDateTime dhOcurrence;
	
	@Column(name = "VL_UNIT_COST", length = 20, precision = 2)
	private Double vlUnitCost;
	
	@Column(name = "QTD_ASSET_BONUS", length = 4)
	private Integer qtdStockBonus;
	
	@Column(name = "QTD_ASSET_EACH", length = 4)
	private Integer qtdStockEach;
}
