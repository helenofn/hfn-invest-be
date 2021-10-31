package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Primary Key of the financial asset entity
 * @author hefreita
 *
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAssetPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "ticker_symbol_id")
	private TickerSymbol symbol;
	
}
