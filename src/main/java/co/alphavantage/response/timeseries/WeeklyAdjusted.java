package co.alphavantage.response.timeseries;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonParser;

import co.alphavantage.exception.AlphaVantageException;

public class WeeklyAdjusted extends TimeSeriesResponse {

	private WeeklyAdjusted(final Map<String, String> metaData, final List<StockData> stocks) {
		super(metaData, stocks);
	}

	/**
	 * Creates {@code WeeklyAdjusted} instance from json.
	 *
	 * @param json string to parse
	 * @return WeeklyAdjusted instance
	 */
	public static WeeklyAdjusted from(String json) {
		Parser parser = new Parser();
		return parser.parseJson(json);
	}

	/**
	 * Helper class for parsing json to {@code WeeklyAdjusted}.
	 *
	 * @see TimeSeriesParser
	 * @see JsonParser
	 */
	private static class Parser extends TimeSeriesParser<WeeklyAdjusted> {

		@Override
		String getStockDataKey() {
			return "Weekly Adjusted Time Series";
		}

		@Override
		WeeklyAdjusted resolve(Map<String, String> metaData, Map<String, Map<String, String>> stockData) {
			List<StockData> stocks = new ArrayList<>();
			try {
				stockData.forEach((key,
						values) -> stocks.add(new StockData(LocalDate.parse(key, SIMPLE_DATE_FORMAT).atStartOfDay(),
								Double.parseDouble(values.get("1. open")), Double.parseDouble(values.get("2. high")),
								Double.parseDouble(values.get("3. low")), Double.parseDouble(values.get("4. close")),
								Double.parseDouble(values.get("5. adjusted close")),
								Long.parseLong(values.get("6. volume")),
								Double.parseDouble(values.get("7. dividend amount"))

				)));
			} catch (Exception e) {
				throw new AlphaVantageException("Weekly adjusted api change", e);
			}
			return new WeeklyAdjusted(metaData, stocks);
		}

	}

}
