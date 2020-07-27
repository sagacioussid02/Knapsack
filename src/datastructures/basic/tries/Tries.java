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
	
	public String longestCommonPrefix() {
	    if(root == null) return "";
	    StringBuilder ans = new StringBuilder();
	    TrieNode tempNode = root;
	    while(tempNode != null) {
	        if(hasOnlyOneChild(tempNode)) {
	            char childNode = getChildNode(tempNode);
	            ans.append(childNode);
	            tempNode = tempNode.children[childNode - 'a'];
	        } else {
	            return ans.toString();
	        }
	    }
	    return ans.toString();
	}
	
	private boolean hasOnlyOneChild(TrieNode temp) {
	    if(temp == null) return false;
	    
	    int count = 0;
	    for(int i = 0; i < temp.children.length; i++) {
	        if(temp.children[i] != null) count++;
	    }
	    return count == 1;
	}
	
	private char getChildNode(TrieNode temp) {
	    if(temp == null) return '\u0000';
	    for(int i = 0; i < temp.children.length; i++) {
	        if(temp.children[i] != null) return (char)(i + 'a');
	    }
	    return '\u0000';
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
