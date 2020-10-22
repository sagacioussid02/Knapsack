package algorithms.discussions;

public class OddsAfterEven {
	
	public static int[] oddsAfterEven(int[] a) {
		int left = 0;
		int right = a.length - 1;
		
		while(left < right) {
			if(!isEven(a[left]) && isEven(a[right])){
				swap(a, left, right);
				left++;
				right--;
			} else if(isEven(a[left]) && !isEven(a[right])) {
				left++;
				right--;
			} else if(isEven(a[left]) && isEven(a[right])) {
				left++;
			} else if(!isEven(a[left]) && !isEven(a[right])) {
				right--;
			}
		}
		return a;
	}
	
	private static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}
	
	public static boolean isEven(int a) {
		return a % 2 == 0;
	}

	public static void main(String[] args) {
		int[] a = new int[] {10,5,4,6,7,8,2};
		oddsAfterEven(a);
	}

}
