package homework;

public class BitFlip {
	
	/*
	*  Problem 2: Bit Flip
	*
	*     Given an array of binary values (0 and 1) and N number of flips (convert
	*     a 0 to a 1), determine the maximum number of consecutive 1's that can be
	*     made.
	*
	*  Input: An Array of 1's and 0's, and an Integer N denoting the number of
	*         flips
	*  Output: Integer
	*
	*  Example: bitFlip([0,1,1,1,0,1,0,1,0,0], 2)
	*  Result: 7
	*/

	   // Time Complexity: O(N)
	   // Auxiliary Space Complexity: O(N)
	   public static int bitFlip(int[] arr, int N) {
		   if(arr.length == 0) return 0;
		   int countZeros = arr[0] == 0?1:0;
		   int[] res = new int[arr.length];
		   res[0] = 1;
		   int max = res[0];
		   
		   for(int i = 1; i < res.length; i++) {
			   if(arr[i] == 1) res[i] = res[i - 1] + 1;
			   else {
				   countZeros++;
				   if(countZeros < N + 1) res[i] = res[i - 1] + 1;
				   else res[i] = res[i - 1];
			   }
			   max = Math.max(max, res[i]);
		   }
		   return max;
	   }

	public static void main(String[] args) {
		System.out.println(bitFlip(new int[] {0,1,1,1,0,1,0,1,0,0}, 2));
		System.out.println(bitFlip(new int[] {0}, 1));
	}

}
