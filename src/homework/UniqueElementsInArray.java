package homework;

import java.util.ArrayList;


public class UniqueElementsInArray {
	
	  /**
	   *
	   * Unique
	   *
	   * Given an array of integers, return an array with all duplicates removed.*
	   *
	   * Parameters
	   * Input: arr {Array of Integers}
	   * Output: {ArrayList of Integers}
	   *
	   * Constraints
	   *
	   * Time: O(N)
	   * Space: O(N)
	   *
	   * Examples
	   * [1, 2, 4, 4, 5, 6] --> [1, 2, 4, 5, 6]
	   * [1, 1, 2, 2, 3, 3]' --> [1, 2, 3]
	   * [1, 2, 3, 1, 2] --> [1, 2, 3]
	   */

	   public static ArrayList unique(int[] arr) {
		   if(arr == null || arr.length == 0) return new ArrayList();
		   ArrayList<Integer> uniList = new ArrayList<Integer>();
		   for(int i = 0;i< arr.length;i++) {
			   if(!uniList.contains(arr[i])) uniList.add(arr[i]);
		   }
	      return uniList;
	   }

	public static void main(String[] args) {
	    // instantiate the testing of each module by resetting count and printing title of module
	    int[] testCount = {0, 0};
	    System.out.println("Unique Tests");

	    // tests are in the form as shown
	    assertTest(testCount, "should return unique values from sorted list with duplicates", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = unique(new int[]{1, 2, 4, 4, 5, 6});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
	          add(1);
	          add(2);
	          add(4);
	          add(5);
	          add(6);
	        }};
	        return arrayListsEqual(output, test);
	      }
	    });

	        assertTest(testCount, "should return single value for list with all duplicates", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = unique(new int[]{2, 2, 2, 2, 2, 2});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
	          add(2);
	        }};
	        return arrayListsEqual(output, test);
	      }
	    });

	        assertTest(testCount, "should return unique values from unsorted list with duplicates", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = unique(new int[]{1,2,3,1,2});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
	          add(1);
	          add(2);
	          add(3);
	        }};
	        return arrayListsEqual(output, test);
	      }
	    });

	        assertTest(testCount, "should return an empty list from empty input", new Test() {
	      public boolean execute() {
	        ArrayList<Integer> output = unique(new int[]{});
	        ArrayList<Integer> test = new ArrayList<Integer>() {{
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
