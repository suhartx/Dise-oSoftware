package es.deusto.ingenieria.sd.auctions.facebook.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrencyExchangeService extends UnicastRemoteObject implements ICurrencyExchange {
	private static final long serialVersionUID = 1L;

	protected static final String URL = "https://free.currconv.com/api/v7/convert?q=USD_EUR,GBP_EUR&compact=ultra&apiKey=d4f1b436d25d00b16f3f";
	public static float USD_RATE = 0.85f;
	public static float GBP_RATE = 1.17f;
	
	//Attribute for the Singleton pattern
	public static CurrencyExchangeService instance;
			
	private CurrencyExchangeService() throws RemoteException {
		super();
		getConversionRates();
	}
	
	public static CurrencyExchangeService getInstance() {
		if (instance == null) {
			try {
				instance = new CurrencyExchangeService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	private static final void getConversionRates() {
		System.out.println(" - Getting exchange rates from 'free.currconv.com'....");
		
		try {			
			HttpURLConnection con = (HttpURLConnection) (new URL(URL).openConnection());			
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			con.disconnect();

			inputLine = response.toString();
			USD_RATE = Float.parseFloat(inputLine.substring(inputLine.indexOf(":")+1, inputLine.indexOf(",")));
			GBP_RATE = Float.parseFloat(inputLine.substring(inputLine.lastIndexOf(":")+1, inputLine.indexOf("}")));
		} catch(Exception ex) {
			System.out.println("  # Error getting conversion rates(): " + ex.getMessage());
		}
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
		
		
		System.out.println(" - Exchange rates obtained (" + dateFormatter.format(Calendar.getInstance().getTime()) + ")!!");
		System.out.println("\t- EURO to USD rate: " + USD_RATE);
		System.out.println("\t- EURO to GBP rate: " + GBP_RATE);
	}
	
	public float getUSDRate() throws RemoteException {
		getConversionRates();
		return USD_RATE;
	}

	public float getGBPRate() throws RemoteException {
		getConversionRates();
		return GBP_RATE;
	}
}