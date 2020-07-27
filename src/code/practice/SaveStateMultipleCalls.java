package code.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveStateMultipleCalls {
    
    public static void main(String[] args) {
        
        List<OnePatient> patientList = new ArrayList<OnePatient>();
        OnePatient p1 = new OnePatient("one", Arrays.asList("cha1","cha2"));
        OnePatient p2 = new OnePatient("one", Arrays.asList("cha3","cha4"));
        patientList.add(new OnePatient("one", Arrays.asList("cha1","cha2")));
        patientList.add(new OnePatient("one", Arrays.asList("cha3","cha4")));
        
        ListenerOperation op1 = new ListenerOperation(p1);
        ListenerOperation op2 = new ListenerOperation(p2);
        
        
        op1.loadChannels("cha2");
        op1.loadChannels("cha1");
        
        op1.loadChannels("cha1");
        op1.loadChannels("cha2");
        
        op2.loadChannels("cha3");
        
    }

}


class OnePatient{
    
    String patientName;
    List<String> channels;
    
    public OnePatient(String patientName, List<String> channels) {
        this.patientName = patientName;
        this.channels = channels;
    }
    
    public void setFailedChannelForPatient() {
        System.out.println("Setting failed channel");
    }
    
    public void setChannelForPatient() {
        System.out.println("Setting success channel");
    }
}


class ListenerOperation{
    
    OnePatient pat;
    boolean missingState = false;
    List<String> queuedChannel = new ArrayList<String>();
    
    public ListenerOperation(OnePatient pat) {
        this.pat = pat;
    }
    
    public void loadChannels(String value) {
         boolean isMissing = false;
         queuedChannel.add(value);
         isMissing = queuedChannel.stream().anyMatch(ch -> ch.equals("cha2"));
         
         if(isMissing) {
             pat.setFailedChannelForPatient();
         } else {
             pat.setChannelForPatient();
         }
         
     }
}