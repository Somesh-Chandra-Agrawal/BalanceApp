package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitedBillRepository extends CrudRepository<Bill, Integer> {

	@Query("select custId, custFName, custLName, billAmount, due, clearFlag, dateCount from Bill  where custId=:custId")
	List<Object> getBillsByCustId(@Param("custId") Integer custId);

}
