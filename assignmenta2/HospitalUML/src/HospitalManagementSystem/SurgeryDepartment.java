package HospitalManagementSystem;

public class SurgeryDepartment extends Department {
	public Surgery[] getScheduledSurgeries() {
		return scheduledSurgeries;
	}
	public void setScheduledSurgeries(Surgery[] scheduledSurgeries) {
		this.scheduledSurgeries = scheduledSurgeries;
	}
	public Surgery[] getPerformedSurgeries() {
		return performedSurgeries;
	}
	public void setPerformedSurgeries(Surgery[] performedSurgeries) {
		this.performedSurgeries = performedSurgeries;
	}
	public Surgery[] getCanceledSurgeries() {
		return canceledSurgeries;
	}
	public void setCanceledSurgeries(Surgery[] canceledSurgeries) {
		this.canceledSurgeries = canceledSurgeries;
	}
	private Surgery[] scheduledSurgeries;
	private Surgery[] performedSurgeries;
	private Surgery[] canceledSurgeries;
}
