package fc.Application.MVC.Controllers;

import fc.Application.MVC.Model.Client;
import fc.Application.MVC.ViewModels.ClientViewModel;
import northwind.Customers;

public class EditClientController extends Controller {
	@Override
	public ActionResult run(Object ...args) {
		if(args.length > 1) {
			m_Model.updateCustomer((Integer)args[0], (String)args[1], (String)args[2], (String)args[3]);
		}
		Integer clientId  = (Integer)args[0];
		Customers customers = m_Model.getUnCustomers(clientId);
		ClientViewModel CustomersViewModel = new ClientViewModel(customers);
		return View(CustomersViewModel);
	}
}
