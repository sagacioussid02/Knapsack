package design.basic.consistenthash;

public interface HashFunction {
	public long getHashKey(String clientIp);
}
