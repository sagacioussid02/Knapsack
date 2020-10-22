package orcl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;


public class WordSearch2 {
	
	public static WordSearchTrieNode rootNode;
	static Set<String> result = new HashSet<String>();
	
	public WordSearch2(WordSearchTrieNode rootNode) {
		this.rootNode = rootNode;
	}
	
    public static List<String> findWords(char[][] board, String[] words) {
    	
    	//Construct the trie
    	WordSearchTrieNode rootNode = new WordSearchTrieNode('\u0000');
    	WordSearch2 wordSearch2 = new WordSearch2(rootNode);
    	for(String s:words) {
    		addNode(s);
    	}
    	
    	//DFS for each cell of the board
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] visited = new int[board.length][board[0].length];
    	for(int i=0;i<board.length;i++) {
    		for(int j=0;j<board[0].length;j++) {
    			char currentChar = board[i][j];
    			if(rootNode.children.containsKey(currentChar)) {
    				visited[i][j] = 1;
    				dfs(i,j,rootNode.children.get(currentChar),dx,dy,board,new StringBuilder().append(currentChar),visited);
    			}
    		}
    	}
    	List<String> resultList = new ArrayList<String>();
    	resultList.addAll(result);
        return resultList;
    }
    
    private static void dfs(int row, int col, WordSearchTrieNode rootNode, int[] dx, int[] dy, char[][] board, StringBuilder currentString, int[][] visited) {
		if(rootNode.isEndOfWord) {
			result.add(currentString.toString());
			return;
		}
		
    	for(int i=0;i<4;i++) {
    		int r = row + dx[i];
    		int c = col + dy[i];
    		if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && rootNode.children.containsKey(board[r][c]) && visited[r][c] == 0) {
    			currentString.append(board[r][c]);
    			WordSearchTrieNode tempNode = rootNode.children.get(board[r][c]);
    			dfs(r,c,tempNode,dx,dy,board,currentString,visited);
    			currentString.deleteCharAt(currentString.length() - 1);
    		}
    	}
    	
    	
	}

	public static void addNode(String s) {
    	WordSearchTrieNode temp = rootNode;
    	for(char ch:s.toCharArray()) {
    		if(!temp.children.containsKey(ch)) {
    			WordSearchTrieNode newNode = new WordSearchTrieNode(ch);
    			temp.children.put(ch,newNode);
    			temp = newNode;
    		} else {
    			temp = temp.children.get(ch);
    		}
    	}
    	temp.isEndOfWord = true;
    }
    

	public static void main(String[] args) {
		/*
		 * char[][] board = { {'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'},
		 * {'i','f','l','v'} }; String[] words = {"oath","pea","eat","rain"};
		 * System.out.println(findWords(board, words)); System.out.println(result);
		 */
		
		char[][] board = {{'a','a'}};
		String[] words = {"aaa"};
		System.out.println(findWords(board, words));
	}

}

class WordSearchTrieNode{
	char value;
	Map<Character,WordSearchTrieNode> children;
	boolean isEndOfWord;
	
	public WordSearchTrieNode(char value) {
		this.value = value;
		children = new HashMap<Character,WordSearchTrieNode>();
		isEndOfWord = false;
	}
}
