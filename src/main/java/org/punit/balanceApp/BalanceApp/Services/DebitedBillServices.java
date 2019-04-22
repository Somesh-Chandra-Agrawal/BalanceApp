package org.punit.balanceApp.BalanceApp.Services;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.DebitedBillTO;
import org.punit.balanceApp.BalanceApp.Repo.DebitedBillReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitedBillServices {
	
	@Autowired
	DebitedBillReposatory debitedBillReposatory;
	
	public void addDebitedBill(DebitedBillTO debitedBillTO) {
		debitedBillReposatory.save(debitedBillTO);
	}
	
	public List<DebitedBillTO> getAllBillByCustId(int custId) {
		return debitedBillReposatory.findAllByCustId(custId);
	}
	
	public List<DebitedBillTO> getAllBill(DebitedBillTO debitedBillTO) {
		return (List<DebitedBillTO>) debitedBillReposatory.findAll();
	}
}
