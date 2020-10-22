package algorithms.gayle.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkedList {

	//Naive Approach
	private static LinkedListNode getIntersectionNode(LinkedListNode l1, LinkedListNode l2) {
		Set<LinkedListNode> nodeSet = new HashSet<LinkedListNode>();
		//find the length of both linked list
		LinkedListNode temp = l1;
		int len1 = 0;
		while(temp != null) {
			len1++;
			temp = temp.next;
		}
		temp = l2;
		int len2 = 0;
		while(temp != null) {
			len2++;
			temp = temp.next;
		}
		
		LinkedListNode largerNode = len1 > len2 ? l1 : l2;
		LinkedListNode smallerNode = len1 > len2 ? l2 : l1;
		while(largerNode != null) {
			nodeSet.add(largerNode);
			largerNode = largerNode.next;
		}
		
		while(smallerNode != null) {
			if(nodeSet.contains(smallerNode)) {
				return smallerNode;
			}
			smallerNode = smallerNode.next;
		}
		return null;
	}
	
	//two pointer approach
	private static LinkedListNode getIntersectionNodeTwoPointerApproach(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode temp1 = l1;
		LinkedListNode temp2 = l2;
		
		while(true) {
			temp1 = temp1.next;
			temp2 = temp2.next;
			if(temp1 == null) {
				temp1 = l2;
			} 
			if(temp2 == null) {
				temp2 = l1;
			}
			if(temp1 == temp2) {
				return temp1;
			}
		}
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
		
		LinkedListNode temp1 = new LinkedListNode(23);
		head.addNode(temp1, 32);
		head.addNode(temp1, 42);
		head.addNode(temp1, 52);
		head.addNode(temp1, 62);
		temp1 = head;
		
		LinkedListNode temp2 = new LinkedListNode(333);
		head.addNode(temp2, 322);
		head.addNode(temp2, 422);
		head.addNode(temp2, 522);
		head.addNode(temp2, 622);
		temp2 = head;
		
		System.out.println(getIntersectionNode(temp1, temp2).val);
		System.out.println(getIntersectionNodeTwoPointerApproach(temp1, temp2).val);
	}

}
