package algorithms.discussions;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution using the divide and conquer approach, which is more subtle.
 * 
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6
 * 
 * @author SS057631
 *
 */
public class MaximumSubArraySum {
	
	//brute force: get all the continuous subarray and keep updating max. O(n2)
	//dp: get the max sum including and excluding an integer. O(n) and O(n)
    public static int maxSubArray(int[] nums) {
    	if(nums.length == 0) return 0;
    	if(nums.length == 1) return nums[0];
    	
    	//here we will try to figure out the max possible sum ending at an index
    	//the max has to be updated each time
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	int max = nums[0];
    	for(int i=1;i<nums.length;i++) {
    		dp[i] =  Math.max(dp[i-1] + nums[i], nums[i]);
    		max = Math.max(max, dp[i]);
    	}
        return max;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
		nums = new int[] {-1,-2};
		System.out.println(maxSubArray(nums));
	}

}
