package org.punit.balanceApp.BalanceApp.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CreditDetail")
public class CreditedBillTO {
	
	@Id
	@Column(name = "BILLID")
	private int cBillId; 
	@Column(name = "CUSTID")
	private int custId;
	@Column(name = "CUSTFNAME")
	private String custFName;
	@Column(name = "CUSTLNAME")
	private String custLName;
	@Column(name = "CREDITAMOUNT")
	private long creditAmount;
	@Column(name = "CREDITEDDATE")
	private String creditDate;
	
	public CreditedBillTO() {
	}
	
	public CreditedBillTO(int custId, String custFName, String custLName, long creditAmount, String creditdate) {
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.creditAmount = creditAmount;
		this.creditDate = creditdate;
	}


	public int getcBillId() {
		return cBillId;
	}


	public void setcBillId(int cBillId) {
		this.cBillId = cBillId;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public String getCustFName() {
		return custFName;
	}


	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}


	public String getCustLName() {
		return custLName;
	}


	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}


	public long getCreditAmount() {
		return creditAmount;
	}


	public void setCreditAmount(long creditAmount) {
		this.creditAmount = creditAmount;
	}


	public String getCreditDate() {
		return creditDate;
	}


	public void setCreditDate(String creditDate) {
		this.creditDate = creditDate;
	}
	
	
}
