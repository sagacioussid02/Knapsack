package orcl;

import algorithms.gayle.linkedlist.LinkedListNode;

public class CloneLinkedList {
    public CloneListNode copyRandomList(CloneListNode head) {
        
        if(head == null)
            return null;
        //create another list and interwine it
        CloneListNode temp = head;
        CloneListNode newNode = new CloneListNode(temp.val);
        
        //first pass interwining
        while(temp != null){
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        
        temp = head;
        
        //populate random pointer
        while(temp != null){
            temp.next.random = temp.random != null ? temp.random.next : null; 
            temp = temp.next.next;
        }
        
        //get back the older list
        CloneListNode oldTemp = head;
        CloneListNode newTemp = head.next;
        CloneListNode oldHead = head.next;
        while(oldTemp != null){
            oldTemp.next = oldTemp.next.next;
            newTemp = newTemp.next != null ? newTemp.next.next : null;
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        
        return oldHead;    
    }

	public static void main(String[] args) {

	}

}

class CloneListNode{
	int val;
	CloneListNode next;
	CloneListNode random;
	
	public CloneListNode(int val) {
		this.val = val;
	}
	
	
}
