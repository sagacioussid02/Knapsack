package design.basic.parkinglot;

public class ParkingSpot {
	
	private Vehicle vehicle;
	private VehicleSize vehicleSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Vehicle vehicle, VehicleSize vehicleSize, int row, int spotNumber, Level level) {
		this.vehicle = vehicle;
		this.vehicleSize = vehicleSize;
		this.row = row;
		this.spotNumber = spotNumber;
		this.level = level;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getSpotNumber() {
		return this.spotNumber;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public VehicleSize getVehicleSize() {
		return this.vehicleSize;
	}
	
	public Vehicle Vehicle() {
		return this.vehicle;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() || vehicle.canFitInSpot(this);
	}
	
	public boolean park(Vehicle vehicle) {
		if(canFitVehicle(vehicle)) {
			this.vehicle = vehicle;
			vehicle.parkInTheSpot(this);
			return true;
		} else return false;
	}

}
