package HospitalManagementSystem;

public class Physician extends Employee {
	public boolean isIntern() {
		return isIntern;
	}

	public void setIntern(boolean isIntern) {
		this.isIntern = isIntern;
	}

	boolean isIntern;
}
