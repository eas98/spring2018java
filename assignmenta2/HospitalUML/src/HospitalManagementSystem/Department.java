package HospitalManagementSystem;

public class Department {
	protected String name;
	protected Employee[] employees; 
	protected OfficeRoom office;
	protected Employee departmentChair; 
	public Employee getDepartmentChair() {
		return departmentChair;
	}
	public void setDepartmentChair(Employee departmentChair) {
		this.departmentChair = departmentChair;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee[] getEmployees() {
		return employees;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	public OfficeRoom getOffice() {
		return office;
	}
	public void setOffice(OfficeRoom office) {
		this.office = office;
	}
}
