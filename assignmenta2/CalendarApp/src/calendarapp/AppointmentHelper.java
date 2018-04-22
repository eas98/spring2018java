package calendarapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

public class AppointmentHelper {
	public static Hashtable<String, Appointment> convertAppointmentsToMap(Iterable<Appointment> appointments){
		Hashtable<String, Appointment> mapDateToNote = new Hashtable<String, Appointment>();
		for(Appointment appointment:appointments) {
			mapDateToNote.put(appointment.getAppointmentDateAsString(), appointment);
		}
		return mapDateToNote;
	}
	
	public static List<Appointment> convertAppointmentMapToArray(Hashtable<String, Appointment> mapDateToNote) {
		Collection<Appointment> appointments = mapDateToNote.values();
		ArrayList<Appointment> list = new ArrayList<Appointment>(appointments);
		return list;
	}
}
