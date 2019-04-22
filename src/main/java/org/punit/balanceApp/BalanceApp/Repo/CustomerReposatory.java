package org.punit.balanceApp.BalanceApp.Repo;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.springframework.data.repository.CrudRepository;


public interface CustomerReposatory extends CrudRepository<CustomerTO, Integer> {

}
