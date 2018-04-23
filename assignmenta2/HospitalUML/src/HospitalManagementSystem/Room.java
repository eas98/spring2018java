package HospitalManagementSystem;

public class Room {
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getSquareFeetage() {
		return SquareFeetage;
	}
	public void setSquareFeetage(int squareFeetage) {
		SquareFeetage = squareFeetage;
	}
	public Equipment[] getEquipments() {
		return equipments;
	}
	public void setEquipments(Equipment[] equipments) {
		this.equipments = equipments;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	protected String roomNumber;
	protected int SquareFeetage;
	protected Equipment[] equipments;
	protected Building building;
}
