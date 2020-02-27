package algorithms.gayle.arrays;

import java.util.Arrays;

public class BinarySearchGetFirstAndLastIndex {
	
	public static int[] getFirstAndLastOccurence(int[] arr, int target) {
		
		if(arr.length == 0) return new int[] {};
		if(arr.length == 1 && arr[0] == target) return new int[] {0};
		else if(arr.length == 1 && arr[0] != target) return new int[] {};
	
		int left = 0;
		int right = arr.length - 1;
		int[] res = new int[2];
		
		//get the first occurence
		while(left < right - 1) {
			int mid = (left + right) / 2;
			if(arr[mid] >= target) right = mid;
			else if(arr[mid] < target) left = mid;
		}
		res[0] = arr[right] == target?right:-1;
		
		//get the last occurence
		left = 0;
		right = arr.length - 1;
		while(left < right - 1) {
			int mid = (left + right) / 2;
			if(arr[mid] > target) right = mid;
			else if(arr[mid] <= target) left = mid;
		}
		res[1] = arr[left] == target?left:-1;
		return res;
	}

	public static void main(String[] args) {
		Arrays.stream(getFirstAndLastOccurence(new int[] {1,1,1,1,1,2,2,3,3,4,5,5}, 2)).forEach(System.out::println);;
	}

}
