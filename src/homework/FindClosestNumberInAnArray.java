package homework;

import homework.FrequencyOfOneInSortedArray.Test;

public class FindClosestNumberInAnArray {

	/*
	 * Closest Value
	 *
	 * Given a sorted bit array of integers, and a target value, find the number in the array that is closest to the target.*
	 *
	 * **Parameters**
	 * Input: arr {Array of Integers}
	 * Input: target {Integer}
	 * Output: {Integer}
	 *
	 * **Constraints**
	 * If there are two numbers tied for the closest value, return the lowest value.
	 *
	 * Time: O(logN)
	 * Space: O(1)
	 *
	 * **Examples**
	 * `[1, 2, 3, 5, 5, 7, 9, 10, 11], 6 --> 5`
	 * `[1, 2, 3], 8 --> 3`
	 * `[1, 10, 22, 59,67,71,72, 100], 70 --> 72`
	 */

	public static int closestValue(int[] arr, int target) {
		int left = 0;
		if(arr[left] >= target) return arr[left];
		int right = arr.length - 1;
		if(arr[right] <= target) return arr[right];
		
		while(left < right - 1) {
			int mid = (left + right) / 2;
			if(arr[mid] == target) return target;
			if(arr[mid] < target) left = mid;
			else right = mid;
		}
		return arr[right] - target >= target - arr[left]?arr[left]:arr[right];
	}
	
	
	public static void main(String[] args) {
		int[] testCount = {0, 0};
		System.out.println("Closest Value Tests");

	    assertTest(testCount, "should return correct closest value for number in the middle range", new Test() {
	      public boolean execute() {
	        int output = FindClosestNumberInAnArray.closestValue(new int[]{1, 2, 3, 5, 5, 7, 9, 10, 11}, 6);
	        return output == 5;
	      }
	    });

	    assertTest(testCount, "should return closest value for highest number", new Test() {
	      public boolean execute() {
	        int output = FindClosestNumberInAnArray.closestValue(new int[]{1, 2, 3}, 8);
	        return output == 3;
	      }
	    });

	    assertTest(testCount, "should return closest value for lowest number", new Test() {
	      public boolean execute() {
	        int output = FindClosestNumberInAnArray.closestValue(new int[]{-2, -1, 0}, -5);
	        return output == -2;
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
