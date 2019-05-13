package org.punit.balanceApp.BalanceApp.Data;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerDetailTO {

	private Optional<CustomerTO> customerTO;
	
	private Map<String, List<Bill>> billMap;
	
	private Map<String, List<CREDITDETAIL>> cBillMap;

	
	public Optional<CustomerTO> getCustomerTO() {
		return customerTO;
	}

	public void setCustomerTO(Optional<CustomerTO> customerTO) {
		this.customerTO = customerTO;
	}

	public Map<String, List<Bill>> getBillMap() {
		return billMap;
	}

	public void setBillMap(Map<String, List<Bill>> billMap) {
		this.billMap = billMap;
	}

	public Map<String, List<CREDITDETAIL>> getcBillMap() {
		return cBillMap;
	}

	public void setcBillMap(Map<String, List<CREDITDETAIL>> cBillMap) {
		this.cBillMap = cBillMap;
	}

}