package org.punit.balanceApp.BalanceApp.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.punit.balanceApp.BalanceApp.Data.CustomerTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@RequestMapping("addCustomer")
	public void addCustomer(@RequestBody CustomerTO customerTO) {
		
	}
	
	@RequestMapping("getAllCustomer")
	public List<CustomerTO> getAllCustomer(){
		return new ArrayList<CustomerTO>();
	}
	
	@RequestMapping("getCustomer/{custId}")
	public List<CustomerTO> getAllCustomer(@PathParam(value = "custId") int custId){
		return new ArrayList<CustomerTO>();
	}

}
