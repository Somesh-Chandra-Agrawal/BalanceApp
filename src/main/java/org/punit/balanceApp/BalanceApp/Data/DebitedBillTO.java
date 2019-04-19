package org.punit.balanceApp.BalanceApp.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Bill")
public class DebitedBillTO {
	
	@Id
	@Column(name = "BillId")
	private int billId;
	@Column(name = "CustId")
	private int custId;
	@Column(name = "CustFName")
	private String custFName;
	@Column(name = "CustLName")
	private String custLName;
	@Column(name = "BillAmount")
	private long billAmount;
	@Column(name = "Billdate")
	private String billDate;
	@Column(name = "ClearDate")
	private String billClearDate;
	@Column(name = "ClearFlag")
	private boolean clearFlag;
	@Column(name = "DateCount")
	private int dateCount;
	
	public DebitedBillTO(int custId, String custFName, String custLName, long billAmount, String billdate) {
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.billAmount = billAmount;
		this.billDate = billdate;
	}
	
	
	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
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


	public long getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(long billAmount) {
		this.billAmount = billAmount;
	}


	public String getBillDate() {
		return billDate;
	}


	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}


	public String getBillClearDate() {
		return billClearDate;
	}


	public void setBillClearDate(String billClearDate) {
		this.billClearDate = billClearDate;
	}


	public boolean isClearFlag() {
		return clearFlag;
	}


	public void setClearFlag(boolean clearFlag) {
		this.clearFlag = clearFlag;
	}


	public int getDateCount() {
		return dateCount;
	}


	public void setDateCount(int dateCount) {
		this.dateCount = dateCount;
	}

	
}
