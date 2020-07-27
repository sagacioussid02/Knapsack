package inheritance;

public class ChaiAssociatedChannelIdentifier extends ChaiChannelIdentifier{

    private final String p2daIdentifier;
    private final String correlationRecordId;
    
    public ChaiAssociatedChannelIdentifier(String p2daIdentifier, String correlationRecordId, String deviceId, String module, String channel, String environment) {
        super(deviceId, module, channel, environment);
        this.p2daIdentifier = p2daIdentifier;
        this.correlationRecordId = correlationRecordId;
    }
    
    public ChaiAssociatedChannelIdentifier(String p2daIdentifier, String correlationRecordId, String deviceId, String module, String channel, String environment, boolean something) {
        super(deviceId, module, channel, environment, something);
        this.p2daIdentifier = p2daIdentifier;
        this.correlationRecordId = correlationRecordId;
    }

    public String getP2DAIdentifier() {
        return p2daIdentifier;
    }

    public String getCorrelationRecordId() {
        return correlationRecordId;
    }
}
