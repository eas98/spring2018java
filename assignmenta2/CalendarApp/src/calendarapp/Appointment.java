package calendarapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Appointment {
	private String appointmentNote;
	private LocalDate appointmentDate;
	public Appointment(LocalDate appointmentDate,String appointmentNote) {
		this.appointmentDate = appointmentDate;
		this.appointmentNote = appointmentNote;
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
	
	public static LocalDate parseAppointmentDate(String strAppointmetnDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate appointmentDate = LocalDate.parse(strAppointmetnDate, formatter);
		return appointmentDate;
	}
}
