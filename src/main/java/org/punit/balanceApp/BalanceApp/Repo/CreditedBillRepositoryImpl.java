package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.springframework.stereotype.Repository;
@Repository
public class CreditedBillRepositoryImpl {
	
	@PersistenceContext
	EntityManager entityManager;


	public List<CreditedBillTO> getBillsByCustId(int custId) {
		List<CreditedBillTO> postDTOs = entityManager.createQuery(
				"Select new CreditedBillTO(cBillId, custId, custFName, custLName, creditAmount, creditDate) from CreditedBillTO where custId="
						+ custId)
				.getResultList();

		return postDTOs;
	}

}
