package fc.Application.MVC.ViewModels;

import northwind.Customers;

public class ClientViewModel {
	private int Id;
	private String nom;
	private String prenom;
	private String email;
	
	public ClientViewModel() {
		
	}
	public ClientViewModel(Customers c) {
		this.Id = c.getId();
		this.nom = c.getLastName();
		this.prenom = c.getFirstName();
		this.email = c.getEmailAddress();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
