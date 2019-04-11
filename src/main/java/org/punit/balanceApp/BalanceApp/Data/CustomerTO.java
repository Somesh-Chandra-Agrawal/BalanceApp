package org.punit.balanceApp.BalanceApp.Data;

import lombok.Data;

@Data
public class CustomerTO {
	
	private int custId;
	private String custFname;
	private String custLName;
	private String city;
	private String state;
	private String contact;
	private Long totalDue;
	
	
	public CustomerTO(String custFName, String custLName, String city, String state, String contact) {
		this.custFname = custFName;
		this.custLName = custLName;
		this.city = city;
		this.state = state;
		this.contact = contact;
	}

}
