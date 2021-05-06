package fc.Application.MVC.Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import northwind.Customers;


public class Model {
	public Client[] clients;
	public Commande[] produits;
	
	private static Model s_model = null;
	
	public static Model getModel() {
		if(s_model == null) {
			Model m = new Model();
			m.clients = new Client[] {
					new Client(0,"khalil","sabi","khalil@live.fr"),
					new Client(1,"khalil","sabi","khalil@gmail.com")
			};
			m.produits = new Commande[] {
					new Commande(0,"A",7,50.0,0.0),
					new Commande(1,"B",7,50.0,0.0)
			};
			return m;
		}
		return s_model;
	}
	
	public static void getClients() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fc.Application.MVC.Model");
		EntityManager em = emf.createEntityManager();
		String str = "SELECT c FROM Customers c";
		TypedQuery<Customers> query = em.createQuery(str, Customers.class);
		List<Customers> customers = query.getResultList();
		for (Customers c : customers)
		{
			System.out.println("nom = "+ c.getLastName());
		} 

		
		em.close();
		emf.close();
	}
}
