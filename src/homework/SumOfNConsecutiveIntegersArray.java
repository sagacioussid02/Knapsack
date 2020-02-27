package homework;

public class SumOfNConsecutiveIntegersArray {
	
	   // Time Complexity: O(n)
	   // Auxiliary Space Complexity: O(n)
	public static int maxConsecutiveSum(int[] arr) {
		if(arr.length == 0) return 0; 
		int[] res = new int[arr.length + 1];
		res[0] = 0;
		res[1] = arr[0];

		for (int i = 2; i < res.length; i++) {
			res[i] = (arr[i - 1] > 0) ? arr[i - 2] < 0 ? arr[i - 1] : res[i - 1] + arr[i - 1] : res[i - 1];
		}
		return res[res.length - 1];
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,-1,5,6,-2,21};
		System.out.println(maxConsecutiveSum(arr));
		
		System.out.println(maxConsecutiveSum(new int[]{6, -1, 3, 5, -10}));
		
	}

}
