package orcl;

import algorithms.gayle.linkedlist.LinkedListNode;

public class RemoveDuplicatesFromSortedList {

    public static LinkedListNode deleteDuplicates(LinkedListNode head) {
    	LinkedListNode current = head;    	
    	while(current != null && current.next != null) {
    		if(current.next.val == current.val) {
    			current.next = current.next.next;
    		} else {
    			current = current.next;
    		}
    		
    	}
        return head;
    }
    
    public static void main(String[] args) {
    	LinkedListNode head = new LinkedListNode(1);
    	head.addNode(head, 1);
    	head.addNode(head, 2);
    	deleteDuplicates(head);
    }
}
