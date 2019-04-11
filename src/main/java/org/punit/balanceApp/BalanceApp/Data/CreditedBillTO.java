package org.punit.balanceApp.BalanceApp.Data;

import lombok.Data;

@Data
public class CreditedBillTO {
	
	
	private int cBillId; 
	private int custId;
	private String custFName;
	private String custLName;
	private long creditAmount;
	private String creditDate;
	
	
	public CreditedBillTO(int custId, String custFName, String custLName, long creditAmount, String creditdate) {
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.creditAmount = creditAmount;
		this.creditDate = creditdate;
	}
}
