package algorithms.companies.cisco;

public class BinaryNumberInLinkedList {
	
	public static int binaryToDecimal(LinkedListNode head) {
		int length = getLength(head);
		int decimal = 0;
		for(int i = 0; i < length; i++) {
			decimal += (head.val * Math.pow(2, length - i -1));
			head = head.next;
		}
		return decimal;
	}
	
	public static int getLength(LinkedListNode head) {
		LinkedListNode temp = head;
		int length = 0;
		while(temp != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		head.addNode(head, 1);
		System.out.println(binaryToDecimal(head));
	}

}
