package fc.Application.MVC.Model;

public class Commande {
	private int id;
	private String produit;
	private int quantite;
	private Double prixU;
	private Double discount;
	public Commande(int id, String produit,int quantite,Double prixU,Double discount) {
		this.id = id;
		this.produit = produit;
		this.quantite = quantite;
		this.prixU = prixU;
		this.discount = discount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getProduit() {
		return produit;
	}
	public void setProduit(String produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Double getPrixU() {
		return prixU;
	}
	public void setPrixU(Double prixU) {
		this.prixU = prixU;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
