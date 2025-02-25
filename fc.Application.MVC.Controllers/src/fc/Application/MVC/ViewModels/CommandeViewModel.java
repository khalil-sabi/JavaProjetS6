package fc.Application.MVC.ViewModels;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import northwind.*;

public class CommandeViewModel {
	private Integer Id;
	private Date orderDate;
	private Set<DetailsViewModel> details = new HashSet<DetailsViewModel>(0);
	
	public CommandeViewModel() {
		
	}
	public CommandeViewModel(Orders o) {
		this.Id = o.getId();
		this.orderDate = o.getOrderDate();
		for(OrderDetails d : o.getOrderDetailses()) {
			details.add(new DetailsViewModel(d));
		}
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Set<DetailsViewModel> getDetails() {
		return details;
	}

	public void setDetails(Set<DetailsViewModel> details) {
		this.details = details;
	}
	
}
