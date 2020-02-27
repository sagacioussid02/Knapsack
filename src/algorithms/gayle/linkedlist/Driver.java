package algorithms.gayle.linkedlist;

public class Driver {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(2);
		head.addNode(head, 3);
		head.addNode(head, 4);
		head.addNode(head, 5);
		head.addNode(head, 6);
		head.addNode(head, 7);
		head.addNode(head, 8);
		head.addNode(head, 9);
		head.addNode(head, 10);		
		LinkedListNode temp = head;
		
		while(temp != null) { System.out.println(temp.val); temp = temp.next; }
		 
		
		LinkedListNode temp2 = head;
		LinkedListNode node = ReverseLinkedList.reverseList(temp2);
		LinkedListNode print = node;
		while(print != null) {
			System.out.println(print.val);
			print = print.next;
		}
		
		LinkedListNode temp3 = node;
		LinkedListNode node1 = ReverseInKGroups.reverseInKGroups(node, 3);
		while(node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}

}
