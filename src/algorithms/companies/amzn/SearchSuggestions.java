package algorithms.companies.amzn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchSuggestions {

	public static void main(String[] args) {
		System.out.println(getAllSuggestions(new String[] {"flower", "following", "flown"}, "fl"));
		System.out.println(getLettersWithSamePrefixUsingTries(new String[] {"flower", "following", "flown"}, "fl"));
	}
	
	public static List<List<String>> getAllSuggestions(String[] arr, String str){
		if(str == null) return Collections.emptyList();
		//get the common prefix for each character in str and add it to the list
		List<List<String>> res = new ArrayList<List<String>>();
		for(int i=1;i<=str.length();i++) {
			res.add(getLettersWithSamePrefix(arr, str.substring(0,i)));
		}
		
		return res;
	}
	
	public static List<String> getLettersWithSamePrefix(String[] arr, String str){
		if(str.equals(""));
		List<String> res = new ArrayList<String>();
		for(int i=0;i<arr.length;i++) {
			String each = arr[i];
			int count = 0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j) == each.charAt(j)) count++;
			}
			if(count == str.length()) res.add(each);
		}
		return res;
	}
	
	public static List<String> getLettersWithSamePrefixUsingTries(String[] arr, String str){
		if(str.equals("")) return Collections.emptyList();
		List<String> res = new ArrayList<String>();
		for(int i=0;i<arr.length;i++) {
			String each = arr[i];
			for(int j=1;j<=str.length();j++) {
				Tries tries = new Tries();
				tries.addWord(each);
				if(tries.isPrefix(str.substring(0, j))) res.add(each);
			}
		}
		return res;
	}

}

class Tries {
	TrieNode root;
	
	public void addWord(String word) {
		if(word == null) return;
		TrieNode tempNode = root;
		for(int i=0;i<word.length();i++) {
			if(tempNode.children[word.charAt(i) - 'a'] == null)
				tempNode.children[word.charAt(i) - 'a'] = new TrieNode();
			tempNode = tempNode.children[word.charAt(i) - 'a'];
		}
		tempNode.isLastNode = true;
	}
	
	public boolean isPrefix(String word) {
		if(word == null) return false;
		TrieNode tempNode = root;
		for(int i=0;i<word.length();i++) {
			if(tempNode.children[word.charAt(i) - 'a'] == null) return false;
			tempNode = tempNode.children[word.charAt(i) - 'a'];
		}
		return tempNode != null;
	}
	
}

class TrieNode{
	TrieNode[] children;
	boolean isLastNode;
	
	
	public TrieNode() {
		isLastNode = false;
		children = new TrieNode[26];
		for(int i = 0;i< children.length;i++) {
			children[i] = null;
		}
	}
	
}
