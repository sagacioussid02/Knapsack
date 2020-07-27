package code.practice;

import java.util.Arrays;
import java.util.List;


public class CoverageTest {

    public static void main(String[] args) {
        DeviceChannels channel1 = new DeviceChannels("channel1", true);
        DeviceChannels channel2 = new DeviceChannels("channel2", false);
        DeviceChannels channel3 = new DeviceChannels("channel3", true);
        DeviceChannels channel4 = new DeviceChannels("channel4", false);
        List<DeviceChannels> channelsMixed = Arrays.asList(channel1,channel2, channel3, channel4);
        final Patient patient1 = new Patient("Mixed devices", channelsMixed);
        
        DeviceChannels channel5 = new DeviceChannels("channel5", true);
        DeviceChannels channel6 = new DeviceChannels("channel6", true);
        List<DeviceChannels> channelsAllGood = Arrays.asList(channel5,channel6);
        final Patient patient2 = new Patient("Mixed devices", channelsAllGood);
        
        DeviceChannels channel7 = new DeviceChannels("channel7", false);
        DeviceChannels channel8 = new DeviceChannels("channel8", false);
        List<DeviceChannels> channelsAllBad = Arrays.asList(channel7,channel8);
        final Patient patient3 = new Patient("Mixed devices", channelsAllBad);
        
        final List<Patient> patients = Arrays.asList(patient1, patient2, patient3);
        
        testCoverage(patients);


    }
    
    
    public static void testCoverage(final List<Patient> patients) {
        for(final Patient patient:patients) {
            PatientListener patientContinuousInfusionDeviceListener = new PatientListener();
            final boolean isChannelInfoMissing = patient.getDeviceChannels().stream().anyMatch(channel -> channel.isChannelMissing());
            if(isChannelInfoMissing) {
                final DeviceChannels badChannel = patient.getDeviceChannels().stream().filter(channel -> channel.isChannelMissing()).findAny().get();
                patientContinuousInfusionDeviceListener.onUpdate(badChannel);
            } else {
                for (final DeviceChannels channel : patient.getDeviceChannels()) {
                    patientContinuousInfusionDeviceListener.onUpdate(channel);
                }
            }
        }
    }

}

class DeviceChannels{
    private final String getChannelName;
    private final boolean isChannelMissing;
    
    public DeviceChannels(final String getChannelName, final boolean isChannelMissing) {
        this.getChannelName = getChannelName;
        this.isChannelMissing = isChannelMissing;
    }

    public String getGetChannelName() {
        return getChannelName;
    }

    public boolean isChannelMissing() {
        return isChannelMissing;
    }
    
}

class PatientListener{
    
    
    
    public void onUpdate(final DeviceChannels deviceChannel) {
        if(deviceChannel.isChannelMissing()) {
            System.out.println("Setting failed channel to gadget");
        }
        else {
            System.out.println("Setting passed channel to gadget");
        }
    }
}

class Patient{
    private final String id;
    private final List<DeviceChannels> deviceChannels;
    
    public Patient(final String id, final List<DeviceChannels> deviceChannels) {
        this.id = id;
        this.deviceChannels = deviceChannels;
    }

    public String getId() {
        return id;
    }

    public List<DeviceChannels> getDeviceChannels() {
        return deviceChannels;
    }
}
