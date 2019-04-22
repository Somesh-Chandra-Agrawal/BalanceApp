package org.punit.balanceApp.BalanceApp.Controller;

import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.DebitedBillTO;
import org.punit.balanceApp.BalanceApp.Services.DebitedBillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/debitedBill")
public class DebitedBillController {
	
	@Autowired
	DebitedBillServices debitedBillServices;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "getDebitedBills/{custId}")
	public List<DebitedBillTO> getAllDebitedBillByCustId(@PathVariable int custId) {
		 return debitedBillServices.getAllBillByCustId(custId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addBill")
	public void addDebitedBill(@RequestBody DebitedBillTO debitedBillTO) {
		debitedBillServices.addDebitedBill(debitedBillTO);
	}
	
	
}
