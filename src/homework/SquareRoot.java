package homework;

public class SquareRoot {

	/*
	 * Square Root
	 *
	 * Given an positive integer, find the square root.*
	 *
	 * **Parameters** Input: value {Double} Output: {Double}
	 *
	 * **Constraints** Do not use a native built in method. Ensure the result is
	 * accurate to 6 decimal places (0.000001)
	 *
	 * Time: O(logN) Space: O(1)
	 *
	 * **Examples** `4 --> 2.0` `98 --> 9.899495` `14856 --> 121.885192
	 */

	public static Double squareRoot(Double n) {
		  //sqrt(n) = 2^(0.5 * log2(n))
		  if(n <= 0) return 0.0; 
		  Double sum = 0.000000; 
		  for(Double i = 1.0; i <= n ; i*=2) {
			  sum += n/i; 
		  } 
		 return Math.pow(2, (sum * 0.500000));
	}

	public static void main(String[] args) {
		int[] testCount = { 0, 0 };
		System.out.println("Square Root Tests");

		assertTest(testCount, "should return correct square root for number < 10", new Test() {
			public boolean execute() {
				Double output = SquareRoot.squareRoot(4.0);
				return output == 2.0;
			}
		});

		assertTest(testCount, "should return correct square root for number = 5", new Test() {
			public boolean execute() {
				Double output = SquareRoot.squareRoot(5.0);
				return output == 2.236067;
			}
		});

		assertTest(testCount, "should return correct square root for number = 5", new Test() {
			public boolean execute() {
				Double output = SquareRoot.squareRoot(16.0);
				return output == 4.0;
			}
		});

		assertTest(testCount, "should return correct square root for number between 10 and 100", new Test() {
			public boolean execute() {
				Double output = SquareRoot.squareRoot(98.0);
				return output == 9.899495;
			}
		});

		assertTest(testCount, "should return correct square root for number over 10,000", new Test() {
			public boolean execute() {
				Double output = SquareRoot.squareRoot(14856.0);
				return output == 121.885192;
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
