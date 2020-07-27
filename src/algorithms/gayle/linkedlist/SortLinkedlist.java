package algorithms.gayle.linkedlist;

public class SortLinkedlist {
    
    
    public LinkedListNode sortList(LinkedListNode head) {
        if(head == null) return head;
        return mergeSort(head);
    }

    private LinkedListNode mergeSort(LinkedListNode head) {
        if(head == null || head.next == null) return head;
        
        LinkedListNode middleNode = getMiddle(head);
        LinkedListNode nextToMiddle = middleNode.next;
        
        middleNode.next = null;
        
        //keep dividing the two halves
        LinkedListNode leftList = mergeSort(head);
        LinkedListNode rightList = mergeSort(nextToMiddle);
        
        //merge both the list
        return sortedMerge(leftList, rightList);
    }

    private LinkedListNode sortedMerge(LinkedListNode leftList, LinkedListNode rightList) {
        if(leftList == null && rightList == null) return null;
        if(leftList == null) return rightList;
        if(rightList == null) return leftList;
        
        LinkedListNode result;
        
        if(leftList.val <= rightList.val) {
            result = leftList;
            leftList = sortedMerge(leftList.next, rightList);
        } else {
            result = rightList;
            rightList = sortedMerge(leftList,rightList.next);
        }
        return result;
    }

    private LinkedListNode getMiddle(LinkedListNode head) {
        LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head;
        
        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}
