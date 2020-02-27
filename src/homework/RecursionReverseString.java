package homework;

public class RecursionReverseString {
	
	/**
	 *  2c. Reverse a string using Helper Method Recursion
	 *
	 *  Input:   String
	 *  Output:  String
	 *
	 *  Example: String greeting = 'hello';
	 *          ReverseString.compute(greeting) => 'olleh'
	 */

	  static StringBuilder build = new StringBuilder();
	  public static String compute(String str) {
		if(str == null) return "";
		reverseString(str, str.length() - 1);
	    return build.toString();
	  }
	  
	  private static void reverseString(String str, int pos){
		  //base case
		  if(pos == -1 || str.charAt(pos) == '\u0000') return;
		  build.append(str.charAt(pos));
		  reverseString(str, pos - 1);
	  }
	

	public static void main(String[] args) {
		//System.out.println(compute("abc"));
		//System.out.println(compute(""));
		System.out.println(compute("a"));
	}

}
