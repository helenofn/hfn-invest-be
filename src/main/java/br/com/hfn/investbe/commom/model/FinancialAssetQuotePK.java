package br.com.hfn.investbe.commom.model;

import java.io.Serializable;
import java.util.Date;

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
	@JoinColumn(name = "ticker_symbol_id")
	private FinancialAsset financialAsset;
	private Date tradedDate;
	
}
