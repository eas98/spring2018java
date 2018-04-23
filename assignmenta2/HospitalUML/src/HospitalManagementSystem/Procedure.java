package HospitalManagementSystem;

import java.time.LocalDateTime;

public class Procedure {
	public String getProcedureCode() {
		return procedureCode;
	}
	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}
	public LocalDateTime getProcedureTimeStamp() {
		return procedureTimeStamp;
	}
	public void setProcedureTimeStamp(LocalDateTime procedureTimeStamp) {
		this.procedureTimeStamp = procedureTimeStamp;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	private String procedureCode;
	private LocalDateTime procedureTimeStamp;
	private Provider provider;
	private Patient patient;
}
