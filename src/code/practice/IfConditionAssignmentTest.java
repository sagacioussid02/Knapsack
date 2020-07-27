package code.practice;

import java.util.HashMap;
import java.util.Map;

public class IfConditionAssignmentTest {

    public static void main(String[] args) {
        final String deviceId;
        SomeObject someObj = new SomeObject("some device id");
        Map<String, String> someMap = new HashMap<String, String>();
        someMap.put("valueIn", "some device id");
        someMap.put("valueOut", "some other device id");
        
        if(someMap.containsKey((deviceId = someObj.getDeviceId()))){
            System.out.println("device ID contained in Map = "+deviceId);
        } else {
            System.out.println("device ID not contained in Map = "+deviceId);  
        }
        
        System.out.println(deviceId);
        
        
    }

}

class SomeObject{
    private String deviceId;

    public SomeObject(String deviceId) {
        super();
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
