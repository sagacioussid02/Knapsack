package homework;

public class RecursionPowerOfANumber {
	
	/**
	 * 2f. Given a base and an exponent, create a method to find the power using
	 *     Helper Method Recursion
	 *
	 * Input:   Two Integers, base and exponent
	 * Output:  Integer
	 *
	 * Example: Power.compute(3, 4) => 81
	 */
	  public static int compute(int a, int b) {
		  if(a == 0) return 0;
		  if(a == 1 || b == 0) return 1;
		  return getPowerHelper(a, b);
	  }
	  
	  public static int getPowerHelper(int a , int b) {
		  if(b == 0) return 1;
		  return a * (getPowerHelper(a, b - 1));
	  }
	  
	  public static void main(String[] args) {
		  System.out.println(compute(3, 4));
		  System.out.println(compute(5, 0));
		  System.out.println(compute(1, 100));
	  }

}
