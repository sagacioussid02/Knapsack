package algorithms.discussions;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.HashSet;

public class TwoAndTHreeSum {
	
	public static void main(String[] args) {
		twoSum(new int[] {2,7,11,15}, 9);
	}
	
	public static void twoSum(int[] nums, int target){
		//brute force is to get all combinations of two numbers
		//and do the target check which will be O(n2)
		//Better approach is to use a two pointer approach
		//which can be done by sorting and using left and right pointer
		//at first and last of the array. The complexity will ne nlogn;
		int[] result = twoPointedApproach(nums,target);
		IntStream.of(result).forEach(System.out::println);
		//Another better method is to use a DS hashmap where
		//you will subr=tract the first number from target and find the 
		//suntracted number in the array. This will be done for all the numbers 
		//which will make it work in one go and therefore O(n).
		int[] resultFromMapApproach = mapApproach(nums,target);
		IntStream.of(result).forEach(System.out::println);
	}

	//O(n) plus space complexity is O(n)
	private static int[] mapApproach(int[] nums, int target) {
		Set<Integer> compliments= new HashSet<Integer>();
		int index = 0;
		for(int each:nums) {
			int compliment = target - each;
			if(compliments.contains(compliment)) {
				return new int[] {each, compliment};
			} else {
				compliments.add(compliment);
			}
			index++;
		}
		return new int[2];
	}

	//nlogn
	private static int[] twoPointedApproach(int[] nums, int target) {
		//sort the numbers
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int[] result = new int[2];
		while(left < right) {
			if(nums[left] + nums[right] == target) {
				return  new int[] {nums[left], nums[right]};
			} else if(nums[left] + nums[right] > 0) {
				right--;
			} else {
				left++;
			}
		}
		return result;
	}

}
