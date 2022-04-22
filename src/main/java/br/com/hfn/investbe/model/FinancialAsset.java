package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset entity - Maps access to financial asset data - may be a stock, ação, fii, etc.. - assets traded on the stock exchange
 * @author hefreita
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FINANCIAL_ASSET")
public class FinancialAsset implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cseq_financial_asset", length = 18)
	private Long seqId;
	
	@Column(name = "cd_internal", length = 18, unique = true)
	private Long internalId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_stock_exchange")
	private StockExchange stockExchange;
	
	@Column(name = "ds_ticker", length = 50)
	private String ticker;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_company")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cseq_financial_asset_category")
	private FinancialAssetCategory financialAssetCategory;
	
	@Column(name = "dh_last_update")
	private LocalDateTime lastUpadate;
	
	@OneToMany(mappedBy = "financialAsset")
	private List<FinancialAssetEventInplitSplit> financialAssetEventInplitSplits;
	
	@OneToMany(mappedBy = "financialAsset")
	private List<FinancialAssetEventBonusShare> financialAssetEventBonusShares;
}
