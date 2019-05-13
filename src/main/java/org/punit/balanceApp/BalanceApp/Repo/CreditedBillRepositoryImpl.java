package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.punit.balanceApp.BalanceApp.Data.CREDITDETAIL;
import org.springframework.stereotype.Repository;
@Repository
public class CreditedBillRepositoryImpl {
	
	@PersistenceContext
	EntityManager entityManager;


	public List<CREDITDETAIL> getBillsByCustId(int custId) {
		List<CREDITDETAIL> postDTOs = entityManager.createQuery(
				"Select new CREDITDETAIL(cBillId, custId, custFName, custLName, creditAmount, creditDate) from CREDITDETAIL where custId="
						+ custId)
				.getResultList();

		return postDTOs;
	}

}
