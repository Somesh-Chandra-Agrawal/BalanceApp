package org.punit.balanceApp.BalanceApp.Services;

import java.util.List;
import java.util.Optional;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.punit.balanceApp.BalanceApp.Repo.CustomerReposatory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServices {
	
	@Autowired
	CustomerReposatory customerReposatory;
	
	public CustomerTO addCustomer(CustomerTO customerTO) {
		CustomerTO addedCustomer = customerReposatory.save(customerTO);
		return addedCustomer;
	}

	public List<CustomerTO> getAllCustomer() {
		return (List<CustomerTO>) customerReposatory.findAll();
	}
	
	public CustomerTO getCustomerById(int custId){
		return customerReposatory.findById(custId);
	}
}
