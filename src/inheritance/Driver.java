package inheritance;

public class Driver {

    public static void main(String[] args) {
        ChaiAssociatedChannelIdentifier iden = new ChaiAssociatedChannelIdentifier("id", "corrId", "devId", "module", "channel", "env", true);
        ChannelIdentifier interfaceId = new ChaiAssociatedChannelIdentifier("Inetrid", "IntercorrId", "InterdevId", "Intermodule", "Interchannel", "env", true);
        ChannelIdentifier interfaceId1 = new ChaiAssociatedChannelIdentifier("Inetrid", "IntercorrId", "InterdevId", "Intermodule", "Interchannel", "env");
        ChannelIdentifier extendedId = new ChaiChannelIdentifier("Inetrid", "IntercorrId", "InterdevId", "Intermodule", true);
        ChaiChannelIdentifier implementationId = new ChaiAssociatedChannelIdentifier("Inetrid", "IntercorrId", "InterdevId", "Intermodule", "Interchannel", "env", true);
        ChaiChannelIdentifier implementationId1 = new ChaiAssociatedChannelIdentifier("Inetrid", "IntercorrId", "InterdevId", "Intermodule", "Interchannel", "env");
        
        System.out.println(implementationId1.getSomething());
        System.out.println(implementationId.getSomething());
        System.out.println(interfaceId1.getSomething());
        System.out.println(interfaceId.getSomething());
        
    }

}
