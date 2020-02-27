package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CharacterMode {
	
	   /**
	    * Character Mode
	    *
	    * Given a string, find the most frequent occurring letter(s) in the string
	    *
	    * Parameters
	    * Input: string {String}
	    * Output: {String}
	    *
	    * Constraints
	    * If more than one letter is tied for the most frequent, return a string of all
	    * the letters in one string.
	    *
	    * Time: O(N)
	    * Space: O(N)
	    *
	    * Examples
	    * 'hello' --> 'l'
	    * 'A walk in the park' --> 'a'
	    * 'noon' --> 'no'
	    */

	    public static String characterMode(String string) {
	      if(string == null) return "";
	      Map<Character, Integer> charCount = new HashMap<Character, Integer>();
	      string = string.replaceAll(" ", "");
	      for(char c:string.toLowerCase().toCharArray()) 
	    	  charCount.put(c, charCount.getOrDefault(c, 0) + 1);
	      
	      PriorityQueue<Map.Entry<Character, Integer>> qu = new PriorityQueue<Map.Entry<Character,Integer>>((e1,e2) -> {
	    	  return e2.getValue() - e1.getValue(); 
	      });
	      
	      for(Map.Entry<Character, Integer> entry:charCount.entrySet()) {
	    	  qu.offer(entry);
	      }
	    	  
	      
	      Map.Entry<Character, Integer> firstEntry  = qu.remove();
	      char firstChar = firstEntry.getKey();
	      int max = firstEntry.getValue();
	      StringBuilder str = new StringBuilder();
	      str.append(firstChar);
	      
	      while(!qu.isEmpty()) {
	    	  Map.Entry<Character, Integer> entry  = qu.remove();
	    	  if(entry.getValue() == max) str.append(entry.getKey());
	      }
	      
	      return str.toString();
	    }

	public static void main(String[] args) {
		int[] testCount = {0, 0};
		System.out.println("Character Mode Tests");

	    assertTest(testCount, "should return 'l' for input 'hello'", new Test() {
	      public boolean execute() {
	        String output = characterMode("hello");
	        return output.equals("l");
	      }
	    });

	    assertTest(testCount, "should return 'a' when input is 'A walk in the park'", new Test() {
	      public boolean execute() {
	        String output = characterMode("A walk in the park");
	        return output.equals("a");
	      }
	    });

	    assertTest(testCount, "should return 'no' when input is 'noon'", new Test() {
	      public boolean execute() {
	        String output = characterMode("noon");
	        return output.equals("no");
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
