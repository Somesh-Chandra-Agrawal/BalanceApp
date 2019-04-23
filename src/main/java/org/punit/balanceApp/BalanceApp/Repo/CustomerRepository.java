package org.punit.balanceApp.BalanceApp.Repo;

import javax.transaction.Transactional;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerTO, Integer> {
	
	@Transactional
	@Modifying
	@Query("Update Customer set totalDue = totalDue +:billAmount where custId =:custId")
	void updateTotalDue(@Param("billAmount") Long billAmount, @Param("custId") Integer custId);

	@Transactional
	@Modifying
	@Query("Update Customer set totalDue = totalDue -:creditAmount where custId =:custId")
	void updateTotalBillByCustId(@Param("creditAmount") Long creditAmount,@Param("custId") Integer custId);

}
