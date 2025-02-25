package fc.Application.MVC.Controllers;

import java.util.List;

import fc.Application.MVC.Model.Commande;
import fc.Application.MVC.ViewModels.CommandeViewModel;
import fc.Application.MVC.ViewModels.DataContainer;
import northwind.Orders;

public class ListCommandesController extends Controller{
	@Override
	public ActionResult run(Object ...args) {
		Integer orderId = (Integer)args[0];
		Orders order = m_Model.getUneCommande(orderId);
		DataContainer dc = new DataContainer();
		dc.commandeSelectionne = new CommandeViewModel(order);
		return View(dc);
	}
}
