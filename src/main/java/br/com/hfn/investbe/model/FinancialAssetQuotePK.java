package br.com.hfn.investbe.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Primary key of the financial asset quote entity 
 * 
 * @author hefreita
 *
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAssetQuotePK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cseq_financial_asset")
	private FinancialAsset financialAsset;
	@Column(name="dh_trade")
	private LocalDate tradedDate;
	
}
