package co.alphavantage;

import co.alphavantage.request.Function;
import co.alphavantage.request.Symbol;
import co.alphavantage.response.quote.BatchStockQuotesResponse;

public class BatchStockQuotes {

	private final ApiConnector apiConnector;

	/**
	 * Constructs a Batch Stock Quotes api endpoint with the help of an
	 * {@link ApiConnector}
	 *
	 * @param apiConnector the connection to the api
	 */
	public BatchStockQuotes(ApiConnector apiConnector) {
		this.apiConnector = apiConnector;
	}

	/**
	 * This API returns stock quotes updated realtime.
	 *
	 * @param symbols the stock symbols to lookup
	 * @return {@link BatchStockQuotesResponse} stock quote data
	 */
	public BatchStockQuotesResponse quote(String symbol) {
		/*if (symbols.length > 100) {
			throw new AlphaVantageException("Tried to get stock quotes for " + symbols.length
					+ " stocks. The Batch Stock" + " Quotes API will only return quotes for the first 100 symbols.");
		}*/
		String json = apiConnector.getRequest(new Symbol(symbol), Function.GLOBAL_QUOTES);
		System.out.println(json);
		return BatchStockQuotesResponse.from(json);
	}

}
