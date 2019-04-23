package org.punit.balanceApp.BalanceApp.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CREDITDETAIL")
public class CreditedBillTO {
	
	
	@Id
	@Column(name = "BILLID")
	private Integer cBillId; 
	@Column(name = "CUSTID")
	private Integer custId;
	@Column(name = "CUSTFNAME")
	private String custFName;
	@Column(name = "CUSTLNAME")
	private String custLName;
	@Column(name = "CREDITAMOUNT")
	private Long creditAmount;
	@Column(name = "CREDITEDDATE")
	private String creditDate;
	
	public CreditedBillTO() {
	}
	
	public CreditedBillTO(Integer custId, String custFName, String custLName, Long creditAmount, String creditdate) {
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.creditAmount = creditAmount;
		this.creditDate = creditdate;
	}
	
	public CreditedBillTO(Integer cBillId, Integer custId, String custFName, String custLName, Long creditAmount, String creditdate) {
		this.cBillId = cBillId;
		this.custId = custId;
		this.custFName = custFName;
		this.custLName = custLName;
		this.creditAmount = creditAmount;
		this.creditDate = creditdate;
	}

	public Integer getcBillId() {
		return cBillId;
	}

	public void setcBillId(Integer cBillId) {
		this.cBillId = cBillId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
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

	public Long getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Long creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getCreditDate() {
		return creditDate;
	}

	public void setCreditDate(String creditDate) {
		this.creditDate = creditDate;
	}
	
}
