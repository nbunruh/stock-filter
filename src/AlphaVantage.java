import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AlphaVantage {
	
	private static final String API_KEY = "MCS0WVNQWHC3SE5K";
	private static String time;

	private static double exchangeRate(String fromCurrency, String toCurrency) throws IOException {
		String url = "https://www.alphavantage.co/query?";
		url += "function=CURRENCY_EXCHANGE_RATE";
		url += "&from_currency=" + URLEncoder.encode(fromCurrency, "UTF-8");
		url += "&to_currency=" + URLEncoder.encode(toCurrency, "UTF-8");
		url += "&apikey=" + API_KEY;
		URL request = new URL(url);
		InputStream openStream = request.openStream();
		String response = IOUtils.toString(openStream, "UTF-8");
		JSONObject meta = new JSONObject(response);
		JSONObject rate;
		try {
			rate = meta.getJSONObject("Realtime Currency Exchange Rate");
			time = rate.getString("6. Last Updated");
			return rate.getDouble("5. Exchange Rate");
		} catch (JSONException e) {
			System.out.println("Invalid currency code.");
			return 0;
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Exchange rate of Japanese Yen to USD: " + exchangeRate("JPY", "USD") + " at " + time);

	}

}

// Copyright Nolan Unruh, 2020