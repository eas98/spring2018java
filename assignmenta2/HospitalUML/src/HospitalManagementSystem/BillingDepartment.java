package HospitalManagementSystem;

public class BillingDepartment extends Department{
	private Bill[] outstandingBills;
	private Bill[] fulfilledBills;
	public Bill[] getOutstandingBills() {
		return outstandingBills;
	}
	public void setOutstandingBills(Bill[] outstandingBills) {
		this.outstandingBills = outstandingBills;
	}
	public Bill[] getFulfilledBills() {
		return fulfilledBills;
	}
	public void setFulfilledBills(Bill[] fulfilledBills) {
		this.fulfilledBills = fulfilledBills;
	}
}
