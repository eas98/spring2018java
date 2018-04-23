package HospitalManagementSystem;

import java.util.Date;

public class InPatient extends Patient{
	private Room room;
	private Person patientCompanion;
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Person getPatientCompanion() {
		return patientCompanion;
	}
	public void setPatientCompanion(Person patientCompanion) {
		this.patientCompanion = patientCompanion;
	}
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public Date getDateOfRelease() {
		return dateOfRelease;
	}
	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	private Date dateOfAdmission;
	private Date dateOfRelease;
}
