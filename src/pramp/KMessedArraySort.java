package pramp;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of integers arr where each element is at most k places away
 * from its sorted position, code an efficient function sortKMessedArray that
 * sorts arr. For instance, for an input array of size 10 and k = 2, an element
 * belonging to index 6 in the sorted array will be located at either index 4,
 * 5, 6, 7 or 8 in the input array.
 * 
 * Analyze the time and space complexities of your solution.
 * 
 * @author SS057631
 *
 */
public class KMessedArraySort {

	public static void main(String[] args) {
		Arrays.stream(sortKMessedArray(new int[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)).forEach(System.out::println);
	}
	
	static int[] sortKMessedArray(int[] arr, int k) {
		final PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		int right = 0;
		int left = 0;
		while(left < arr.length - k) {
			que.offer(arr[right]);
			if(right - left == k) {
				arr[left] = que.remove();
				left++;
			}
			right++;
		}
		
		if(!que.isEmpty()) {
			for(int i = arr.length - k; i < arr.length; i++) {
				arr[i] = que.remove();
			}
		}
		return arr;
	}

}
