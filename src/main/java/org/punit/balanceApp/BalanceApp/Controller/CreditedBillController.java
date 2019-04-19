package org.punit.balanceApp.BalanceApp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("creditedBill")
public class CreditedBillController {
	
	@RequestMapping("addCreditedBill")
	public void addCreditedBill(@RequestBody CreditedBillTO creditedBillTO) {
	}
	
	
	
	@RequestMapping("getCreditedBills/{custId}")
	public List<CreditedBillTO> getCreditedBillsOfCustomer(@PathParam(value = "custId") int custid){
		return new ArrayList<CreditedBillTO>();
	}
}
