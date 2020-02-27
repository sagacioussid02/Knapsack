package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class MissingNumber {
	
	   /**
	    * Missing Number
	    *
	    * Given range of 1 to N and an array of unique integers that are within that
	    * range, return the missing integers not found in the array
	    *
	    * Parameters
	    * Input: n {Integer}
	    * Input: arr {Array of Integers}
	    * Output: {ArrayList of Integers}
	    *
	    * Constraints
	    * Time: O(N)
	    * Space: O(N)
	    *
	    * Examples
	    * `4, [1, 4, 2] --> [3]`
	    * `8, [4, 7, 1, 6] --> [2, 3, 5, 8]`
	    * `6, [6, 4, 2, 1] --> [3, 5]`
	    */

	    public static ArrayList missingNumber(int n, int[] arr) {
	      ArrayList<Integer> list = new ArrayList<Integer>();
	      Set<Integer> set = new HashSet<Integer>();
	      for(int i=0;i<=arr.length - 1;i++) {
	    	  set.add(arr[i]);
	      }
	      for(int i=1;i<=n;i++) {
	    	  if(!set.contains(i)) list.add(i); 
	      }
	      return list;
	    }

	public static void main(String[] args) {
		int[] testCount = {0, 0};
	    System.out.println("Missing Number Tests");

	    // tests are in the form as shown
	    assertTest(testCount, "should return [3] for input of [1, 4, 2]", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = missingNumber(4, new int[]{1, 4, 2});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
	          add(3);
	        }};
	        return arrayListsEqual(output, test);
	      }
	    });


	    assertTest(testCount, "should return [2, 3, 5, 8] for input of [4, 7, 1, 6]", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = missingNumber(8, new int[]{4, 7, 1, 6});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
	          add(2);
	          add(3);
	          add(5);
	          add(8);
	        }};
	        return arrayListsEqual(output, test);
	      }
	    });

	    assertTest(testCount, "should return [3, 5] for input of [6, 4, 2, 1]", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = missingNumber(6, new int[]{6, 4, 2, 1});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
	          add(3);
	          add(5);
	        }};
	        return arrayListsEqual(output, test);
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
