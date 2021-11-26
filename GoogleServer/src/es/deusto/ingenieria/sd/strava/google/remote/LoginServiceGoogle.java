package es.deusto.ingenieria.sd.strava.google.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class LoginServiceGoogle extends UnicastRemoteObject implements ILoginGoogle {
	private static final long serialVersionUID = 1L;

//	protected static final String URL = "https://free.currconv.com/api/v7/convert?q=USD_EUR,GBP_EUR&compact=ultra&apiKey=d4f1b436d25d00b16f3f";
//	public static float USD_RATE = 0.85f;
//	public static float GBP_RATE = 1.17f;
	
	public HashMap<String, String> usuarios= new HashMap<>();
	
	
	
	//Attribute for the Singleton pattern
	public static LoginServiceGoogle instance;
			
	private LoginServiceGoogle() throws RemoteException {
		super();
		usuarios.put("Roberto", "rober");
		usuarios.put("suhar","txabar");
		usuarios.put("yanis", "pizarro");
		usuarios.put("jokin", "egia");
	}
	
	public static LoginServiceGoogle getInstance() {
		if (instance == null) {
			try {
				instance = new LoginServiceGoogle();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

//	private static final void getConversionRates() {
//		System.out.println(" - Getting exchange rates from 'free.currconv.com'....");
//		
//		try {			
//			HttpURLConnection con = (HttpURLConnection) (new URL(URL).openConnection());			
//			con.setRequestProperty("User-Agent", "Mozilla/5.0");
//			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			
//			con.disconnect();
//
//			inputLine = response.toString();
//			USD_RATE = Float.parseFloat(inputLine.substring(inputLine.indexOf(":")+1, inputLine.indexOf(",")));
//			GBP_RATE = Float.parseFloat(inputLine.substring(inputLine.lastIndexOf(":")+1, inputLine.indexOf("}")));
//		} catch(Exception ex) {
//			System.out.println("  # Error getting conversion rates(): " + ex.getMessage());
//		}
//		
//		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
//		
//		
//		System.out.println(" - Exchange rates obtained (" + dateFormatter.format(Calendar.getInstance().getTime()) + ")!!");
//		System.out.println("\t- EURO to USD rate: " + USD_RATE);
//		System.out.println("\t- EURO to GBP rate: " + GBP_RATE);
//	}
//	
//	public float getUSDRate() throws RemoteException {
//		getConversionRates();
//		return USD_RATE;
//	}
//
//	public float getGBPRate() throws RemoteException {
//		getConversionRates();
//		return GBP_RATE;
//	}

	@Override
	public boolean iniciarSesion(String email, String contrasenya) throws RemoteException {
		// TODO Auto-generated method stub
		if (usuarios.containsKey(email)&&usuarios.get(email).equals(contrasenya)) {
			return true;
		}
	return false;
	}
	
	
}