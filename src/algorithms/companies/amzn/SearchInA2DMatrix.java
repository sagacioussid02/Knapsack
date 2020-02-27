package algorithms.companies.amzn;

public class SearchInA2DMatrix {

	public static void main(String[] args) {
		System.out.println(search(new int[][] {{1,2,3},{4,5,6},{7,8,9}},6));
	}
	
	public static boolean search(int[][] mat, int target) {
		if(mat == null || mat.length == 0) return false;
		
		int left = 0;
		int right = mat.length - 1;
		
		while(left < mat.length && right > 0) {
			if(mat[left][right] == target) return true;
			if(mat[left][right] > target) right--;
			else left++;
		}
		return false;
	}

}
