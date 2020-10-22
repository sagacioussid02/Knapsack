package algorithms.gayle.linkedlist;

public class CircleInLinkedList {
	
	public static boolean isCircular(LinkedListNode node) {

        if(node == null) return false;
        LinkedListNode slowPtr = node;
        LinkedListNode fastPtr = node.next;

        while(fastPtr.next != null && slowPtr != null){
            if(fastPtr.equals(slowPtr)) return true;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return false;
    }


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
		isCircular(head);
	}

}
