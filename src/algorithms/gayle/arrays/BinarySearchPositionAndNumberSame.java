package algorithms.gayle.arrays;

public class BinarySearchPositionAndNumberSame {
	
	public static int getPositionWithSameNumber(int[] arr) {
		
		if(arr.length == 0) return -1;
		int left = 0;
		int right = arr.length - 1;
		
		while(left < right - 1) {
			int mid = (left + right) / 2;
			if(arr[mid] > mid) right = mid;
			else if(arr[mid] < mid) left = mid;
			else return mid;
		}
		return -1; 
	}

	public static void main(String[] args) {
		System.out.println(getPositionWithSameNumber(new int[] {1,1,3,5,8}));
	}

}
