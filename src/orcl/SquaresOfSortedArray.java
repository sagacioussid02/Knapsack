package orcl;

public class SquaresOfSortedArray {
	
	//two pointer approach
    public static int[] sortedSquares(int[] A) {
    	int left = 0;
    	int right = A.length - 1;
    	int[] res = new int[A.length];
    	int pos = res.length - 1;
    	while(left <= right && A[left] < 0) {
    		if(Math.pow(A[left], 2)  > Math.pow(A[right], 2)) {
    			res[pos--] = (int) Math.pow(A[left++], 2);
    		} else {
    			res[pos--] = (int) Math.pow(A[right--], 2);
    		}
    	}
    	
    	while(pos >= 0 && right >= 0 && A[right] >= 0) {
    		res[pos--] = (int) Math.pow(A[right--], 2);
    	}
    	
        return res;
    }

	public static void main(String[] args) {
		int[] A = {0,2};
		sortedSquares(A);
	}

}
