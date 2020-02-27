package TicTacToe;

import java.util.Random;

public class TicTacToe {
	
	char[][] board;
	int sizeCount = 0;
	public TicTacToe() {
		board = new char[3][3];
		for(int i=0; i < 3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = '-';
			}
		}
	}
	public void addToken(int x_pos, int y_pos, char token) {
		//check the coordinates
		if(x_pos < 0 || x_pos > 2 || y_pos < 0 || y_pos > 2) return;
		
		//check if it is X or O
		if(token == 'X') {
			board[x_pos][y_pos] = 'X';
			sizeCount++;
		}
		if(token == 'O') {
			board[x_pos][y_pos] = 'O';
			sizeCount++;
		}
	}
	
	//method to print the board
	public void printBoard() {
		for(int i=0; i < 3;i++) {
			for(int j=0;j<3;j++) {
				if(j<2) System.out.print(board[i][j]+"|");
				else System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
	
	public boolean isFull() {
		return sizeCount == 9;
	}
	
	public void addRandom() throws Exception {
		Random rand = new Random();
		if(!isFull()) {
			int x_pos = rand.nextInt(3);
			int y_pos = rand.nextInt(3);
			while(board[x_pos][y_pos] != '-') {
				x_pos = rand.nextInt(3);
				y_pos = rand.nextInt(3);
			}
			board[x_pos][y_pos] = 'O';
		} else {
			throw new Exception();
		}
	}

}
