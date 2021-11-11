package es.deusto.ingenieria.sd.auctions.strava.data.domain;

import java.util.ArrayList;
import java.util.List;

public class Usuario {	
	private String nickname;
	private String password;
	private String email;
	private List<Bid_CambiarAEstado> bids = new ArrayList<>();
	private List<Article_CambiarAentrenamiento> articles = new ArrayList<>();
		
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Bid_CambiarAEstado> getBids() {
		return bids;
	}
	
	public void setBids(List<Bid_CambiarAEstado> bids) {
		this.bids = bids;
	}
	
	public void addBid(Bid_CambiarAEstado bid) {
		if (bid != null && !this.bids.contains(bid)) {
			this.bids.add(bid);
		}
	}
	
	public List<Article_CambiarAentrenamiento> getArticles() {
		return articles;
	}
	
	public void setArticles(List<Article_CambiarAentrenamiento> articles) {
		this.articles = articles;
	}
	
	public void addArticle(Article_CambiarAentrenamiento article) {
		if (article != null && !this.articles.contains(article)) {
			this.articles.add(article);
		}
	}
		
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nickname);
		result.append(" - ");
		result.append(this.email);
		result.append(" - (");
		result.append(this.articles.size());
		result.append(" articles) - (");
		result.append(this.bids.size());
		result.append(" bids)");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((Usuario)obj).email);
		}
		
		return false;
	}
}