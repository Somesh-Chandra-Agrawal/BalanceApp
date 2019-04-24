package org.punit.balanceApp.BalanceApp.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.punit.balanceApp.BalanceApp.Repo.CreditedBillReposatory;
import org.punit.balanceApp.BalanceApp.Repo.CreditedBillRepositoryImpl;
import org.punit.balanceApp.BalanceApp.Repo.CustomerRepository;
import org.punit.balanceApp.BalanceApp.Repo.DebitedBillRepositoryImpl;
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
	
	//@Autowired
	//DebitedBillRepositoryImpl debitedBillRepository;

	@Transactional
	public void addCreditedBill(CreditedBillTO creditedBillTO) {
		creditedBillReposatory.save(creditedBillTO);
		customerRepository.updateTotalBillByCustId(Long.valueOf(creditedBillTO.getCreditAmount()), creditedBillTO.getCustId());
		maintainDebitedBill(creditedBillTO);
	}

	private void maintainDebitedBill(CreditedBillTO creditedBillTO) {
		//debitedBillRepository.maintainDebitedBill(creditedBillTO);
	}

	public List<CreditedBillTO> getAllCreditedBill() {
		return (List<CreditedBillTO>) creditedBillReposatory.findAll();
	}

	public List<CreditedBillTO> getAllCreditedBillByCustId(int custId) {
		List<CreditedBillTO> bills = creditedBillRepositoryImpl.getBillsByCustId(custId);
		return bills;
	}
	
}
