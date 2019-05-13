package org.punit.balanceApp.BalanceApp.Repo;

import org.punit.balanceApp.BalanceApp.Data.CREDITDETAIL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditedBillReposatory extends CrudRepository<CREDITDETAIL, Integer> {


}
