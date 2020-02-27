package homework;

import java.util.ArrayList;


public class RGB {
	
	  /**
	   * RGB Set
	   *
	   * Given a string of characters where each character is either 'r', 'g', or 'b',
	   * determine the number of complete sets of 'rgb' that can be made with the
	   * characters.
	   *
	   * Parameters
	   * Input: str {String}
	   * Output: {Integer}
	   *
	   * Constraints
	   * Time: O(N)
	   * Space: O(1)
	   *
	   * Examples
	   * `'rgbrgb' --> 2`
	   * rbg - 1
	   * `'rbgrbrgrgbgrrggbbbbrgrgrgrg' --> 7`
	   * `'bbrr' --> 0`
	   */

	     public static int rgb(String string) {
	       if(string == null) return 0;
	       if(string.length() == 0) return 0;
	       int countR = 0;
	       int countG = 0;
	       int countB = 0;
	       for(int i =0;i<string.length();i++) {
	    	   if(string.charAt(i) == 'r') countR++;
	    	   else if(string.charAt(i) == 'g') countG++;
	    	   else if(string.charAt(i) == 'b') countB++;
	       }
	       return Math.min(countR, Math.min(countG, countB));
	     }

	public static void main(String[] args) {
		int[] testCount = {0, 0};
	    System.out.println("rgb Count Tests");

	    // tests are in the form as shown
	    assertTest(testCount, "should return number correct number of rgb from input", new Test() {
	      public boolean execute() {
	        int output = rgb("rgbrgb");
	        return output == 2;
	      }
	    });

	    assertTest(testCount, "should return correct number of rgb from input despite characters out of sequence", new Test() {
	      public boolean execute() {
	        int output = rgb("rbgrbrgrgbgrrggbbbbrgrgrgrg");
	        return output == 7;
	      }
	    });

	    assertTest(testCount, "should return 0 as output for no number of rgb", new Test() {
	      public boolean execute() {
	        int output = rgb("bbrr");
	        return output == 0;
	      }
	    });

	    assertTest(testCount, "should return 0 for empty input", new Test() {
	      public boolean execute() {
	        int output = rgb("");
	        return output == 0;
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
