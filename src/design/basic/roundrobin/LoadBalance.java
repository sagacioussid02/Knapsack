package design.basic.roundrobin;

public interface LoadBalance {
	
	public String getServer(String clientIp);

}
