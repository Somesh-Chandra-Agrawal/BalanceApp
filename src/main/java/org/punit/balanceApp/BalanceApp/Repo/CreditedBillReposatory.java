package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface CreditedBillReposatory extends CrudRepository<CreditedBillTO, Integer> {

	/*@Query("SELECT cBillId, custId, custFName, custLName, creditAmount, creditedDate from CreditedBillTO where  custId = :custId")
	List<CreditedBillTO> findAllByCustId(@PathVariable("custId") int custId);
*/
}
