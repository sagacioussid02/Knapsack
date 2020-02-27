package algorithms.gayle.linkedlist;

public class ReverseLinkedList {
	
	public static LinkedListNode reverseList(LinkedListNode head) {
		if(head == null) return head;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode curr = head;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
		
	}

}
