package homework;

public class LinkedList {
	
	public int length = 0;
	  public ListNode head;
	  public ListNode tail;
	  
	  public LinkedList() {
		  head = null;
		  tail = null;
	  }

	  // Time Complexity: O(1)
	  // Auxiliary Space Complexity: O(1)
	  public void append(int value){
		  if(head == null) {
			  head = new ListNode(value);
			  tail = head;
			  length++;
			  return;
		  }
		  tail.next = new ListNode(value);	  
		  tail = tail.next;
		  length++;
	  }


	  // Time Complexity: O(N)
	  // Auxiliary Space Complexity: O(1)
	  public void insert(int value, int index){
		  if(index > length || index < 0) return;
		  if(index == length) {
			  append(value);
			  return;
		  }
		  
		  ListNode newNode = new ListNode(value);
		  ListNode temp = head;
		  int count = 0;
		  if(index == 0 && head == null) {
			  head = newNode;
			  tail = head;
		  } else if(index == 0 && head != null) {
			  newNode.next = head;
			  head = newNode;
		  } else {
			  while(temp != null && (count != index - 1)) {
				  count++;
				  temp = temp.next;
			  }
			  newNode.next = temp.next;
			  temp.next = newNode;
		  }
		  length++;
	  }


	  // Time Complexity: O(N)
	  // Auxiliary Space Complexity: O(1)
	  public void delete(int index){
		  if(index >= length || index < 0) return;
		  if(head == null) return;
		  if(index == 0 && length > 1) {
			  head = head.next;
			  length--;
			  return;
		  } else if(index == 0 && length == 1) {
			  head = tail = null;
			  length--;
			  return;
		  }
		  
		  ListNode temp = head.next;
		  ListNode prev = head;
		  int count = 0;
		  while(temp != null && count != index - 1) {
			  count++;
			  temp = temp.next;
			  prev = prev.next;
		  }
		  //delete logic
		  prev.next = temp.next;
		  temp.next = null;	
		  length--;
	  }


	  // Time Complexity: O(N)
	  // Auxiliary Space Complexity: O(1)
	  public boolean contains(int value){
		ListNode temp = head;
		while(temp != null) {
			if(temp.value == value) return true;
			temp = temp.next;
		}
	    return false;
	  }
	  
	  private int[] testCount;

	  // an interface to perform tests
	  public interface Test {
	      public boolean execute();
	  }

	public static void main(String[] args) {
		int[] testCount = {0, 0};
	    System.out.println("ListNode Class");

	    assertTest(testCount, "able to create an instance", new Test() {
	      public boolean execute() {
	        ListNode node = new ListNode(0);
	        return node instanceof ListNode;
	      }
	    });

	    assertTest(testCount, "has value field", new Test() {
	      public boolean execute() {
	        ListNode node = new ListNode(0);
	        try {
	          node.getClass().getField("value");
	          return true;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to assign a value upon instantiation", new Test() {
	      public boolean execute() {
	        ListNode node = new ListNode(5);
	        return node.value == 5;
	      }
	    });

	    assertTest(testCount, "able to reassign a value", new Test() {
	      public boolean execute() {
	        ListNode node = new ListNode(5);
	        node.value = 1;
	        return node.value == 1;
	      }
	    });

	    assertTest(testCount, "able to point to another node", new Test() {
	      public boolean execute() {
	        ListNode node1 = new ListNode(5);
	        ListNode node2 = new ListNode(10);
	        node1.next = node2;
	        return node1.next.value == 10;
	      }
	    });

	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


	    testCount[0] = 0;
	    testCount[1] = 0;
	    System.out.println("LinkedList Class");

	    assertTest(testCount, "able to create an instance", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        return linkedList instanceof LinkedList;
	      }
	    });

	    assertTest(testCount, "has head field", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.getClass().getField("head");
	          return true;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "has tail field", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.getClass().getField("tail");
	          return true;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "has length field", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.getClass().getField("length");
	          return true;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "default head set to null", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        return linkedList.head == null;
	      }
	    });

	    assertTest(testCount, "default tail set to null", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        return linkedList.tail == null;
	      }
	    });

	    assertTest(testCount, "default length set to 0", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        return linkedList.length == 0;
	      }
	    });

	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


	    testCount[0] = 0;
	    testCount[1] = 0;
	    System.out.println("LinkedList Insert Method");

	    assertTest(testCount, "has insert method", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();

	        try {
	          linkedList.getClass().getMethod("insert", new Class[] { int.class, int.class });
	          return true;
	        } catch (Exception e) {
	          e.printStackTrace();
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to insert a node into empty linked list", new Test() {
	        public boolean execute() {
	          LinkedList linkedList = new LinkedList();
	          try {
	            linkedList.insert(5,0);
	            return linkedList.length == 1 && linkedList.head.value == 5 && linkedList.tail.value == 5;
	          } catch (Exception e) {
	            return false;
	          }
	        }
	    });

	    assertTest(testCount, "able to insert a node after another node", new Test() {
	        public boolean execute() {
	          LinkedList linkedList = new LinkedList();
	          try {
	            linkedList.insert(5,0);
	            linkedList.insert(10, 1);
	            return linkedList.length == 2 && linkedList.head.value == 5 && linkedList.tail.value == 10;
	          } catch (Exception e) {
	            return false;
	          }
	        }
	    });

	    assertTest(testCount, "able to insert a node before another node", new Test() {
	        public boolean execute() {
	          LinkedList linkedList = new LinkedList();
	          try {
	            linkedList.insert(5,0);
	            linkedList.insert(10,0);
	            return linkedList.length == 2 && linkedList.head.value == 10 && linkedList.tail.value == 5;
	          } catch (Exception e) {
	            return false;
	          }
	        }
	    });

	    assertTest(testCount, "does not insert a node if index is out of bounds linked list", new Test() {
	        public boolean execute() {
	          LinkedList linkedList = new LinkedList();
	          try {
	            linkedList.insert(5,-1);
	            linkedList.insert(10,3);
	            return linkedList.length == 0 && linkedList.head == null && linkedList.tail == null;
	          } catch (Exception e) {
	            return false;
	          }
	        }
	    });

	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


	    testCount[0] = 0;
	    testCount[1] = 0;
	    System.out.println("LinkedList Append Method");

	    assertTest(testCount, "has append method", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();

	        try {
	          linkedList.getClass().getMethod("append", new Class[] { int.class });
	          return true;
	        } catch (Exception e) {
	          e.printStackTrace();
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to append a node into empty linked list", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          return linkedList.length == 1 && linkedList.head.value == 5 && linkedList.tail.value == 5;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to append a second node into a linked list", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.append(10);
	          return linkedList.length == 2 && linkedList.head.value == 5 && linkedList.tail.value == 10;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to append a third node into a linked list", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.append(10);
	          linkedList.append(15);
	          return linkedList.length == 3 && linkedList.head.value == 5 && linkedList.tail.value == 15;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


	    testCount[0] = 0;
	    testCount[1] = 0;
	    System.out.println("LinkedList Delete Method");

	    assertTest(testCount, "has append method", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();

	        try {
	          linkedList.getClass().getMethod("delete", new Class[] { int.class });
	          return true;
	        } catch (Exception e) {
	          e.printStackTrace();
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to delete a node from the head", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.append(10);
	          linkedList.delete(0);
	          return linkedList.length == 1 && linkedList.head.value == 10 && linkedList.tail.value == 10;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to delete a node in between two nodes", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.append(10);
	          linkedList.append(15);
	          linkedList.delete(1);
	          return linkedList.length == 2 && linkedList.head.value == 5 && linkedList.tail.value == 15;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "able to delete the only node in a linked list", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.delete(0);
	          return linkedList.length == 0 && linkedList.head == null && linkedList.tail == null;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "does not delete a node when the index is out of bounds", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.delete(-1);
	          linkedList.delete(2);
	          return linkedList.length == 1 && linkedList.head.value == 5 && linkedList.tail.value == 5;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


	    testCount[0] = 0;
	    testCount[1] = 0;
	    System.out.println("LinkedList Contains Method");

	    assertTest(testCount, "has contains method", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();

	        try {
	          linkedList.getClass().getMethod("contains", new Class[] { int.class });
	          return true;
	        } catch (Exception e) {
	          e.printStackTrace();
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "returns true if linked list contains value", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.append(10);
	          linkedList.append(15);
	          return linkedList.contains(15);
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    assertTest(testCount, "returns false if linked list does not contains value", new Test() {
	      public boolean execute() {
	        LinkedList linkedList = new LinkedList();
	        try {
	          linkedList.append(5);
	          linkedList.append(10);
	          linkedList.append(15);
	          return linkedList.contains(8) == false;
	        } catch (Exception e) {
	          return false;
	        }
	      }
	    });

	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");
	}
	
	  private static void assertTest(int[] count, String name, Test test) {
		    String pass = "false";
		    count[1]++;

		    try {
		      if (test.execute()) {
		          pass = " true";
		          count[0]++;
		      }
		    } catch(Exception e) {}
		    String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
		    System.out.println(result);
		  }

}

class ListNode {
	  public int value;
	  public ListNode next;

	  public ListNode(int value){
		  this.value = value;
		  next = null;
	  }
}
