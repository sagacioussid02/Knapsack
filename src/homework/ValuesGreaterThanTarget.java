package homework;

import homework.SquareRoot.Test;

public class ValuesGreaterThanTarget {

	
	/*
	 * Greater Values
	 *
	 * *Given an sorted array of integers, and a target value return the number of values greater the target.*
	 *
	 * **Parameters**
	 * Input: arr {Array of Integers}
	 * Input: target {Integer}
	 * Output: {Integer}
	 *
	 * **Constraints**
	 *
	 * Time: O(logN)
	 * Space: O(1)
	 *
	 * **Examples**
	 * `[1, 2, 3, 5, 5, 7, 9, 10, 11], 5 --> 4`
	 * `[1, 2, 3], 4 --> 0`
	 * `[1, 10, 22, 59, 67, 72, 100], 13 --> 5`
	 *
	*/

	public static int greaterValues(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		if(arr[left] > target) return arr.length;
		if(arr[right] < target) return 0;
		while(left < right - 1) {
			int mid = (left + right) / 2;
			if(arr[mid] > target) right = mid;
			else left = mid;
		}
		return arr.length - right;
	}
	
	
	public static void main(String[] args) {
		int[] testCount = { 0, 0 };
		System.out.println("Greater Values Tests");

	    assertTest(testCount, "should return greater values for number in the middle of the array", new Test() {
	      public boolean execute() {
	        int output = ValuesGreaterThanTarget.greaterValues(new int[] {1, 2, 3, 5, 5, 7, 9, 10, 11}, 5);
	        return output == 4;
	      }
	    });

	    assertTest(testCount, "should return 0 for number greater than largest in the array", new Test() {
	      public boolean execute() {
	        int output = ValuesGreaterThanTarget.greaterValues(new int[] {1, 2, 3}, 4);
	        return output == 0;
	      }
	    });

	    assertTest(testCount, "should return length of array for number less than least in the array", new Test() {
	      public boolean execute() {
	        int output = ValuesGreaterThanTarget.greaterValues(new int[] {1, 10, 22, 59, 67, 72, 100}, -2);
	        return output == 7;
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
		} catch (Exception e) {
		}
		String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
		System.out.println(result);
	}

	// an interface to perform tests
	public interface Test {
		public boolean execute();
	}

}
