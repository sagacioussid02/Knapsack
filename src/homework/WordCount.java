package homework;

import java.util.ArrayList;
import java.util.HashMap;


public class WordCount {
	
	   /**
	    * Word Count
	    *
	    * Given an body of text, return a hash table of the frequency of each word.
	    *
	    * Parameters
	    * Input: sentence {String}
	    * Output: {Hash Map <String, Integer>}
	    *
	    * Constraints
	    *
	    * Capital and lower case versions of the same word should be counted is the same word.
	    *
	    * Remove punctuations from all words.
	    *
	    * Time: O(N)
	    * Space: O(N)
	    * Where N is the number of characters in the string.
	    *
	    * **Examples**
	    * 'The cat and the hat.' --> '{ the: 2, cat: 1, and: 1, hat: 1 }'`
	    * 'As soon as possible.' --> '{ as: 2, soon: 1, possible: 1 }'`
	    * 'It's a man, it's a plane, it's superman!' --> '{ its: 3, a: 2, man: 1, plane: 1, superman: 1 }'`
	    */

	    public static HashMap wordCount(String sentence) {
	    	if(sentence == null) return new HashMap<String,Integer>();
	    	if(sentence.length() == 0) return new HashMap<String, Integer>();
	    	String lowercaseSentence = sentence.toLowerCase();
	    	String punctuationsRemoved = lowercaseSentence.replaceAll("[^a-zA-Z 0-9]", "");
	    	String[] countString = punctuationsRemoved.split(" ");
	    	HashMap<String, Integer> res = new HashMap<String, Integer>();
	    	for(int i = 0;i<countString.length;i++) {
	    		res.put(countString[i], res.getOrDefault(countString[i], 0) + 1);
	    	}
	    	return res;
	    }
	    
	    public static void main(String[] args) {
	    	int[] testCount = {0, 0};
	        System.out.println("Word Count Tests");

	        // tests are in the form as shown
	        assertTest(testCount, "should return an object with each word and its frequency", new Test() {
	          public boolean execute() {
	            HashMap<String, Integer> output = wordCount("The cat and the hat.");

	            return output.get("the").intValue() == 2 && output.get("hat").intValue() == 1 && output.get("cat").intValue() == 1 && output.get("and").intValue() == 1;
	          }
	        });

	        assertTest(testCount, "should return object with each word excluding punctuations", new Test() {
	          public boolean execute() {
	            HashMap<String, Integer> output = wordCount("It's a man, it's a plane, it's superman!");

	            return output.get("its").intValue() == 3 && output.get("a").intValue() == 2 && output.get("man").intValue() == 1 && output.get("plane").intValue() == 1 && output.get("superman").intValue() == 1;
	          }
	        });

	        assertTest(testCount, "should return empty object for empty string input", new Test() {
	          public boolean execute() {
	            HashMap<String, Integer> output = wordCount("");
	            return output.isEmpty();
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
