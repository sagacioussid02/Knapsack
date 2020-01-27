package algorithms.companies.goog;

import java.util.Arrays;

//Find the number k by which some elements will be adusted 
//where all the elements in th array should be less than 
//or equal to k so that the sum of the array is equal to the
//target sum. For e.g. [100,300,200,400] target = 800 then k = 250
public class ArrayAdjustment {

	public static void main(String[] args) {
		System.out.println(adjustedToK(new int[] {100,300,400,200}, 800));
	}
	
	public static int adjustedToK(int[] ar, int target) {
		//find the sum of all elements is how much  greater than target
		int initialSum = 0;
		for(int i:ar) {
			initialSum += i;
		}
		int diff = initialSum - target;
		
		//sort the array
		//using binary search find the largest element greater than k
		//and sum all those number greater than k and count
		int count = 0;
		int auxSum = 0;
		Arrays.sort(ar);
		for(int i = ar.length - 1; i > 0; i--) {
			if(ar[i] > diff) {
				auxSum += ar[i];
				count++;
			} else {
				break;
			}
		}
		
		if(auxSum == 0 && count == 0) return 0;
		return (auxSum - diff) / count;
	}
}
