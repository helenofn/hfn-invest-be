package br.com.hfn.investbe.commom.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset entity - Maps access to financial asset data - may be a stock, ação, fii, etc.. - assets traded on the stock exchange
 * @author hefreita
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAsset implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private FinancialAssetPK id = new FinancialAssetPK();
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "financial_asset_category_id")
	private FinancialAssetCategory financialAssetCategory;
	
	private Date lastUpadate;
}
