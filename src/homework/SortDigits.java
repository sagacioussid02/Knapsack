package homework;

import java.util.ArrayList;


public class SortDigits {
	
	  /**
	   * Sort Digits
	   *
	   * Given an integer, sort the digits in ascending order and return the new integer.
	   * Ignore leading zeros.
	   *
	   * Parameters
	   * Input: num {Integer}
	   * Output: {Integer}
	   *
	   * Constraints
	   * Do not convert the integer into a string or other data type.
	   *
	   * Time: O(N) where N is the number of digits.
	   * Space: O(1)
	   *
	   * Examples
	   * 8970 --> 789 (8907 8097 0897 | 0879 0789)
	   * 32445 --> 23445 (32445 32445 32445 23445)
	   * 10101 --> 111 
	   */

	   public static int sortDigits(int n) {
		   if(n == 0) return 0;
		   int length = (int)Math.log10(n) + 1;
		   
		   for(int i=0;i<length - 1;i++) {
			  int temp = n;
			  int pos = 1;
			  while(temp > 9) {
				  //get the two consecutive digits from the last
				  int last = temp % 10;
				  int secondLast = (temp % 100) / 10;
				  if(last < secondLast) {
					  //swap
					  n = n - (secondLast * pos * 10) - (last * pos) + (last * pos * 10) + (secondLast * pos);
				  }
				  temp = n;
				  pos = pos * 10;
				  temp = temp / pos;
			  }
		   }
		   return n;
	   }

	public static void main(String[] args) {
		int[] testCount = {0, 0};
	    System.out.println("Sort Digits Tests");

	    assertTest(testCount, "should return '789' when input is '8970'", new Test() {
	      public boolean execute() {
	        int output = sortDigits(8970);
	        return output == 789;
	      }
	    });

	    assertTest(testCount, "should return '23445' when input is '32445'", new Test() {
	      public boolean execute() {
	        int output = sortDigits(32445);
	        return output == 23445;
	      }
	    });

	    assertTest(testCount, "should return '111' when input is '10101'", new Test() {
	      public boolean execute() {
	        int output = sortDigits(10101);
	        return output == 111;
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
