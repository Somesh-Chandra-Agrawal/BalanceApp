package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.DebitedBillTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface DebitedBillReposatory extends CrudRepository<DebitedBillTO, Integer> {

	/*@Query("SELECT billId, custId, custFName, custLName, billAmount, billdate, due, clearFlag, clearDate, dateCount FROM DebitedBillTO where  custId = :custId")
	List<DebitedBillTO> findAllByCustId(@PathVariable("custId") int custId);*/

}
