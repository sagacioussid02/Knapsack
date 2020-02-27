package homework;

import java.util.ArrayList;


public class LetterSort {
	
	   public static String letterSort(String string) {
			 int[] arr = new int[26];
			 StringBuilder str = new StringBuilder();
			 for(int i=0;i<string.length();i++) {
				 int pos = string.charAt(i) - 'a';
				 arr[pos]+= 1;
			 }
			 
			 for(int i=0;i<arr.length;i++) {
				 while(arr[i] > 0) {
					 str.append((char)(i + 97));
					 arr[i]--;
				 }
			 }
		     return str.toString();
		   }


	public static void main(String[] args) {
		int[] testCount = {0, 0};
	    System.out.println("Letter Sort Tests");

	    assertTest(testCount, "should return 'ehllo' for input 'hello'", new Test() {
	      public boolean execute() {
	        String output = letterSort("hello");
	        return output.equals("ehllo");
	      }
	    });

	    assertTest(testCount, "should return 'abdehiortw' for input of 'whiteboard'", new Test() {
	      public boolean execute() {
	        String output = letterSort("whiteboard");
	        return output.equals("abdehiortw");
	      }
	    });

	    assertTest(testCount, "should return 'eno' for input 'one'", new Test() {
	      public boolean execute() {
	        String output = letterSort("one");
	        return output.equals("eno");
	      }
	    });


	    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");
	}
	
	// do not edit below, this is to wrap the test and check for exceptions
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
	  
	  private static boolean arrayListsEqual(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		    if(arr1.size() != arr2.size()) {
		      return false;
		    }

		    for(int i = 0; i < arr1.size(); i++) {
		      if(arr1.get(i) != arr2.get(i)) {
		        return false;
		      }
		    }
		    return true;
		  }


		  // function for checking if arrays are equal
		  private static boolean arraysEqual(int[] arr1, int[] arr2) {
		    if (arr1.length != arr2.length) {
		      return false;
		    }

		    for (int i = 0 ; i < arr1.length ; i++) {
		      if (arr1[i] != arr2[i]) {
		        return false;
		      }
		    }

		    return true;
		  }
	  
	  public interface Test {
		    public boolean execute();
	  }

}
