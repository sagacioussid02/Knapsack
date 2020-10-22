package orcl;

public class MaximumSubArray {
	
    public int maxSubArray(int[] nums) {
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
		// TODO Auto-generated method stub

	}

}
