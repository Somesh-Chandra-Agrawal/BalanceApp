package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.DebitedBillTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface DebitedBillReposatory extends CrudRepository<DebitedBillTO, Integer> {

	@Query("SELECT BillId, CustId, CustFName, CustLName, BillAmount, Billdate, due, ClearFlag, ClearDate, DateCount FROM Bill where  custId = :custId")
	List<DebitedBillTO> findAllByCustId(@PathVariable("custId") int custId);

}
