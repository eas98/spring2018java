package HospitalManagementSystem;

public class SurgeryRoom extends Room{
	public boolean isHasTheater() {
		return hasTheater;
	}
	public void setHasTheater(boolean hasTheater) {
		this.hasTheater = hasTheater;
	}
	public boolean isHasRobotics() {
		return hasRobotics;
	}
	public void setHasRobotics(boolean hasRobotics) {
		this.hasRobotics = hasRobotics;
	}
	private boolean hasTheater;
	private boolean hasRobotics;
}
