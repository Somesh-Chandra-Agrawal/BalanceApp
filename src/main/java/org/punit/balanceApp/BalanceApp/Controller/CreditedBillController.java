package org.punit.balanceApp.BalanceApp.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.punit.balanceApp.BalanceApp.Services.CreditedBillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("creditedBill")
public class CreditedBillController {
	
	@Autowired
	private CreditedBillServices creditedBillServices;
	
	@RequestMapping("addCreditedBill")
	public void addCreditedBill(@RequestBody CreditedBillTO creditedBillTO) {
		creditedBillServices.addCreditedBill(creditedBillTO);
	}
	
	@RequestMapping("getCreditedBills/{custId}")
	public List<CreditedBillTO> getCreditedBillsOfCustomer(@PathParam(value = "custId") int custId){
		return creditedBillServices.getAllCreditedBillByCustId(custId);
	}
	
	@RequestMapping("getCreditedBills")
	public List<CreditedBillTO> getAllCreditedBills(){
		return creditedBillServices.getAllCreditedBill();
	}
}
