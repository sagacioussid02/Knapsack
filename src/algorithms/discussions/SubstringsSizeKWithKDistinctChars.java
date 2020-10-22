package algorithms.discussions;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Given a string s and an int k, return all unique substrings of s of size k
 * with k distinct characters. 
 * Input: s = "abcabc", k = 3 
 * Output: ["abc", "bca", "cab"]
 * 
 * @author SS057631
 *
 */
public class SubstringsSizeKWithKDistinctChars {

	public static void main(String[] args) {
		uniqueSubstringSizeK("abcaa", 2).stream().forEach(System.out::println);;
	}
	
	public static Set<String> uniqueSubstringSizeK(String s, int k) {
		int i = 0;
		int j = 0;
		int[] lastFounded = new int[26];
		Arrays.fill(lastFounded, -1);
		
		Set<String> res = new HashSet<String>();
		
		while(j < s.length()) {
			if(lastFounded[s.charAt(j) - 'a'] >= i) {
				i = lastFounded[j] + 1;
			}
			lastFounded[s.charAt(j) - 'a'] = j;
			while(j - i + 1 == k) {
				res.add(s.substring(i, j+1));
				i++;
			}
			j++;
		}
		return res;
	}

}
