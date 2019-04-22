package org.punit.balanceApp.BalanceApp.Controller;

import java.util.List;
import java.util.Optional;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.punit.balanceApp.BalanceApp.Services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;
	
	ResponseEntity<CustomerTO> response = null;
	
	ResponseEntity<List<CustomerTO>> responses = null;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCustomer")
	public ResponseEntity<CustomerTO> addCustomer(@RequestBody CustomerTO customerTO) {
		CustomerTO addedCustomerTO = customerServices.addCustomer(customerTO);
		if (addedCustomerTO != null ) {
			response = new ResponseEntity<>(addedCustomerTO, HttpStatus.CREATED);
		} else{
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllCustomer")
	public ResponseEntity<List<CustomerTO>> getAllCustomer(){
		List<CustomerTO> allCustomers = customerServices.getAllCustomer();
		return responses = new ResponseEntity<List<CustomerTO>>(allCustomers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getCustomer/{custId}")
	public ResponseEntity<Optional<CustomerTO>> getAllCustomerByCustId(@PathVariable int custId) {
		Optional<CustomerTO> customerTO = customerServices.getCustomerById(custId);
		return new ResponseEntity<Optional<CustomerTO>>(customerTO, HttpStatus.OK);
	}

}
