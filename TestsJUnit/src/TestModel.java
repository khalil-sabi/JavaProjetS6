import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fc.Application.MVC.Model.Model;
import northwind.*;

class TestModel {

	/*@Test
	void test() {
		List<Orders> orders = Model.getCommandes(1);
		for(Orders o : orders) {
			for(OrderDetails od : o.getOrderDetailses()) {
				System.out.println(od.getProducts().getProductName());
			}
			
		}
	}*/
	@Test
	void test2() {
		System.out.println(Model.getUneCommande(0));
	}

}
