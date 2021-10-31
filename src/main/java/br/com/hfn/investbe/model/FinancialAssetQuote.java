package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset quote entity - Maps access to financial asset quote data
 * @author hefreita
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAssetQuote implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FinancialAssetQuotePK id = new FinancialAssetQuotePK();
	
	private Double openPrice;
	private Double maxPrice;
	private Double MinPrice;
	private Double price;
	private Long volume;
	
}
