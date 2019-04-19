package org.punit.balanceApp.BalanceApp.Controller;

import java.util.ArrayList;
import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.DebitedBillTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("debitedBill")
public class DebitedBillController {
	
	private static List<DebitedBillTO> debitedBillTOs = new ArrayList<>();
	
	@RequestMapping("getDebitedBills/{custId}")
	public List<DebitedBillTO> getAllDebitedBillByCustId(@PathVariable int custId) {
		 return debitedBillTOs;
	}
	
	@RequestMapping("addBill")
	public void addDebitedBill(@RequestBody DebitedBillTO debitedBillTO) {
		int size = debitedBillTOs.size();
		debitedBillTO.setBillId(size+1);
		debitedBillTOs.add(debitedBillTO);
	}

}
