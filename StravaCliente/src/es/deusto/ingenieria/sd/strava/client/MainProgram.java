package es.deusto.ingenieria.sd.strava.client;

import java.util.List;


import es.deusto.ingenieria.sd.strava.client.controller.EntrenamientoController;
import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.RetoController;
import es.deusto.ingenieria.sd.strava.client.gui.BidWindow;
import es.deusto.ingenieria.sd.strava.client.gui.LoginDialog;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class MainProgram {

	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		
		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		LoginDialog loginDialog = new LoginDialog(loginController);		
		EntrenamientoController entrenamientoController =  new EntrenamientoController(serviceLocator);
		RetoController retoController= new RetoController(serviceLocator);
		//BidWindow bidWindow = new BidWindow(bidController);
		
		//Login
		loginDialog.login();		
		
//		List<CategoryDTO> categories = bidWindow.getCategories();
//		//Get Articles of a category (first category is selected)
//		List<ArticleDTO> articles = bidWindow.getArticles(categories.get(0).getName());
//		//Convert currency to GBP
//		bidWindow.currencyToGBP(articles);
//		//Convert currency to USD
//		bidWindow.currencyToUSD(articles);
//		//Place a bid (first article of the category is selected; the token is stored in the BidController)
//		bidWindow.makeBid(loginController.getToken(), articles.get(0));
//		//Get Articles to check if the bid has been done
//		articles = bidWindow.getArticles(categories.get(0).getName());
		//Logout
		loginDialog.logout();
	}
}