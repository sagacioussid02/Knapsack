package algorithms.gayle.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Compose {
    
    public static LinkedListNode condense(LinkedListNode head) {
        //check if head is null or empty or have only element
        if(head == null || head.next == null) return head;
        //initialize a set to keep track of the elements previously present
        Set<Integer> trackerSet = new HashSet<Integer>();
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = head;
        LinkedListNode temp = head;
        //iterate through the list
        while(temp != null){
            //if it contains in the set
            if(trackerSet.contains(temp.val)){
                //delete that node
                next = temp.next;
                curr = temp;
                temp = temp.next;
                curr.next = null;
                prev.next = next;
            }else{
                //else add the node value to the set and continue
                trackerSet.add(temp.val);
                prev = temp;
                temp = temp.next;
            }
            
        }     
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(2);
        head.addNode(head, 3);
        head.addNode(head, 4);
        head.addNode(head, 5);
        head.addNode(head, 6);
        head.addNode(head, 3);
        head.addNode(head, 8);
        head.addNode(head, 9);
        head.addNode(head, 10); 
        
        condense(head);       
        
    }

}
