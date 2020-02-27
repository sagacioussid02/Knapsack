package design.basic.parkinglot;

public class Level {
	
	private int position;
	private int rows;
	private int noOfSpots;
	private ParkingSpot[] spots;
	private int noOfSpotsAvailable;
	
	public Level(int position, int rows, int noOfSpots) {
		this.position = position;
		this.rows = rows;
		this.noOfSpots = noOfSpots;
		this.noOfSpotsAvailable = rows * noOfSpots;
	}
	
	public Level(int position) {
		this.position = position;
		this.rows = 30;
		this.noOfSpots = 10;
		this.noOfSpotsAvailable = rows * noOfSpots;
	}
	
	public int getLevel() {
		return this.position;
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getNoOfSpots() {
		return this.noOfSpots;
	}
	
	public boolean parkVehicle(Vehicle vehicle) {
		int noOfSpotsNeeded = vehicle.getNumberOfSpots();
		noOfSpotsAvailable -= noOfSpotsNeeded;
		
		if(noOfSpotsAvailable < 0) return false;
		
		return parkAtFirstAvailable(vehicle, noOfSpotsAvailable);
	}

	private boolean parkAtFirstAvailable(Vehicle vehicle, int noOfSpotsAvailable2) {
		for(ParkingSpot spot: spots) {
			if(vehicle.canFitInSpot(spot)) {
				noOfSpotsAvailable--;
				return true;
			}
		}
		return false;
	}
	
	
	

}
