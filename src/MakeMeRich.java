
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ",
			"IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN", "CRAY", "CSCO",
			"SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN",
			"YHOO");

	public static void main(String[] args) {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		symbols.stream().forEach((s) -> System.out.print(s + " "));
		
		// 2. Use the StockUtil class to print the price of Bitcoin
		System.out.println("\nPrice of BTC: " + StockUtil.prices.get("BTC-USD"));
		
		// 3. Create a new List of StockInfo that includes the stock price
		List<Double> stockInfo = StockUtil.prices.values().stream().collect(Collectors.toList());
		System.out.println(stockInfo);
	
		// 4. Find the highest-priced stock under $500
		List<Double> highestPricedStock = stockInfo.stream().filter(price -> price < 500).sorted()
				.collect(Collectors.toList());
		Collections.reverse(highestPricedStock);
		System.out.println(highestPricedStock);
		System.out.println(highestPricedStock.get(0));
	
	}

}

// Copyright Nolan Unruh, 2020