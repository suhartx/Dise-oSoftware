package es.deusto.ingenieria.sd.strava.server.services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.deusto.ingenieria.sd.auctions.strava.data.domain.Entrenamiento;
import es.deusto.ingenieria.sd.auctions.strava.data.domain.Bid_CambiarAEstado;
import es.deusto.ingenieria.sd.auctions.strava.data.domain.Reto;
import es.deusto.ingenieria.sd.auctions.strava.data.domain.Usuario;

//TODO: Implement Singleton Pattern
public class BidAppService {
	
	//TODO: remove when DAO Pattern is implemented
	private List<Reto> categories = new ArrayList<>();
	private List<Entrenamiento> articles = new ArrayList<>();
	
	public BidAppService() {
		//TODO: remove when DAO Pattern is implemented
		this.initilizeData();
	}
	
	//TODO: remove when DAO Pattern is implemented
	private void initilizeData() {
		//Create Users
		Usuario user0 = new Usuario();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNickname("Thomas");
		user0.setPassword("$!9PhNz,");
		
		Usuario user1 = new Usuario();
		user1.setEmail("sample@gmail.com");
		user1.setNickname("buyer33");		
		user1.setPassword("hqc`}3Hb");
								
		//Create Categories
		Reto catPhone = new Reto();
		catPhone.setName("Cell Phones");		

		//Create Articles				
		Entrenamiento galaxy = new Entrenamiento();
		galaxy.setNumber(9);
		galaxy.setTitle("Samsung Galaxy S20 128GB");
		galaxy.setInitialPrice(149.99f);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 60);
		galaxy.setAuctionEnd(calendar.getTime());
		
		catPhone.addArticle(galaxy);
		galaxy.setCategory(catPhone);
		user1.addArticle(galaxy);
		galaxy.setOwner(user1);
		
		Entrenamiento iphone = new Entrenamiento();
		iphone.setNumber(10);
		iphone.setTitle("Apple iPhone 12 64GB");
		iphone.setInitialPrice(216.00f);
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		iphone.setAuctionEnd(calendar.getTime());			
		
		catPhone.addArticle(iphone);
		iphone.setCategory(catPhone);
		user1.addArticle(iphone);
		iphone.setOwner(user1);
						
		Entrenamiento xiaomi = new Entrenamiento();
		xiaomi.setNumber(11);	
		xiaomi.setTitle("Xiaomi Mi 10");
		xiaomi.setInitialPrice(99.40f);
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 11);
		xiaomi.setAuctionEnd(calendar.getTime());			
				
		catPhone.addArticle(xiaomi);		
		xiaomi.setCategory(catPhone);
		user1.addArticle(xiaomi);
		xiaomi.setOwner(user1);
		
		//Add the Category to the local cache.
		this.categories.add(catPhone);
		//Add articles to local cahce
		this.articles.add(galaxy);
		this.articles.add(iphone);
		this.articles.add(xiaomi);
	}
	
	
	public List<Reto> getCategories() {
		//TODO: Get all the categories using DAO Pattern		
		return this.categories;
	}

	public List<Entrenamiento> getArticles(String category) {
		//TODO: Get articles of a category using DAO Pattern
		for (Reto cat : this.categories) {
			if (cat.getName().equalsIgnoreCase(category)) {
				return cat.getArticles();
			}
		}
		
		return null;
	}

	public boolean makeBid(Usuario user, int number, float amount) {
		//TODO: Find the artile using DAO Pattern
		Entrenamiento article = null;
		
		for (Entrenamiento art : this.articles) {
			if (art.getNumber() == number) {
				article = art;
				break;
			}
		}

		if (article != null) {
			Bid_CambiarAEstado newBid = new Bid_CambiarAEstado();		
			newBid.setDate(Calendar.getInstance().getTime());
			newBid.setAmount(amount);
			newBid.setArticle(article);
			newBid.setUser(user);		
			article.addBid(newBid);
			user.addBid(newBid);

			//TODO: Save the new bin in the DB using DAO Pattern
			
			return true;
		} else {
			return false;
		}
	}
	
	public float getUSDRate() {
		//TODO: Get conversion rate using Service Gateway
		return 0.85f;
	}

	public float getGBPRate() throws RemoteException {
		//TODO: Get conversion rate using Service Gateway
		return 1.17f;
	}
}