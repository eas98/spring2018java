package HospitalManagementSystem;

public class Patient extends Person {
	public Prescription[] getPrescriptions() {
		return Prescriptions;
	}
	public void setPrescriptions(Prescription[] prescriptions) {
		Prescriptions = prescriptions;
	}
	public MedicationAdministration getMedicationAdministrations() {
		return medicationAdministrations;
	}
	public void setMedicationAdministrations(MedicationAdministration medicationAdministrations) {
		this.medicationAdministrations = medicationAdministrations;
	}
	public Procedure[] getAdministeredProcedures() {
		return administeredProcedures;
	}
	public void setAdministeredProcedures(Procedure[] administeredProcedures) {
		this.administeredProcedures = administeredProcedures;
	}
	public InsuranceInfo getInsurance() {
		return insurance;
	}
	public void setInsurance(InsuranceInfo insurance) {
		this.insurance = insurance;
	}
	public Bill[] getBills() {
		return bills;
	}
	public void setBills(Bill[] bills) {
		this.bills = bills;
	}
	protected Prescription[] Prescriptions;
	protected MedicationAdministration medicationAdministrations;
	protected Procedure[] administeredProcedures;
	protected InsuranceInfo insurance;
	protected Bill[] bills;
}
