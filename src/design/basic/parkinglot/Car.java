package design.basic.parkinglot;

public class Car extends Vehicle{
	
	public Car(String regnPlate) {
		super.size = VehicleSize.CAR;
		super.regnPlate = regnPlate;
		super.noOfSpotsNeeded = 1;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return (spot.getVehicleSize().equals(VehicleSize.CAR)) || (spot.getVehicleSize().equals(VehicleSize.TRUCK));
	}

}
