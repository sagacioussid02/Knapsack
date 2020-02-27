package design.basic.consistenthash;

public class VirtualNode<N extends Node> implements Node{
	
	final N physicalNode;
	final int virtualNumber;
	

	public VirtualNode(N physicalNode, int virtualNumber) {
		this.physicalNode = physicalNode;
		this.virtualNumber = virtualNumber;
	}
	
	public boolean isPhysicalNodeOf(N pNode) {
		return physicalNode.getKey().equals(pNode.getKey());
	}
	
	public N getPhysicalNode() {
		return physicalNode;
	}


	@Override
	public String getKey() {
		return physicalNode.getKey()+"_"+virtualNumber;
	}



}
