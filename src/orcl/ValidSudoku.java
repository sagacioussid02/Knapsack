package orcl;

import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
	
    public static boolean isValidSudoku(String[][] board) {
    	int rows = board.length;
    	int cols = board[0].length;
    	Set<String> seenValues = new HashSet<String>();
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			int block = (i/3)*3 + (j/3);
    			if(board[i][j] != "." && (!seenValues.add(board[i][j]+"for row"+i) 
    					|| !seenValues.add(board[i][j]+"for column"+j) 
    					|| !seenValues.add(board[i][j]+"for block"+block))) {
    				return false;
    			};
    		}
    	}
		return true;
    }

	public static void main(String[] args) {
		String[][] board = {{"5","3",".",".","7",".",".",".","."}
						,{"6",".",".","1","9","5",".",".","."}
						,{".","9","8",".",".",".",".","6","."}
						,{"8",".",".",".","6",".",".",".","3"}
						,{"4",".",".","8",".","3",".",".","1"}
						,{"7",".",".",".","2",".",".",".","6"}
						,{".","6",".",".",".",".","2","8","."}
						,{".",".",".","4","1","9",".",".","5"}
						,{".",".",".",".","8",".",".","7","9"}};
		isValidSudoku(board);
	}

}	
