package fc.Application.MVC.ViewModels;

import java.math.BigDecimal;

import northwind.OrderDetails;

public class DetailsViewModel {
	private String produit;
	private BigDecimal quantite;
	private BigDecimal prixU;
	private double discount;
	
	public DetailsViewModel() {
		
	}
	public DetailsViewModel(OrderDetails o) {
		this.produit = o.getProducts().getProductName();
		this.quantite = o.getQuantity();
		this.prixU = o.getUnitPrice();
		this.discount = o.getDiscount();
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixU() {
		return prixU;
	}

	public void setPrixU(BigDecimal prixU) {
		this.prixU = prixU;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
