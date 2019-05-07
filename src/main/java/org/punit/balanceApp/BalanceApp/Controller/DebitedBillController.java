package org.punit.balanceApp.BalanceApp.Controller;

import java.text.ParseException;
import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.Bill;
import org.punit.balanceApp.BalanceApp.Services.DebitedBillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.util.StringUtils;

@RestController
@Component
@RequestMapping("/debitedBill")
public class DebitedBillController {
	
	@Autowired
	DebitedBillServices debitedBillServices;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getDebitedBills/{custId}")
	public List<Bill> getAllDebitedBillByCustId(@PathVariable Integer custId) {
		 return debitedBillServices.getAllBillByCustId(custId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/addBill")
	public String addDebitedBill(WebRequest request) throws ParseException {
	  Bill debitedBillTO=new Bill();
//	  custFNameDebit=brad&custLNameDebit=pitt&billAmount=&billDate=&billClearDate=&billClearDate=&due= custId
	  debitedBillTO.setCustId(Integer.parseInt(request.getParameter("custId")));
	  debitedBillTO.setCustFName(request.getParameter("custFNameDebit"));
	  debitedBillTO.setCustLName(request.getParameter("custLNameDebit"));
	  debitedBillTO.setBillAmount(Integer.parseInt(request.getParameter("billAmount")));
	  debitedBillTO.setBillDate(request.getParameter("billDate"));
	  //debitedBillTO.setBillClearDate();
	  //debitedBillTO.setDue(Integer.parseInt(request.getParameter("due")));
	  //debitedBillTO.setDateCount(Integer.parseInt(request.getParameter("dateCount")));
		String billId=debitedBillServices.addDebitedBill(debitedBillTO);
		if(!StringUtils.isEmptyOrWhitespace(billId)) {
    return "Account Debited successfully";
		}
		return "Something went wrong";
	}
	
	
}
