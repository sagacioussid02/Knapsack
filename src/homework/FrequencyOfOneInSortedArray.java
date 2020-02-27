package homework;


public class FrequencyOfOneInSortedArray {

	
	/*
	 *
	 *  Number of Ones
	 *
	 * *Given a sorted bit array (values of either 0 or 1), determine the number of 1's in the array.*
	 *
	 * **Parameters**
	 * Input: arr {Array of Integers}
	 * Output: {Integer}
	 *
	 * **Constraints**
	 * Time: O(logN)
	 * Space: O(1)
	 *
	 * **Examples**
	 * `[0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1] --> 8`
	 * `[0, 0, 0] --> 0`
	 * `[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1] --> 7`
	 */

	  public static int numberOfOnes(int[] arr) {
		  //binary search
		  //find the first occurrence of 1
		  int left = 0;
		  int right = arr.length - 1;
		  while(left < right) {
			  if(arr[right] == 0) return 0;
			  int mid = (left + right) / 2;
			  if(arr[mid] == 0) left = mid + 1;
			  else right = mid;
		  }
		  return arr.length - right;
	  }
	  
	  
	public static void main(String[] args) {
		// instantiate the testing of each module by resetting count and printing title of module
	    int[] testCount = {0, 0};
	    System.out.println("Number Of Ones Tests");

	    // tests are in the form as shown
	    assertTest(testCount, "should return correct number of ones for array with zeroes and ones", new Test() {
	      public boolean execute() {
	        int output = FrequencyOfOneInSortedArray.numberOfOnes(new int[]{0, 0, 0, 1, 1, 1});
	        return output == 3;
	      }
	    });

	    assertTest(testCount, "should return correct number of ones for array with all zeroes", new Test() {
	      public boolean execute() {
	        int output = FrequencyOfOneInSortedArray.numberOfOnes(new int[]{0, 0, 0, 0, 0, 0});
	        return output == 0;
	      }
	    });

	    assertTest(testCount, "should return correct number of ones for array with all ones", new Test() {
	      public boolean execute() {
	        int output = FrequencyOfOneInSortedArray.numberOfOnes(new int[]{1, 1, 1, 1, 1});
	        return output == 5;
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
	  
	  // an interface to perform tests
	  public interface Test {
	    public boolean execute();
	  }

}
