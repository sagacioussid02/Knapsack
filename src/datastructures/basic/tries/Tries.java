package datastructures.basic.tries;

public class Tries {
	
	TrieNode root;
	
	public Tries() {
		root = new TrieNode();
	}
	
	public void addNode(String word) {
		if(word == null) return;
		TrieNode tempNode = root;
		
		for(int i=0;i<word.length();i++) {
			if(tempNode.children[word.charAt(i) - 'a'] == null) tempNode.children[word.charAt(i) - 'a'] = new TrieNode();
			tempNode = tempNode.children[word.charAt(i) - 'a'];
		}
		tempNode.isEndLetter = true;
	}
	
	public boolean searchNode(String word) {
		if(word == null) return false;
		
		TrieNode tempNode = root;
		for(int i=0;i<word.length();i++) {
			if(tempNode.children[word.charAt(i) - 'a'] == null) return false;
			tempNode = tempNode.children[word.charAt(i) - 'a'];
		}
		return (tempNode != null && tempNode.isEndLetter);
	}
	
	public boolean isPrefix(String word) {
		if(word == null) return false;
		
		TrieNode tempNode = root;
		for(int i =0;i<word.length();i++) {
			if(tempNode.children[word.charAt(i) - 'a'] == null) return false;
			tempNode = tempNode.children[word.charAt(i) - 'a'];
		}
		
		return tempNode != null;
	}

}

class TrieNode{
	TrieNode[] children;
	boolean isEndLetter;
	
	public TrieNode() {
		children = new TrieNode[26];
		isEndLetter = false;
		for(int i=0;i<children.length;i++) children[i] = null;
	}
	
}
