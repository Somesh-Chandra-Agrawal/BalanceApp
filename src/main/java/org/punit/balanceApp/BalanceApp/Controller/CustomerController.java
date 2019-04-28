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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/customer")
@Component
public class CustomerController {

	@Autowired
	CustomerServices customerServices;

	ResponseEntity<CustomerTO> response = null;

	ResponseEntity<List<CustomerTO>> responses = null;

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

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCustomer")
	public ResponseEntity<List<CustomerTO>> getAllCustomer() {
		List<CustomerTO> allCustomers = customerServices.getAllCustomer();
		return responses = new ResponseEntity<List<CustomerTO>>(allCustomers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCustomer/{custId}")
	public ResponseEntity<Optional<CustomerTO>> getAllCustomerByCustId(@PathVariable int custId) {
		Optional<CustomerTO> customerTO = customerServices.getCustomerById(custId);
		return new ResponseEntity<Optional<CustomerTO>>(customerTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/add-customer")
	public ModelAndView save(@ModelAttribute CustomerTO customerTO, ModelAndView modelAndView, WebRequest request) {
		modelAndView.setViewName("user-creation");
		modelAndView.addObject("header", " Add Customer ");
		modelAndView.addObject("customerTO", customerTO);
		return modelAndView;
	}

}
