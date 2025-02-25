package fc.Application.MVC.Controllers;

import java.util.List;

import northwind.Customers;
import northwind.Orders;
import fc.Application.MVC.ViewModels.*;

public class ListClientsController extends Controller{
	@Override
	public ActionResult run(Object ...args) {
		Integer clientId = (Integer)args[0];
		
		DataContainer dc = new DataContainer();
		
		List<Customers> customers = m_Model.getCustomers();
		ClientViewModel[] clients = new ClientViewModel[customers.size()];
		
		List<Orders> orders = m_Model.getCommandes(clientId);
		CommandeViewModel[] commandes = new CommandeViewModel[orders.size()];
		
		for(int i=0;i < customers.size();i++) {
			clients[i] = new ClientViewModel(customers.get(i));
		}
		
		for(int i=0;i < orders.size();i++) {
			commandes[i] = new CommandeViewModel(orders.get(i));
		}
		
		dc.clientSelectionne = clients[clientId];
		dc.customers = clients;
		dc.commandes = commandes;
		
		return View(dc);
	}
}
