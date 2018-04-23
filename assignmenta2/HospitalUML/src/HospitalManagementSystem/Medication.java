package HospitalManagementSystem;

public class Medication {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MedicationSchedule getSchedule() {
		return schedule;
	}
	public void setSchedule(MedicationSchedule schedule) {
		this.schedule = schedule;
	}
	private String name;
	private MedicationSchedule schedule;
}
