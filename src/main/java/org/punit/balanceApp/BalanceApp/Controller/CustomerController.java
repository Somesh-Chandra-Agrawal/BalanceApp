package org.punit.balanceApp.BalanceApp.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.punit.balanceApp.BalanceApp.Data.Bill;
import org.punit.balanceApp.BalanceApp.Data.CREDITDETAIL;
import org.punit.balanceApp.BalanceApp.Data.CustomerDetailTO;
import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.punit.balanceApp.BalanceApp.Services.CreditedBillServices;
import org.punit.balanceApp.BalanceApp.Services.CustomerServices;
import org.punit.balanceApp.BalanceApp.Services.DebitedBillServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/customer")
@Component
public class CustomerController {

	/** The customer services. */
	@Autowired
	CustomerServices customerServices;
	
	@Autowired
	DebitedBillServices debitedBillServices;
	
	@Autowired
	CreditedBillServices creditedBillServices;

	/** The response. */
	ResponseEntity<CustomerTO> response = null;

	/** The responses. */
	ResponseEntity<List<CustomerTO>> responses = null;

	

  /**
   * Save.
   *
   * @param customerTO the customer TO
   * @param modelAndView the model and view
   * @param request the request
   * @return the model and view
   */
  @RequestMapping(value = "/add-customer")
  public ModelAndView save(@ModelAttribute CustomerTO customerTO, ModelAndView modelAndView, WebRequest request) {
    modelAndView.setViewName("user-creation");
    modelAndView.addObject("header", " Add Customer ");
    modelAndView.addObject("customerTO", customerTO);
    return modelAndView;
  }
	/**
	 * Adds the customer.
	 *
	 * @param customerTO the customer TO
	 * @param validateCustomerTO the validate customer TO
	 * @param result the result
	 * @param mav the mav
	 * @param request the request
	 * @return the model and view
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add-customer")
	public ModelAndView addCustomer(@ModelAttribute CustomerTO customerTO, @Valid CustomerTO validateCustomerTO,
			BindingResult result, ModelAndView mav, WebRequest request) {
		if (result.hasErrors()) {
			System.err.println("Validation errors while submitting form.");
			mav.setViewName("user-creation");
			mav.addObject("header", " Add Customer ");
			mav.addObject("customerTO", customerTO);
			return mav;
		}
		int custId = customerServices.addCustomer(customerTO).getCustId();
		if (custId != 0) {
			mav.addObject("successMsg", "Customer Added SuccessFully");
			mav.setViewName("user-creation");
			mav.addObject("customerTO",new CustomerTO());
			mav.addObject("header", " Add Customer ");
			System.out.println("Form submitted successfully.");
		
		}
		return mav;
	}

	/**
	 * Gets the all customer.
	 *
	 * @return the all customer
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getAllCustomer")
	public ResponseEntity<List<CustomerTO>> getAllCustomer() {
		List<CustomerTO> allCustomers = customerServices.getAllCustomer();
		return responses = new ResponseEntity<List<CustomerTO>>(allCustomers, HttpStatus.OK);
	}

	/**
	 * Gets the all customer by cust id.
	 *
	 * @param custId the cust id
	 * @return the all customer by cust id
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getCustomer/{custId}")
	public ResponseEntity<Optional<CustomerTO>> getAllCustomerByCustId(@PathVariable int custId) {
		Optional<CustomerTO> customerTO = customerServices.getCustomerById(custId);
		return new ResponseEntity<Optional<CustomerTO>>(customerTO, HttpStatus.OK);
	}

	
	 /**
 	 * Creates the user view.
 	 *
 	 * @return the model and view
 	 */
 	@GetMapping("/home")
	  public ModelAndView createUserView() {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("home");
	      return mav;
	    }
 	
  @GetMapping("/getDetailsPage")
  public ModelAndView getDetailsPage(WebRequest request) {
    StringBuilder custId=new StringBuilder();
      ModelAndView mav = new ModelAndView();
      
      String billTable=null;
      String  creditedBillTable=null;
      if(null!=request.getParameter("custId")) {
        custId.append(request.getParameter("custId"));
      }else {
      custId.append("");
      }
      Map<String, CustomerDetailTO> getDetails=getCustomerDetailsByCustId(Integer.parseInt(custId.toString()));
      CustomerDetailTO  customerDetailTO = getDetails.get("getDetails");
      Optional<CustomerTO> customerTO = customerDetailTO.getCustomerTO();
      
      CustomerTO customer=customerTO.get();
      if(null!=customerDetailTO) {
        
     Map<String, List<Bill>> billsMap= customerDetailTO.getBillMap();

    if (!billsMap.isEmpty()) {
      List<Bill> bills = billsMap.get("BILL");
      billTable = createBillsTable(bills);
      mav.addObject("billTable",billTable);
    }
     
     Map<String, List<CREDITDETAIL>>  creditedBilsMap=customerDetailTO.getcBillMap();
     
     if (!creditedBilsMap.isEmpty()) {
       List<CREDITDETAIL> bills = creditedBilsMap.get("BILL");
       creditedBillTable = createCreditedBillsTable(bills);
       mav.addObject("creditedBillTable",creditedBillTable);
     }
      mav.addObject("custName",customer.getCustFName()+" "+customer.getCustLName());
      }else {
        mav.addObject("msg","Somthing went Wrong!!!");
      }
      mav.setViewName("user-info");
      
      return mav;
    }

  private String createCreditedBillsTable(List<CREDITDETAIL> bills) {
    StringBuilder creditedBill = new StringBuilder();
    creditedBill.append("<table class=\"table\">");
    creditedBill.append("<caption>List of Created Bills</caption>");
    creditedBill.append(" <thead><tr>");
    creditedBill.append(" <th scope=\"col\">ID</th>");
    creditedBill.append(" <th scope=\"col\">Credited Amount</th>");
    creditedBill.append(" <th scope=\"col\">Credited Date</th>");
    creditedBill.append("  </tr></thead><tbody>");
    for (CREDITDETAIL creditdetail : bills) {
      creditedBill.append("<tr>");
      creditedBill.append("<th scope=\"row\">" + creditdetail.getcBillId() + "</th>");
      creditedBill.append("<td>" + creditdetail.getCreditAmount() + "</td>");
      creditedBill.append("<td>" + creditdetail.getCreditDate() + "</td>");
      creditedBill.append("</tr>");

    }
    creditedBill.append("</tbody></table>");

    return creditedBill.toString();
  }
	
	
  private String createBillsTable(List<Bill> bills) {
    
    StringBuilder dbill=new StringBuilder();
    dbill.append("<table class=\"table\">");
    dbill.append("<caption>List of Created Bills</caption>");
    dbill.append(" <thead><tr>");
    dbill.append(" <th scope=\"col\">ID</th>");
    dbill.append(" <th scope=\"col\">Bill Amount</th>");
    dbill.append(" <th scope=\"col\">Bill Date</th>");
    dbill.append(" <th scope=\"col\">Clear Flag</th>");
    dbill.append(" <th scope=\"col\">Clear Date</th>");
    dbill.append(" <th scope=\"col\">Date Count</th>");
    dbill.append(" <th scope=\"col\">Due</th>");
    dbill.append("  </tr></thead><tbody>");
    for (Bill bill : bills) {
      dbill.append("<tr>");
      dbill.append("<th scope=\"row\">" + bill.getBillId() + "</th>");
      dbill.append("<td>" + bill.getBillAmount()+ "</td>");
      dbill.append("<td>" + bill.getBillDate()+ "</td>");
      dbill.append("<td>" + bill.getClearFlag()+ "</td>");
      dbill.append("<td>" + bill.getBillClearDate()+ "</td>");
      dbill.append("<td>" + bill.getDateCount()+ "</td>");
      dbill.append("<td>" + bill.getDue()+ "</td>");
      dbill.append("</tr>");
    }
    dbill.append("</tbody></table>");
    return dbill.toString();
  }
  /**
	 * Gets the all customer by cust id.
	 *
	 * @param custId the cust id
	 * @return the all customer by cust id
	 */
	public Map<String, CustomerDetailTO> getCustomerDetailsByCustId(@PathVariable int custId) {
		
		Optional<CustomerTO> customerTO = customerServices.getCustomerById(custId);
		List<Bill> billTOs = debitedBillServices.getAllBillByCustId(custId);
		List<CREDITDETAIL> cBillTOs = creditedBillServices.getAllCreditedBillByCustId(custId);
		
		Map<String, CustomerDetailTO> output=new HashMap<>();
		Integer billAamount = 0;
		Integer cBillAamount = 0;
		
		for (Bill bill : billTOs) {
			billAamount = billAamount + bill.getBillAmount();
		}
		
		for (CREDITDETAIL cbill : cBillTOs) {
			cBillAamount = cBillAamount + cbill.getCreditAmount();
		}
		
		CustomerDetailTO customerDetailTO = new CustomerDetailTO();
		Map<String, List<Bill>> billTOMap = new HashMap<String, List<Bill>>();
		Map<String, List<CREDITDETAIL>> cBillTOMap = new HashMap<String, List<CREDITDETAIL>>();
		billTOMap.put("BILL", billTOs);
		cBillTOMap.put("CREDITDETAIL", cBillTOs);
		
		customerDetailTO.setCustomerTO(customerTO);
		customerDetailTO.setBillMap(billTOMap);
		customerDetailTO.setTotalBillAmount(billAamount);
		customerDetailTO.setTotalCBillAmount(cBillAamount);
		customerDetailTO.setcBillMap(cBillTOMap);
		output.put("getDetails", customerDetailTO);
		
//		return new ResponseEntity<CustomerDetailTO>(customerDetailTO, HttpStatus.OK);
		return output;
		
	}
 	
}
