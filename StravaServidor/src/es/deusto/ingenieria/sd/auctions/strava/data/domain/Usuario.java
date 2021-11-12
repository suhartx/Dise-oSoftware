package es.deusto.ingenieria.sd.auctions.strava.data.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Usuario {	
	private int idUsuario;
	private String nombre;
	private String email;
	private Date fechaNacimiento;
	private String contrasenya;
	/*
	 * faltan las clases relacionadas
	 * 	private List<Bid> bids = new ArrayList<>();
	private List<Article> articles = new ArrayList<>();

	 */
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean checkContrasenya(String contrasenya) {
		return this.contrasenya.equals(contrasenya);
	}
	
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public List<Bid_CambiarAEstado> getBids() {
//		return bids;
//	}
//	
//	public void setBids(List<Bid_CambiarAEstado> bids) {
//		this.bids = bids;
//	}
	
//	public void addBid(Bid_CambiarAEstado bid) {
//		if (bid != null && !this.bids.contains(bid)) {
//			this.bids.add(bid);
//		}
//	}
//	
//	public List<Article_CambiarAentrenamiento> getArticles() {
//		return articles;
//	}
//	
//	public void setArticles(List<Article_CambiarAentrenamiento> articles) {
//		this.articles = articles;
//	}
//	
//	public void addArticle(Article_CambiarAentrenamiento article) {
//		if (article != null && !this.articles.contains(article)) {
//			this.articles.add(article);
//		}
//	}
		
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append(this.nombre);
		result.append(" - ");
		result.append(this.email);
		result.append(" - (");
//		result.append(this.articles.size());
//		result.append(" articles) - (");
//		result.append(this.bids.size());
//		result.append(" bids)");
		
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