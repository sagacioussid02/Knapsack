package inheritance;

public interface ChannelIdentifier {
    
    public String getOrderDetailDisplay(String orderVersion);
    public String getOrderClinicalDescription(String orderVersion);
    public String getOrderClinicalDisplayLine(String orderVersion);
    public String getDeviceId();
    public String getModule();
    public String getChannel();
    public String getEnvironment();
    public boolean getSomething();

}
