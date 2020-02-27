package algorithms.concepts;

/**
 * Application of Binary Search I have an array of words that are mostly
 * alphabetical, except they start somewhere in the middle of the alphabet,
 * reach the end, and then start from the beginning of the alphabet. In other
 * words, this is an alphabetically ordered array that has been "rotated."
 * 
 * Write a method for finding the index of the "rotation point," which is where
 * I started working from the beginning of the dictionary. This array is huge
 * (there are lots of words I don't know) so we want to be efficient here.
 * 
 * @author SS057631
 *
 */
public class RotationPoint {

	public static void main(String[] args) {
		System.out.println(findRotationIndex(new String[] { "pq", "qr", "rs", "st", "ab", "bc", "cd" }));
		System.out.println(findRotationIndex(new String[] { "pq", "qr", "rs", "st" }));
	}

	public static int findRotationIndex(String[] arr) {
		if (arr == null || arr.length == 1)
			return 0;
		String firstElement = arr[0];
		int left = 0;
		int right = arr.length - 1;

		// for an unrotated array
		if (arr[right].compareTo(firstElement) >= 0)
			return 0;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (arr[mid].compareTo(firstElement) >= 0)
				left = mid;
			else
				right = mid;
		}
		return right;
	}

}
