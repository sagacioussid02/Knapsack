package design.basic.roundrobin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoundRobin implements LoadBalance {
	
	public static Integer position = 0;

	@Override
	public String getServer(String clientIp) {
		//get the list of all servers
		Set<String> availableServers = IPpool.serverByWeight.keySet();
		List<String> availableServerList = new ArrayList<String>();
		availableServerList.addAll(availableServers);
		String target = "";
		
		synchronized (position) {
			if(position >= availableServerList.size()) position = 0;
			target = availableServerList.get(position);
			position++;
		}
		return target;
	}

}
