package HospitalManagementSystem;

public class Provider extends Employee {
	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	private License license;
}
