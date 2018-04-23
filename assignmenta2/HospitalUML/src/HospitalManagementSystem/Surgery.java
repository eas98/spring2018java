package HospitalManagementSystem;

public class Surgery {
	private SurgeryClass surgeryClass;
	private String name;
	private Patient patient;
	private Surgeon[] surgeons;
	private Employee[] supportingStaff;
	private Nurse[] nurses;
	public SurgeryClass getSurgeryClass() {
		return surgeryClass;
	}
	public void setSurgeryClass(SurgeryClass surgeryClass) {
		this.surgeryClass = surgeryClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Surgeon[] getSurgeons() {
		return surgeons;
	}
	public void setSurgeons(Surgeon[] surgeons) {
		this.surgeons = surgeons;
	}
	public Employee[] getSupportingStaff() {
		return supportingStaff;
	}
	public void setSupportingStaff(Employee[] supportingStaff) {
		this.supportingStaff = supportingStaff;
	}
	public Nurse[] getNurses() {
		return nurses;
	}
	public void setNurses(Nurse[] nurses) {
		this.nurses = nurses;
	}
}
