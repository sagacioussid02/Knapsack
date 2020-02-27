package TicTacToe;

public class Driver {

	public static void main(String[] args) throws Exception {
		TicTacToe ticTacToe = new TicTacToe();
		//middle and top row
		ticTacToe.addToken(0, 1, 'X');
		ticTacToe.printBoard();
		
		System.out.println(ticTacToe.isFull());
		
		for(int i=0;i<10;i++) {
			System.out.println("iteration = "+i);
			ticTacToe.addRandom();
			ticTacToe.printBoard();
		}
	}

}
