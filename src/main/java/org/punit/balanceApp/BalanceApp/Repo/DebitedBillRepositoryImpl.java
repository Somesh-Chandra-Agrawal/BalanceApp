package org.punit.balanceApp.BalanceApp.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.punit.balanceApp.BalanceApp.Data.Bill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DebitedBillRepositoryImpl {

	@PersistenceContext
	EntityManager entityManager;

	public List<Bill> getBillsByCustId(Integer custId) {

		List<Bill> postDTOs = entityManager.createQuery(
				"Select new Bill(billId, custId, custFName, custLName, billAmount, billDate, due, clearFlag, billClearDate, dateCount) from Bill where custId="
						+ custId)
				.getResultList();

		return postDTOs;
	}

	@Transactional
	@Modifying
	public boolean updateTotalBillOfCust(Integer billAmount, Integer custId) {

		Query query = entityManager.createQuery("Update Customer set totalDue =totalDue+ :billAmount where custId = :custId");
		query.setParameter("billAmount", Long.valueOf(billAmount));
		query.setParameter("custId", custId);
		int rowsUpdated = query.executeUpdate();
		return true;
	}
}
