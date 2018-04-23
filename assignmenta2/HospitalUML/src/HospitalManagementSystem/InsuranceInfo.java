package HospitalManagementSystem;

import java.util.Currency;

public class InsuranceInfo {
	private String insuranceCompanyName;
	private String planNumber;
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public String getPlanNumber() {
		return planNumber;
	}
	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getPrimaryAccountHolder() {
		return primaryAccountHolder;
	}
	public void setPrimaryAccountHolder(String primaryAccountHolder) {
		this.primaryAccountHolder = primaryAccountHolder;
	}
	public Currency getRxDeductible() {
		return rxDeductible;
	}
	public void setRxDeductible(Currency rxDeductible) {
		this.rxDeductible = rxDeductible;
	}
	private String groupNumber;
	private String primaryAccountHolder;
	private Currency rxDeductible;
}
