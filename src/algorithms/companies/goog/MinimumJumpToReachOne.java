package algorithms.companies.goog;

import java.util.Arrays;

/**
 * Jumping Steps:
 * 1. Divide by 3 if it is divisible
 * 2. Divide by 2 if it is divisible
 * 3. Subtract 1
 * Find the minimum number of steps to get 1 from the number
 * @author SS057631
 *
 */
public class MinimumJumpToReachOne {

	public static void main(String[] args) {
		Arrays.stream(getMinimumSteps(40)).forEach(e -> {
			System.out.print(" "+e);
		});
	}
	
	public static int[] getMinimumSteps(int num) {
		int[] stepsStore = new int[num + 1];
		stepsStore[1] = 0;
		stepsStore[2] = 1;
	
		
		for(int i = 3; i <= num ; i++) {
			int current = Integer.MAX_VALUE;
			current = Math.min(current, stepsStore[i - 1]);
			
			if(i % 3 == 0) {
				current = Math.min(current, stepsStore[i / 3]);
			} 
			
			if(i % 2 == 0) {
				current = Math.min(current, stepsStore[i / 2]);
			} 
			stepsStore[i] = current + 1;
		}
		return stepsStore;
	}

}
