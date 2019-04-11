package org.punit.balanceApp.BalanceApp.Data;

import lombok.Data;

@Data
public class DebitedBillTO {
	
	
	private int billId;
	private int custId;
	private String custFName;
	private String custLName;
	private long billAmount;
	private String billDate;
	private String billClearDate;
	private boolean clearFlag;
	private int dateCount;
	
	
	public DebitedBillTO(int custId, String custFName, String custLName, long billAmount, String billdate) {
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.billAmount = billAmount;
		this.billDate = billdate;
	}
	
}
