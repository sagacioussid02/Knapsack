package design.basic.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
	
	protected VehicleSize size;
	protected String regnPlate;
	protected int noOfSpotsNeeded;
	private Level level;
	private List<ParkingSpot> spots;
	
	public Vehicle() {
		this.spots = new ArrayList<ParkingSpot>();
	}
	
	public void parkInTheSpot(ParkingSpot spot) {
		spots.add(spot);
	}
	
	public int getNumberOfSpots() {
		return noOfSpotsNeeded;
	}
	
	public abstract boolean canFitInSpot(ParkingSpot spot);

}
