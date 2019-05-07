package org.punit.balanceApp.BalanceApp.Controller;

import java.text.ParseException;
import java.util.List;

import org.punit.balanceApp.BalanceApp.Data.CreditedBillTO;
import org.punit.balanceApp.BalanceApp.Services.CreditedBillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;


@RestController
@RequestMapping("/creditedBill")
@Component
public class CreditedBillController {
	
	@Autowired
	CreditedBillServices creditedBillServices;
	
	@RequestMapping("/addCreditedBill")
	public String addCreditedBill(WebRequest request) {
	CreditedBillTO creditedBillTO=new CreditedBillTO();
//	custFName=hello&custLName=srio&creditAmount=1000&creditDate=24-10-1990
	creditedBillTO.setCustFName(request.getParameter("custFName"));
	creditedBillTO.setCustLName(request.getParameter("custLName"));
	creditedBillTO.setCreditAmount(Integer.parseInt(request.getParameter("creditAmount")));
	creditedBillTO.setCustId(Integer.parseInt(request.getParameter("custId")));
	
	try {
		creditedBillTO.setCreditDate(request.getParameter("creditDate"));
	} catch (ParseException e) {
		e.printStackTrace();
	}
		String billId=creditedBillServices.addCreditedBill(creditedBillTO);
		if(!StringUtils.isEmptyOrWhitespace(billId)) {
    return "Account is Credited successFully";
		}
		return "Somthing went wrong";
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