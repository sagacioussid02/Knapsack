package inheritance;

public class ChaiChannelIdentifier implements ChannelIdentifier {
    
    private final String deviceId;
    private final String module;
    private final String channel;
    private final String environment;
    private final boolean something;
    
    public ChaiChannelIdentifier(final String deviceId, final String module, final String channel, final String environment, final boolean something) {
        this.deviceId = deviceId;
        if ("".equals(module)) { //$NON-NLS-1$
            // convert empty string module to null such that there is only one internal representation of no module
            this.module = null;
        } else {
            this.module = module;
        }
        this.channel = channel;
        this.environment = environment;
        this.something = something;
    }
    
    public ChaiChannelIdentifier(final String deviceId, final String module, final String channel, final String environment) {
        this.deviceId = deviceId;
        if ("".equals(module)) { //$NON-NLS-1$
            // convert empty string module to null such that there is only one internal representation of no module
            this.module = null;
        } else {
            this.module = module;
        }
        this.channel = channel;
        this.environment = environment;
        this.something = false;
    }
    


    @Override
    public String getOrderDetailDisplay(String orderVersion) {
        return null;
    }

    @Override
    public String getOrderClinicalDescription(String orderVersion) {
        return null;
    }

    @Override
    public String getOrderClinicalDisplayLine(String orderVersion) {
        return null;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public String getModule() {
        return module;
    }

    @Override
    public String getChannel() {
        return channel;
    }

    @Override
    public String getEnvironment() {
        return environment;
    }

    @Override
    public boolean getSomething() {
        return something;
    }

}
