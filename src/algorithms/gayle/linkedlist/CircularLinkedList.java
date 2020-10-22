package algorithms.gayle.linkedlist;

public class CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedListOP head = new CircularLinkedListOP();
        head.addNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        
        head.printList();
        
        //deletion operations
        head.deleteNode(1);
        head.printList();
        
        head.deleteNode(5);
        head.printList();
        
        head.deleteNode(3);
        head.printList();
    }
}

class CircularLinkedListOP{
    CircularListNode headNode;
    CircularListNode lastPointer;
    
    public CircularLinkedListOP() {
        this.lastPointer = null;
    }
    public void addNode(int data) {
        //if the list is empty
        if(lastPointer == null) {
            CircularListNode newNode = new CircularListNode(data);
            headNode = newNode;
            lastPointer = newNode;
            newNode.next = headNode;
            return;
        }
        
        //if lastPointer is pointing to some node other than null
        CircularListNode tempHead = lastPointer;
        CircularListNode newNode = new CircularListNode(data);
        lastPointer = newNode;
        tempHead.next = newNode;
        lastPointer.next = headNode;  
    }
    
    public void deleteNode(int val) {
        //delete head node
        CircularListNode nodeToDelete = new CircularListNode(val);
        if(nodeToDelete.data==headNode.data) {
            deleteHeadNode();
        } else if(nodeToDelete.data==lastPointer.data) {
          //delete last node
            deleteLastNode();
        } else {
            //delete other node
            deleteMiddleNode(nodeToDelete);
        }
    }
    
    private void deleteMiddleNode(CircularListNode nodeToDelete) {
        CircularListNode tempNode = headNode;
        CircularListNode prev = null;
        //go till the specific node
        while(tempNode.data!=nodeToDelete.data) {
            prev = tempNode;
            tempNode = tempNode.next;
        }
        prev.next = tempNode.next;
        tempNode.next = null;
        
    }
    
    private void deleteLastNode() {
        CircularListNode tempNode = headNode;
        CircularListNode prev = null;
        //go till the last node
        while(!tempNode.equals(lastPointer)) {
            prev = tempNode;
            tempNode = tempNode.next;
        }
        prev.next = headNode;
        lastPointer = prev;
    }
    
    
    private void deleteHeadNode() {
        if(headNode.equals(lastPointer)) {
            headNode=null;
            lastPointer=null;
            return;
        }
        CircularListNode tempNode = headNode.next;
        lastPointer.next = tempNode;
        headNode = tempNode;
    }
    
    public void printList() {
        CircularListNode firstNode = headNode;
        while(!firstNode.equals(lastPointer)) {
            System.out.println(firstNode.data);
            firstNode = firstNode.next;
        }
        System.out.println(firstNode.data);
        System.out.println("\n\n");
    }
    
}

class CircularListNode{
    int data;
    CircularListNode next;
    
    public CircularListNode(int data) {
        this.data = data;
        next = null;
    }
}


