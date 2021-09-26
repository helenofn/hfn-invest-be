package co.alphavantage.request;

public class Symbols implements ApiParameter {
	private String[] symbols;

	public Symbols(String... symbols) {
		this.symbols = symbols;
	}

	@Override
	public String getKey() {
		return "symbols";
	}

	@Override
	public String getValue() {
		return String.join(",", symbols);
	}

}
