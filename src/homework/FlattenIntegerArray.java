package homework;

import java.util.Arrays;

public class FlattenIntegerArray {
	
	/**
	 * 2e. Flatten a two dimensional integer array using Helper Method of Recursion
	 *
	 * Input:   two-dimensional Integer Array
	 * Output:  Array of Integers
	 *
	 * Example: int matrix[][]= {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	 *          Flatten.compute(matrix) =>
	 *          {1, 2, 3, 4, 5, 6, 7, 8, 9}
	 */
	  public static int[] compute(int[][] matrix) {
		  if(matrix == null || matrix.length == 0) return new int[] {};
		  int[] res = new int[matrix[0].length * matrix.length];
		  helper(matrix, 0, res, 0);
		  return res;
	  }
	  
	  public static void helper(int[][] matrix,int pos, int[] res, int resPos) {
		  if(pos == matrix.length) return;
		  for(int i = 0;i<matrix[pos].length;i++) {
			  res[resPos] = matrix[pos][i];
			  resPos++;
		  }
		  helper(matrix, pos + 1, res, resPos);
		  
	  }

	public static void main(String[] args) {
	  int[] res = compute(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
	  Arrays.stream(res).forEach(System.out::println);
	  
	  int[] resEmpty = compute(new int[][] {});
	  Arrays.stream(resEmpty).forEach(System.out::println);
	}

}
