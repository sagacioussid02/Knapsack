package design.basic.parkinglot;

public class ParkingLot {
	
	//It will have levels
	private Level[] level;
	private final int NUM_OF_LEVELS = 5;
	
	public void ParkingLot() {
		this.level = new Level[NUM_OF_LEVELS];
		for(int i = 0; i < NUM_OF_LEVELS; i++) {
			level[i] = new Level(i);
		}
	}
	
	public boolean parkVehicle(Vehicle vehicle){
		for (int i = 0; i < level.length; i++){
			if (level[i].parkVehicle(vehicle))
				return true;
		}
		return false;
	}

}
