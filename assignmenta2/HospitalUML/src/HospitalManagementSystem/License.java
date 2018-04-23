package HospitalManagementSystem;

import java.util.Date;

public class License {
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getLicenseState() {
		return licenseState;
	}
	public void setLicenseState(String licenseState) {
		this.licenseState = licenseState;
	}
	public Date getIssuanceDate() {
		return issuanceDate;
	}
	public void setIssuanceDate(Date issuanceDate) {
		this.issuanceDate = issuanceDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	private String licenseNumber;
	private String licenseState;
	private Date issuanceDate;
	private Date expirationDate;
}
