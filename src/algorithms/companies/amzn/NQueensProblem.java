package algorithms.companies.amzn;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so
 * that no two queens attack each other.
 * 
 * @author SS057631
 *
 */
public class NQueensProblem {
	
	//Kind of generating permutation of all possible ways
	//Return true if you find any possible scenarios
	//check if the queen is under attack
	//use backtracking if you do not reach to a solution
	
	//check if he queen is attacked
	public static boolean isAttacked(int x, int y, int[][] grid) {
		if(x > grid.length && x < 0 && y < 0 && y > grid[0].length) return false;
		
		//check for rows
		for(int i = 0; i < grid.length ; i++) {
			if(grid[i][y] == 1) return true;
		}
		
		//check for columns
		for(int i = 0; i < grid[0].length ; i++) {
			if(grid[x][i] == 1) return true;
		}
		
		//check for diagonals
		int diff = Math.abs(y - x);
		int add = Math.abs(x + y);
		//checking for left diagonal
		for (int i = x - 1; i >= 0; i++) {
			if (diff - i < grid[0].length && grid[i][diff + i] == 1
					|| add - i < grid[0].length && grid[i][add - i] == 1)
				return true;
		}
		
		// checking for right diagonal
		for (int i = x + 1; i < grid.length; i++) {
			if (diff + i < grid[0].length && grid[i][diff + i] == 1
					|| add - i < grid[0].length && grid[i][add - i] == 1)
				return true;
		}
		
		return false;
	}
	
	public static boolean backtrackingNQueensPossibilities(int[][] grid, int n) {
		//bounding condition when all the queens are placed
		if(n == 0) return true;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(!isAttacked(i,j,grid)) {
					grid[i][j] = 1;
					//apply dfs here
					backtrackingNQueensPossibilities(grid, n - 1);
					grid[i][j] = 0;
				}
			}			
		}
		return false;
	}

	public static void main(String[] args) {
		
	}

}
