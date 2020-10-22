package algorithms.discussions;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * @author SS057631
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(getLongestSubstringLengthWithoutRepeatingChars("pwwkew"));
		System.out.println(getLongestSubstringLengthWithoutRepeatingChars("abcabcbb"));
		System.out.println(getLongestSubstringLengthWithoutRepeatingChars("bwf"));
		System.out.println(getLongestSubstringLengthWithoutRepeatingChars("qrsvbspk"));
		
		System.out.println(getLongestSubstringHashMapApproach("pwwkew"));
		System.out.println(getLongestSubstringHashMapApproach("abcabcbb"));
		System.out.println(getLongestSubstringHashMapApproach("bwf"));
		System.out.println(getLongestSubstringHashMapApproach("qrsvbspk"));
	}
	
	//O(n) hashmap method
	//figuring out and updating max in eah iteration
	private static int getLongestSubstringHashMapApproach(String str) {
		//validations
		if(str==null || str.length() == 0) return 0;
		if(str.length() == 1) return 1;
		int max = 0;
		Map<Character, Integer> charByIndex = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		while(left <= right && right < str.length()) {
			if(charByIndex.containsKey(str.charAt(right))) {
				left = charByIndex.get(str.charAt(right)) + 1;
			}
			max = Math.max(max, right - left + 1);
			charByIndex.put(str.charAt(right), right);
			right++;
		}
		return max;
	}

	//sliding window approach O(n)
	//but there are few branches which can get you stuck
	private static int getLongestSubstringLengthWithoutRepeatingChars(String str) {
		//validations
		if(str==null || str.length() == 0) return 0;
		if(str.length() == 1) return 1;
		//dynamic sliding window approach can be used here
		//trick is to use two pointers and keep it expanding
		int left = 0;
		int right = 1;
		int max = 0;
		Set<Character> charSet = new HashSet<Character>();
		charSet.add(str.charAt(left));
		while(left < right && right < str.length()) {
			while(right < str.length() && !charSet.contains(str.charAt(right))) {
				if(right < str.length()) charSet.add(str.charAt(right));
				right++;
			}
			max = Math.max(max, charSet.size());
			if(right >= str.length()) continue;
			char rightChar = str.charAt(right);
			while(str.charAt(left) != rightChar) {
				charSet.remove(str.charAt(left));
				left++;
			}
			if(right < str.length())  charSet.add(str.charAt(right));
			left++;
			right++;
		}
		
		return max;
	}

}
