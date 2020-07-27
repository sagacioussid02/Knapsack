package homework;

public class VerLocationDriver {
	
public static void main(String[] args) {
	LocationDetailsInfo locationDetailsInfo = new LocationDetailsInfo();
	
	for(int i = 0; i< 2;i++) {
		LocationInfo locInfo = new LocationInfo();
		locInfo.setId("Some Id + "+i);
		locationDetailsInfo.getLocation().add(locInfo);
		locationDetailsInfo.locationInfo.add(locInfo);
	}
	
}
}
