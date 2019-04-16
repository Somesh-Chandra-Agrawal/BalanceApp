package org.punit.balanceApp.BalanceApp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import org.punit.balanceApp.BalanceApp.Data.DebitedBillTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("Debited")
public class DebitedBillController {
	
	@RequestMapping("/getDebiedBills/{custId}")
	public List<DebitedBillTO> getAllDebitedBillByCustId(@PathVariable int custId) {
		 List<DebitedBillTO> debitedBillTOs = new ArrayList<>();
		 DebitedBillTO debitedBillTO = new DebitedBillTO(1, "Somesh", "Agrawal", 12000, "05/06/2018");
		 debitedBillTOs.add(debitedBillTO);
		 return debitedBillTOs;
	}

}
