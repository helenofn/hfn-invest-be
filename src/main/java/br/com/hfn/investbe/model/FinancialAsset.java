package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "cseq_financial_asset", length = 22)
	private Long id;
	
	@Column(name = "ds_ticker", length = 50)
	private String ticker;
	
	@ManyToOne
	@JoinColumn(name = "cseq_company")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "cseq_company_broke")
	private Company broke;
	
	@ManyToOne
	@JoinColumn(name = "cseq_financial_asset_category")
	private FinancialAssetCategory financialAssetCategory;
	
	@Column(name = "dh_last_update")
	private LocalDate lastUpadate;
}
