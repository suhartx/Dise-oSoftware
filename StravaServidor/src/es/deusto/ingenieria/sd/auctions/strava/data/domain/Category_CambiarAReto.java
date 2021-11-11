package es.deusto.ingenieria.sd.auctions.strava.data.domain;

import java.util.ArrayList;
import java.util.List;

public class Category_CambiarAReto {	
	private String name;	
	private List<Article_CambiarAentrenamiento> articles = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		
		result.append(this.name);
		result.append(" (");
		result.append(this.articles.size());
		result.append(" articles)");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.name.equals(((Category_CambiarAReto)obj).name);
		}
		
		return false;
	}
}