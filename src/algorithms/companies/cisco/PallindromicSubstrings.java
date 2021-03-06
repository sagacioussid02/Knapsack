package algorithms.companies.cisco;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PallindromicSubstrings {

	// expand in both directions of low and high to find all palindromes
		public static void expand(String str, int low, int high, Set<String> set)
		{
			// run till str[low.high] is a palindrome
			while (low >= 0 && high < str.length()
					&& str.charAt(low) == str.charAt(high))
			{
				// push all palindromes into the set
				set.add(str.substring(low, high + 1));

				// expand in both directions
				low--;
				high++;
			}
		}

		// Function to find all unique palindromic substrings of given string
		public static void allPalindromicSubStrings(String str)
		{
			// create an empty set to store all unique palindromic substrings
			Set<String> set = new TreeSet<>();

			for (int i = 0; i < str.length(); i++)
			{
				// find all odd length palindrome with str[i] as mid point
				expand(str, i, i, set);

				// find all even length palindrome with str[i] and str[i+1]
				// as its mid points
				expand(str, i, i + 1, set);
			}

			// print all unique palindromic substrings
			System.out.print(set.stream().findFirst().get());
		}

		public static void main(String[] args)
		{
			String str = "google";

			allPalindromicSubStrings(str);
		}
}
