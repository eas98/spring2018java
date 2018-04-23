package HospitalManagementSystem;

public class OutPatient extends Patient{
	private String admittingProvider;

	public String getAdmittingProvider() {
		return admittingProvider;
	}

	public void setAdmittingProvider(String admittingProvider) {
		this.admittingProvider = admittingProvider;
	}
}
