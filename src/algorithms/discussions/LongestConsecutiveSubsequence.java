package algorithms.discussions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Input: [100, 4, 200, 1, 3, 2] Output: 4
 * 
 * @author SS057631
 *
 */
public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		int[] arr = new int[] {100, 4, 200, 1, 3, 2};
		System.out.println(getLongestConsecutiveSubsequence(arr));
		System.out.println(getLongestConsecutiveSubsequenceOptimized(arr));

	}
	
	//O(nlogn) by sorting
	public static int getLongestConsecutiveSubsequence(int[] tempArray) {
		
		//sort the numbers
		Arrays.sort(tempArray);
		int prev = tempArray[0];
		int max = Integer.MIN_VALUE;
		for(int i=1;i<tempArray.length;i++) {
			int length = 0;
			while(tempArray[i]==prev+1) {
				prev=tempArray[i];
				i++;
				length++;
			}
			max = Math.max(max, length);
			length = 0;
		}
		return max+1;
	}
	
	//O(n) method
	public static int getLongestConsecutiveSubsequenceOptimized(int[] arr) {
		int max = Integer.MIN_VALUE;
		//store the values in the set which are already calculated
		//and we only build sequences from numbers that are not already part of a longer sequence
		Set<Integer> sequenceSet = new HashSet<Integer>();
		
		//add all the numbers to the set to use contains method in O(1) times
		for(int each:arr) {
			sequenceSet.add(each);
		}
		
		//iterate through the set for all the integers once
		for(int num:sequenceSet) {
			//initialize longest length for the current iteration
			int streak = 0;
			
			//check if the current value's prev is in the set
			//if not then just make the length streak as just 1
			//in this scenario we are trying to find the first number
			//in the streak. If there is any previous number then we will skip that.
			if(!sequenceSet.contains(num-1)) {
				//initialize current number pointer to add the values for checking
				int currentNum = num;
				streak += 1;			
			    //check for next value in while till it finds all of them
			    //and add the length of the streak and current number
				while(sequenceSet.contains(currentNum+1)) {
					currentNum+=1;
					streak+=1;
				}
			}
			max = Math.max(max, streak);
		}
		return max;
	}

}
