package org.punit.balanceApp.BalanceApp.Repo;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditedBillReposatory extends CrudRepository<CreditedBillTO, Integer> {


}
