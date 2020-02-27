package algorithms.gayle.linkedlist;

public class LinkedListNode {
	
	int val;
	LinkedListNode next;
	
	public LinkedListNode(int val) {
		this.val = val;
		next = null;
	}
	
	public void addNode(LinkedListNode head, int val) {
		if(head == null) next = new LinkedListNode(val);
		LinkedListNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new LinkedListNode(val);
	}

}
