package code.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CommonBetweenTwoList {
    
    private static final Map<UnitPatient, List<ContChannel>> addedChannelsByPatient = new HashMap<UnitPatient, List<ContChannel>>();

    public static void main(String[] args) {
        UnitPatient p1 = new UnitPatient("someone");
        UnitPatient p2 = new UnitPatient("something");
        
        twoLists(p1, new ContChannel("cha2"));
        twoLists(p1, new ContChannel("cha1"));
        twoLists(p1, new ContChannel("cha3"));
        
        
    }
    
    
    public static void twoLists(UnitPatient unitPatient, ContChannel channel) {
        
        final List<ContChannel> currentChannels = new ArrayList<ContChannel>();
        boolean found = false;
        currentChannels.add(new ContChannel("cha1"));
        //currentChannels.add(new ContChannel("cha2"));
        //update the added channel list with new channel for the patient
        if(addedChannelsByPatient.containsKey(unitPatient)) {
            final List<ContChannel> addedList = addedChannelsByPatient.get(unitPatient);
            for(int i=0;i<currentChannels.size();i++) {
                final ContChannel channelCurrent = currentChannels.get(i);
                for(int j=0;j<addedList.size();j++) {
                    final ContChannel currentChannelFromAddedList = addedList.get(j);
                    if(channelCurrent.getIdentifier().equals(currentChannelFromAddedList.getIdentifier())) {
                        found = true;
                        addedList.remove(j);
                        addedList.add(channelCurrent);
                    } else {
                        addedList.add(channelCurrent);
                    }
                }
            }
            addedChannelsByPatient.put(unitPatient, addedList);
        } else {
            addedChannelsByPatient.put(unitPatient, currentChannels);
        }
    }
}

class UnitPatient{
    public String firstName;
    
    public UnitPatient(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return firstName;
    }
}

class ContChannel{
    String identifier;
    
    public ContChannel(String id){
        this.identifier = id;
    }

    public String getIdentifier() {
        return identifier;
    }
}


