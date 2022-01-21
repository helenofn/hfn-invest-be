package br.com.hfn.investbe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.hfn.investbe.model.pk.FinancialAssetQuotePK;
import co.alphavantage.response.timeseries.StockData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Financial asset quote entity - Maps access to financial asset quote data
 * @author hefreita
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "FINANCIAL_ASSET_QUOTE")
public class FinancialAssetQuote implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FinancialAssetQuotePK id = new FinancialAssetQuotePK();
	
	@Column(name = "VL_OPEN_PRICE", length = 20, precision = 2)
	private Double openPrice;
	@Column(name = "VL_MAX_PRICE", length = 20, precision = 2)
	private Double maxPrice;
	@Column(name = "VL_MIN_PRICE", length = 20, precision = 2)
	private Double minPrice;
	@Column(name = "VL_PRICE", length = 20, precision = 2)
	private Double price;
	@Column(name = "QT_VOLUME", length = 20)
	private Long volume;
	
	public FinancialAssetQuote(StockData stockData, FinancialAsset financialAsset) {
		this.id.setFinancialAsset(financialAsset);
		this.id.setTradedDate(stockData.getDateTime());
		this.openPrice = stockData.getOpen();
		this.maxPrice = stockData.getHigh();
		this.minPrice = stockData.getLow();
		this.price = stockData.getClose();
		this.volume = stockData.getVolume();
	}
}
