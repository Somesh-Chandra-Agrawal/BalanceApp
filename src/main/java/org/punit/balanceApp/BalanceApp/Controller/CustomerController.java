package org.punit.balanceApp.BalanceApp.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.punit.balanceApp.BalanceApp.Services.CustomerServices;
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
      if(null!=request.getParameter("custId")) {
        custId.append(request.getParameter("custId"));
      }else {
      custId.append("");
      }
      mav.addObject("custId",custId);
      mav.setViewName("user-info");
      return mav;
    }

 	
 	
}
