package algorithms.gayle.linkedlist;

public class ReverseInKGroups {
	
	public static LinkedListNode reverseInKGroups(LinkedListNode head, int k) {
		if(head == null) return head;
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		int count = 0;
		
		while(count < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		while(next != null) {
			head.next = reverseInKGroups(next, k);
		}
		return prev;
	}

}
