package homework;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class RecursionPrintArray {
	
	/**
	 * 1a. What is the term when the recursive call invokes itself more than once.
	 * -> Recursion
	 *
	 */


	/**
	 * 1b. List the steps involved to build a Helper Method Recursion algorithm.
	 * -> Get the initial base case inputs
	 * -> Create a wrapper method with the inputs required in addition to state arguments
	 * -> Add a base cases
	 * -> Add recursive steps
	 * -> return
	 */


	/**
	 * 1c. Should the recursive case or base case typically be tackled first?
	 * -> We need to find out first on what we are trying to do the recursion
	 * -> and think about the base case.
	 *
	 */


	/**
	 *  2a. Print each integer in an array in order using Helper Method Recursion
	 *
	 *  Input:   arr {Array}
	 *  Output:  {void}
	 *
	 *  Example: int[] nums = {1, 2, 3};
	 *
	 *          PrintArray.compute(nums) =>
	 *          1
	 *          2
	 *          3
	 */
	  public static void compute(int[] arr) {
		  if(arr == null) return;
		  computeHelper(arr, 0);
	  }

	  public static void computeHelper(int[] arr, int index) {
		  //base case
		  if(index == arr.length || (index == 0 && arr.length == 0)) {
			  return;
		  }
		  System.out.println(arr[index]);
		  //recursive case
		  computeHelper(arr, index + 1);
	  }

	// an interface to perform tests
	  public interface Test {
	    public boolean execute();
	  }

	  public static void main(String[] args) {

	    // instantiate the testing of each module by resetting count and printing title of module
	    int[] testCount = {0, 0};
	    System.out.println("PrintArray tests");

	    // tests are in the form as shown
	    assertTest(testCount, "able to print the elements of [1,2,3] forwards", new Test() {
	      public boolean execute() {


	        // Create a stream to hold the output
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(baos);
	        // IMPORTANT: Save the old System.out!
	        PrintStream old = System.out;
	        // Tell Java to use your special stream
	        System.setOut(ps);

	        // Print some output: goes to your special stream
	        int[] input = {1,2,3};
	        compute(input);

	        // Put things back
	        System.out.flush();
	        System.setOut(old);
	        // Show what happened
	        //System.out.println("Here: " + baos.toString());

	        return baos.toString().equals("1\r\n2\r\n3\r\n");
	      }
	    });

	    assertTest(testCount, "does not print for an empty array", new Test() {
	      public boolean execute() {


	        // Create a stream to hold the output
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(baos);
	        // IMPORTANT: Save the old System.out!
	        PrintStream old = System.out;
	        // Tell Java to use your special stream
	        System.setOut(ps);

	        // Print some output: goes to your special stream
	        int[] input = {};
	        compute(input);

	        // Put things back
	        System.out.flush();
	        System.setOut(old);
	        // Show what happened
	        //System.out.println("Here: " + baos.toString());

	        return baos.toString().equals("");
	      }
	    });

	    assertTest(testCount, "able to print a single element array [5]", new Test() {
	      public boolean execute() {


	        // Create a stream to hold the output
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(baos);
	        // IMPORTANT: Save the old System.out!
	        PrintStream old = System.out;
	        // Tell Java to use your special stream
	        System.setOut(ps);

	        // Print some output: goes to your special stream
	        int[] input = {5};
	        compute(input);

	        // Put things back
	        System.out.flush();
	        System.setOut(old);
	        // Show what happened
	        //System.out.println("Here: " + baos.toString());

	        return baos.toString().equals("5\r\n");
	      }
	    });


	    // print the result of tests passed for a module
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

}
