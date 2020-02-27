package algorithms.companies.amzn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutocompleteSystem {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addWord("cat");
		trie.addWord("car");
		trie.addWord("cart");
		trie.addWord("care");
		trie.addWord("comp");
		trie.addWord("app");
		trie.addWord("apple");
		
		System.out.println(trie.autoComplete("ca"));
	}
}

class Trie{
	TrieNodeForAutoComplete root;
	
	public Trie() {
		this.root = new TrieNodeForAutoComplete('\u0000');
	}
	
	public void addWord(String word) {
		if(word == null) return;
		TrieNodeForAutoComplete temp = root;
		for(int i = 0; i < word.length(); i++) {
			if(!temp.trieMap.containsKey(word.charAt(i))) temp.trieMap.put(word.charAt(i), new TrieNodeForAutoComplete(word.charAt(i)));
			temp = temp.trieMap.get(word.charAt(i));
		}
		temp.isEndOfWord = true;
	}
	
	public TrieNodeForAutoComplete getPrefix(String prefix) {
		if(prefix == null) return null;
		TrieNodeForAutoComplete temp = root;
		if(isPrefix(prefix)) {
			for(int i = 0; i < prefix.length(); i++) {
				temp = temp.trieMap.get(prefix.charAt(i));
			}
		} else return null;
		return temp;
	}
	
	private boolean isPrefix(String prefix) {
		if(prefix == null) return false;
		TrieNodeForAutoComplete temp = root;
		for(int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(!temp.trieMap.containsKey(ch)) return false;
			temp = temp.trieMap.get(ch);
		}
		return temp != null;
	}
	
	public List<String> autoComplete(String word){
		if(word == null) return Collections.emptyList();
		TrieNodeForAutoComplete currentNode = getPrefix(word);
		List<String> result = new ArrayList<String>();
		if(currentNode != null) {
			dfs(currentNode, word, result, '\u0000');
		}
		return result;
	}
	
	public void dfs(TrieNodeForAutoComplete currentNode, String word, List<String> result, char currentChar) {
		//add the current char to the word
		word += currentChar;
		//base case for recursive dfs
		if(currentNode.isEndOfWord) result.add(word);
		for(TrieNodeForAutoComplete node: currentNode.trieMap.values())
			dfs(node, word, result, node.val);		
	}
}

class TrieNodeForAutoComplete{
	char val;
	boolean isEndOfWord;
	Map<Character, TrieNodeForAutoComplete> trieMap;
	
	public TrieNodeForAutoComplete(char ch) {
		this.val = ch;
		this.isEndOfWord = false;
		this.trieMap = new HashMap<Character, TrieNodeForAutoComplete>();
	}
}
