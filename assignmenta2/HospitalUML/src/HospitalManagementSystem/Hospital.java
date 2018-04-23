package HospitalManagementSystem;

public class Hospital {
	public Employee getPresident() {
		return President;
	}
	public void setPresident(Employee president) {
		President = president;
	}
	public Department[] getDepartments() {
		return departments;
	}
	public void setDepartments(Department[] departments) {
		this.departments = departments;
	}
	private String name;
	private String phone;
	private Address address;
	private Building[] buildings;
	private Employee President;
	private Department[] departments;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Building[] getBuildings() {
		return buildings;
	}
	public void setBuildings(Building[] buildings) {
		this.buildings = buildings;
	} 
}
