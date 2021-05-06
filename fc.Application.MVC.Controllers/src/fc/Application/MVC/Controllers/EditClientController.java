package fc.Application.MVC.Controllers;

import fc.Application.MVC.Model.Client;
import fc.Application.MVC.ViewModels.ClientViewModel;

public class EditClientController extends Controller {
	@Override
	public ActionResult run(Object ...args) {
		Integer clientId  = (Integer)args[0];
		Client client = m_Model.clients[clientId];
		ClientViewModel clientViewModel = new ClientViewModel(client.getId(),client.getNom(),client.getPrenom(),client.getEmail());
		return View(clientViewModel);
	}
}
