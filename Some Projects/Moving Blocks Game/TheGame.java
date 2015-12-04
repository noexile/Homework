import java.util.Scanner;

public class TheGame {

	public static void main(String[] args) {

		System.out.println("Greetings traverel. Your mind seems stressed and your body very tired. Let us play one simple game of moving blocks in order for you to rest.");
		System.out.println("The rules are simple. You play on a board 10 x 10. There is a circle ( o ) and blocks ( # ) on it.");
		System.out.println("You start on the top left and your goal is to move the circle to the bottom right corner of the board.");
		System.out.println("You move the circle when your board piece ( * ) is behind the circle and you move it.");
		System.out.println("Of course you must obey the rules and know that you cannot pass trough the blocks of the game.");
		System.out.println("You can use comands for Up ( u / U ), Down ( d / D), Left ( l / L ) and Right ( r / R ) to move your piece.");
		System.out.println();
		System.out.println("Now lets play!");
		System.out.println();

		char move;
		char emptySpace = ' ';
		char end = '_';
		char player = '*';
		char block = '#';
		char circle = 'o';

		boolean gameOn = true;
		boolean win = false;
		boolean noMoreMoves = false;
		boolean topLeftBlocks;
		boolean bottomLeftBlocks;
		boolean topRightBlocks;
		boolean bottomRightBlocks;

		Scanner input = new Scanner(System.in);

		// the Game Board 12 x 12 - it has borders
		char[][] board = { 
							{ block, block, block, block, block, block, block, block, block, block, block, block },
							{ block, player, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, block, emptySpace,	emptySpace, block, block },
							{ block, emptySpace, emptySpace, block, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, block },
							{ block, emptySpace, block, block, emptySpace, emptySpace, block, block, emptySpace, emptySpace, emptySpace, block },
							{ block, emptySpace, emptySpace, emptySpace, emptySpace, circle, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, block },
							{ block, emptySpace, block, emptySpace, block, emptySpace, emptySpace, block, block, emptySpace, emptySpace, block },
							{ block, emptySpace, emptySpace, block, block, emptySpace, emptySpace, block, emptySpace, block, emptySpace, block },
							{ block, emptySpace, emptySpace, emptySpace, block, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, block },
							{ block, block, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, block },
							{ block, block, emptySpace, emptySpace, emptySpace, block, block, emptySpace, emptySpace, emptySpace, block, block },
							{ block, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, emptySpace, end, block },
							{ block, block, block, block, block, block, block, block, block, block, block, block }, 
						 };

		// Printing the current board for the first time
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column++) {
				System.out.print(board[row][column]);
			}
			System.out.println();
		}

		do {

			// input the move - Top / Bottom / Left / Right
			do {
				System.out.print("Where do you want to move L, R, U, D ? ");
				move = input.next().charAt(0);
			} while (!(move == 'L' || move == 'l' || move == 'R' || move == 'r' || move == 'U' || move == 'u' || move == 'D' || move == 'd'));
			

			for (int i = 0; i < board.length; i++) {
				boolean trigger = false;
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] == player) { // loop finds the player position and depending of the move it calculates the next output
						if (move == 'L' || move == 'l') {
							if (board[i][j - 1] == circle) {
								if (board[i][j - 2] != block) {
									board[i][j] = emptySpace;
									board[i][j - 1] = player;
									board[i][j - 2] = circle;
									trigger = true;
									break;
								}
							} else if (board[i][j - 1] != block) {
								board[i][j] = emptySpace;
								board[i][j - 1] = player;
								trigger = true;
								break;
							}
						} else if (move == 'R' || move == 'r') {
							if (board[i][j + 1] == circle) {
								if (board[i][j + 2] != block) {
									board[i][j] = emptySpace;
									board[i][j + 1] = player;
									board[i][j + 2] = circle;
									trigger = true;
									break;
								}
							} else if (board[i][j + 1] != block) {
								board[i][j] = emptySpace;
								board[i][j + 1] = player;
								trigger = true;
								break;
							}
						} else if (move == 'U' || move == 'u') {
							if (board[i - 1][j] == circle) {
								if (board[i - 2][j] != block) {
									board[i][j] = emptySpace;
									board[i - 1][j] = player;
									board[i - 2][j] = circle;
									trigger = true;
									break;
								}
							} else if (board[i - 1][j] != block) {
								board[i][j] = emptySpace;
								board[i - 1][j] = player;
								trigger = true;
								break;
							}
						} else if (move == 'D' || move == 'd') {
							if (board[i + 1][j] == circle) {
								if (board[i + 2][j] != block) {
									board[i][j] = emptySpace;
									board[i + 1][j] = player;
									board[i + 2][j] = circle;
									trigger = true;
									break;
								}
							} else if (board[i + 1][j] != block) {
								board[i][j] = emptySpace;
								board[i + 1][j] = player;
								trigger = true;
								break;
							}
						}
					}
				}
				if (trigger) {
					break;
				}
			}

			// Printing the current board after moving
			for (int row = 0; row < board.length; row++) {
				for (int column = 0; column < board.length; column++) {
					System.out.print(board[row][column]);
				}
				System.out.println();
			}
			System.out.println();

			// Checking the position after moving -> No More Turns to Play / Win
			// the Game
			for (int row = 0; row < board.length; row++) {
				for (int column = 0; column < board.length; column++) {
					if (board[row][column] == circle) {
						topLeftBlocks = (board[row - 1][column] == block && board[row][column - 1] == block);
						bottomLeftBlocks = (board[row + 1][column] == block && board[row][column - 1] == block);
						topRightBlocks = (board[row - 1][column] == block && board[row][column + 1] == block);
						bottomRightBlocks = (board[row + 1][column] == block && board[row][column + 1] == block);

						if (board[10][10] == circle) {
							win = true;
							break;
						}

						if (topLeftBlocks || bottomLeftBlocks || topRightBlocks || bottomRightBlocks) {
							noMoreMoves = true;
							break;
						}
					}
				}
			}

			// Flags for ending the game
			if (win) {
				System.out.println("Congratulations! You've won the game!");
				gameOn = false;
			}

			if (noMoreMoves) {
				System.out.println("No more moves! Game Over!");
				finalPrint();
				gameOn = false;
			}
		} while (gameOn);

		input.close();
	}

	private static void finalPrint() {
		System.out.println();
		System.out.println("Critical warning message:");
		System.out.println("Krasi only thinks that he can play dota... and he can't even win this game!");
	}

}
