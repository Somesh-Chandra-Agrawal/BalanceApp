package org.punit.balanceApp.BalanceApp.Services;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.punit.balanceApp.BalanceApp.Repo.CustomerReposatory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServices {
	
	@Autowired
	CustomerReposatory customerReposatory;
	
	public void addCustomer(CustomerTO customerTO) {
		customerReposatory.save(customerTO);
	}

}
