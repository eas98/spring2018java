package HospitalManagementSystem;

import java.time.LocalDateTime;

public class MedicationAdministration {
	public Medication getMedication() {
		return medication;
	}
	public void setMedication(Medication medication) {
		this.medication = medication;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public Provider getAdministeringProvider() {
		return administeringProvider;
	}
	public void setAdministeringProvider(Provider administeringProvider) {
		this.administeringProvider = administeringProvider;
	}
	public LocalDateTime getAdministrationTimeStamp() {
		return administrationTimeStamp;
	}
	public void setAdministrationTimeStamp(LocalDateTime administrationTimeStamp) {
		this.administrationTimeStamp = administrationTimeStamp;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	private Medication medication;
	private Prescription prescription;
	private Provider administeringProvider;
	private LocalDateTime administrationTimeStamp;
	private Patient patient;
}
