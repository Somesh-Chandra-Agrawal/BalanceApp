package org.punit.balanceApp.BalanceApp.Controller;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.punit.balanceApp.BalanceApp.Services.CreditedBillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creditedBill")
@Component
public class CreditedBillController {
	
	@Autowired
	CreditedBillServices creditedBillServices;
	
	@RequestMapping("/addCreditedBill")
	public void addCreditedBill(@RequestBody CreditedBillTO creditedBillTO) {
		creditedBillServices.addCreditedBill(creditedBillTO);
	}
	
	@RequestMapping("/getCreditedBills/{custId}")
	public List<CreditedBillTO> getCreditedBillsOfCustomer(@PathVariable int custId){
		return creditedBillServices.getAllCreditedBillByCustId(custId);
	}
	
	@RequestMapping("/getCreditedBills")
	public List<CreditedBillTO> getAllCreditedBills(){
		return creditedBillServices.getAllCreditedBill();
	}
}