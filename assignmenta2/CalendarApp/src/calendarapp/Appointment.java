package calendarapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Appointment {
	private String appointmentNote;
	private LocalDate appointmentDate;
	Appointment(String appointmentNote, LocalDate appointmentDate) {
		this.appointmentNote = appointmentNote;
		this.appointmentDate = appointmentDate;
	}
	public LocalDate getAppointmentDate() {
		return this.appointmentDate;
	}
	public String getAppointmentDateAsString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = this.appointmentDate.format(formatter);
		return formattedString;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public void setAppointmentDate(String strAppointmetnDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate appointmentDate = LocalDate.parse(strAppointmetnDate, formatter);
		this.appointmentDate = appointmentDate;
	}
	public void setAppointmentNote(String appointmentNote) {
		this.appointmentNote = appointmentNote;
	}
	public String getAppointmentNote() {
		return this.appointmentNote;
	}
}
