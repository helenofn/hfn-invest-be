package co.alphavantage.response.quote;

import java.time.LocalDate;

public class StockQuote {
	private final String symbol;
	private final double open;
	private final double high;
	private final double low;
	private final double price;
	private final long volume;
	private final LocalDate timestamp;

	

	/**
	 * @param symbol
	 * @param open
	 * @param high
	 * @param low
	 * @param price
	 * @param volume
	 * @param timestamp
	 */
	public StockQuote(String symbol, double open, double high, double low, double price, long volume,
			LocalDate timestamp) {
		super();
		this.symbol = symbol;
		this.open = open;
		this.high = high;
		this.low = low;
		this.price = price;
		this.volume = volume;
		this.timestamp = timestamp;
	}



	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}



	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
	}



	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}



	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}



	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}



	/**
	 * @return the volume
	 */
	public long getVolume() {
		return volume;
	}



	/**
	 * @return the timestamp
	 */
	public LocalDate getTimestamp() {
		return timestamp;
	}

	

}
