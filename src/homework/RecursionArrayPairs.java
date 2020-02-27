package homework;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RecursionArrayPairs {
	
	/**
	 * 2d. Given an array of positive integers, create an array of two-item integer
	 *     arrays (two dimensional integer array) using Helper Method Recursion
	 *
	 * Input:   Array of Integers
	 * Output:  two-dimensional Integer Array
	 *
	 * Example: int[] nums = {1, 2, 3, 4, 5, 6};
	 *          ArrayPairs.compute(nums)  =>
	 *          {{1,2}, {3,4}, {5,6}}
	 *
	 * Example: int[] nums2 = {1, 2, 3, 4, 5};
	 *          ArrayPairs.compute(nums2)  =>
	 *          {{1,2}, {3,4}, {5, -1}}
	 */	
	  public static int[][] compute(int[] arr) {
		    if(arr.length == 0) return new int[][] {};
		    int mid = arr.length%2 == 0? arr.length/2:arr.length/2+1;
		    int[][] res = new int[mid][2];
		    helper1(arr,0,0,res);
		    return res;
	  }
	  
	  public static void helper1(int[] arr, int index,int pos, int[][] res) {
		  //base case
		  if(index == arr.length - 1) {
			  res[pos][0] = arr[index];
			  return;
		  }
		  if(index == arr.length) return;
		  res[pos][0] = arr[index];
		  res[pos][1] = arr[index + 1];
		  helper1(arr, index + 2, pos + 1, res);
	  }

	public static void main(String[] args) {
		
		/*
		 * int[][] arr = compute(new int[]{1,2,3,4,5,6});
		 * Stream.of(arr).flatMapToInt(IntStream::of).forEach(System.out::println);
		 */
   	    
		int[][] arr1 = compute(new int[]{1,2,3,4,5});
   	    Stream.of(arr1).flatMapToInt(IntStream::of).forEach(System.out::println);
		/*
		 * int[][] arr = compute(new int[]{1,2,3,4,5,6}); for(int i =
		 * 0;i<arr.length;i++) { for(int j = 0;j<arr[0].length;j++)
		 * System.out.println(arr[i][j]); }
		 */
	}

}
