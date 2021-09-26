package co.alphavantage.response.quote;

import java.time.LocalDate;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import co.alphavantage.AlphaVantageParse;
import co.alphavantage.exception.AlphaVantageException;

public class BatchStockQuotesResponse {
	//private final Map<String, String> metaData;
	//private final List<StockQuote> stockQuotes;
	
	private final StockQuote stockQuote;

	/*private BatchStockQuotesResponse(final Map<String, String> metaData, final List<StockQuote> stockQuotes) {
		this.stockQuotes = stockQuotes;
		this.metaData = metaData;
	}*/
	
	private BatchStockQuotesResponse(final StockQuote stockQuote) {
		this.stockQuote = stockQuote;
	}

	

	/**
	 * @return the stockQuote
	 */
	public StockQuote getStockQuote() {
		return stockQuote;
	}



	/**
	 * Creates {@code BatchStockQuotesResponse} instance from json.
	 *
	 * @param json string to parse
	 * @return BatchStockQuotesResponse instance
	 */
	public static BatchStockQuotesResponse from(String json) {
		Parser parser = new Parser();
		return parser.parseJson(json);
	}

	/**
	 * Helper class for parsing json to {@code BatchStockQuotesResponse}.
	 *
	 * @see JsonParser
	 */
	private static class Parser extends AlphaVantageParse<BatchStockQuotesResponse> {

		@Override
		protected BatchStockQuotesResponse resolve(final JsonObject rootObject) {
			/*Type metaDataType = new TypeToken<Map<String, String>>() {
			}.getType();
			Type dataType = new TypeToken<List<Map<String, String>>>() {
			}.getType();*/
			try {
				/*Map<String, String> metaData = GSON.fromJson(rootObject.get("Meta Data"), metaDataType);
				List<Map<String, String>> stockQuotes = GSON.fromJson(rootObject.get("Global Quote"), dataType);

				List<StockQuote> stocks = new ArrayList<>();
				stockQuotes.forEach((stockData) -> stocks.add(new StockQuote(stockData.get("1. symbol"),
						Double.parseDouble(stockData.get("2. price")), getVolume(stockData),
						LocalDateTime.parse(stockData.get("4. timestamp"), DATE_WITH_TIME_FORMAT))));*/
				
				Map<String, String> stockQuote = GSON.fromJson(rootObject.get("Global Quote"), new TypeToken<Map<String, String>>(){}.getType());
				StockQuote stock = new StockQuote(	
						stockQuote.get("01. symbol"),
						Double.parseDouble(stockQuote.get("02. open")),
						Double.parseDouble(stockQuote.get("03. high")),
						Double.parseDouble(stockQuote.get("04. low")),
						Double.parseDouble(stockQuote.get("05. price")),
						getVolume(stockQuote),
						LocalDate.parse(stockQuote.get("07. latest trading day"), SIMPLE_DATE_FORMAT));
				
				return new BatchStockQuotesResponse(stock);
			} catch (JsonSyntaxException e) {
				throw new AlphaVantageException("BatchStockQuotes api change", e);
			}
		}

		private long getVolume(final Map<String, String> values) {
			try {
				return Long.parseLong(values.get("06. volume"));
			} catch (NumberFormatException e) {
				return 0L;
			}
		}
	}

}
