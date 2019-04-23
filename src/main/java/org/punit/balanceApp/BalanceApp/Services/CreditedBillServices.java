package org.punit.balanceApp.BalanceApp.Services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.punit.balanceApp.BalanceApp.Data.Bill;
import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.punit.balanceApp.BalanceApp.Repo.CreditedBillReposatory;
import org.punit.balanceApp.BalanceApp.Repo.CreditedBillRepositoryImpl;
import org.punit.balanceApp.BalanceApp.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditedBillServices {
	
	@Autowired
	CreditedBillReposatory creditedBillReposatory;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CreditedBillRepositoryImpl creditedBillRepositoryImpl;

	@Transactional
	public void addCreditedBill(CreditedBillTO creditedBillTO) {
		creditedBillReposatory.save(creditedBillTO);
		customerRepository.updateTotalBillByCustId(creditedBillTO.getCreditAmount(), creditedBillTO.getCustId());
		
	}

	public List<CreditedBillTO> getAllCreditedBill() {
		return (List<CreditedBillTO>) creditedBillReposatory.findAll();
	}

	public List<CreditedBillTO> getAllCreditedBillByCustId(int custId) {
		List<CreditedBillTO> bills = creditedBillRepositoryImpl.getBillsByCustId(custId);
		return bills;
	}
	
	/*public List<CreditedBillTO> getAllCreditedBillByCustId(int custId) {
		 List<CreditedBillTO> allBills = (List<CreditedBillTO>) creditedBillReposatory.findAll();
		 List<CreditedBillTO> billByCustId = new ArrayList<>();
		 allBills.forEach(bill ->{
			 if (bill.getCustId() == custId) {
				 billByCustId.add(bill);
			 }
		 });
		 return billByCustId;
	}*/
	
	
	
}
