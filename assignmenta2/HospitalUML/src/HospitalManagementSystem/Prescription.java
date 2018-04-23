package HospitalManagementSystem;

public class Prescription {
	private Medication medication;
	public Medication getMedication() {
		return medication;
	}
	public void setMedication(Medication medication) {
		this.medication = medication;
	}
	public Physician getPrescribingProvider() {
		return prescribingProvider;
	}
	public void setPrescribingProvider(Physician prescribingProvider) {
		this.prescribingProvider = prescribingProvider;
	}
	private Physician prescribingProvider;
}
