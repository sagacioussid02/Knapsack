package design.basic.roundrobin;

import java.util.HashMap;
import java.util.Map;

public class IPpool {
	
	static Map<String, Integer> serverByWeight = new HashMap<String, Integer>();
	
	static {
		serverByWeight.put("192.168.1.1", 10);
		serverByWeight.put("192.168.1.2", 10);
		serverByWeight.put("192.168.1.3", 10);
		serverByWeight.put("192.168.1.4", 10);
		serverByWeight.put("192.168.1.5", 10);
	}
	
	public static void addServer(String ip) {
		serverByWeight.put(ip, 10);
	}
	
	public static void removeServer(String ip) {
		serverByWeight.remove(ip);
	}

}
