package design.basic.consistenthash;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConsistentHashing<T extends Node> {
	
    private final SortedMap<Long, VirtualNode<T>> ring = new TreeMap<>();
    private final HashFunction hashFunction;
	
    public ConsistentHashing(Collection<T> pNodes, int vNodeCount) {
        this(pNodes,vNodeCount, new MD5Hash());
    }
	
	public ConsistentHashing(Collection<T> pNodes, int vNodeCount, MD5Hash md5Hash) {
        if (md5Hash == null) {
            throw new NullPointerException("Hash Function is null");
        }
        this.hashFunction = md5Hash;
        if (pNodes != null) {
            for (T pNode : pNodes) {
                addNode(pNode, vNodeCount);
            }
        }
	}

	public void addNode(T serverNode, int virtualServerCount) {
        if (virtualServerCount < 0) throw new IllegalArgumentException("illegal virtual node counts :" + virtualServerCount);
        int existingReplicas = getExistingReplicas(serverNode);
        for (int i = 0; i < virtualServerCount; i++) {
            VirtualNode<T> vNode = new VirtualNode<>(serverNode, i + existingReplicas);
            ring.put(hashFunction.getHashKey(vNode.getKey()), vNode);
        }
	}
	
	private int getExistingReplicas(T serverNode) {
        int replicas = 0;
        for (VirtualNode<T> vNode : ring.values()) {
            if (vNode.isPhysicalNodeOf(serverNode)) {
                replicas++;
            }
        }
        return replicas;
	}

	public void removeNode(T server) {
        Iterator<Long> it = ring.keySet().iterator();
        while (it.hasNext()) {
            Long key = it.next();
            VirtualNode<T> virtualNode = ring.get(key);
            if (virtualNode.isPhysicalNodeOf(server)) {
                it.remove();
            }
        }
	}
	
	public T routeNode(String clientIp) {
        if (ring.isEmpty()) {
            return null;
        }
        Long hashVal = hashFunction.getHashKey(clientIp);
        SortedMap<Long,VirtualNode<T>> tailMap = ring.tailMap(hashVal);
        Long nodeHashVal = !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
        return ring.get(nodeHashVal).getPhysicalNode();
	}
	
    //default hash function
    private static class MD5Hash implements HashFunction {
        MessageDigest instance;

        public MD5Hash() {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
            }
        }

		@Override
		public long getHashKey(String clientIp) {
            instance.reset();
            instance.update(clientIp.getBytes());
            byte[] digest = instance.digest();

            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }
            return h;
		}
    }

}
