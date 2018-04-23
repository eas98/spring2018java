package HospitalManagementSystem;

public class WardRoom extends Room{
	public Bed[] getBeds() {
		return beds;
	}
	public void setBeds(Bed[] beds) {
		this.beds = beds;
	}
	public Patient[] getPatients() {
		return patients;
	}
	public void setPatients(Patient[] patients) {
		this.patients = patients;
	}
	private Bed[] beds;
	private Patient [] patients;
}
