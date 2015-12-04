import java.util.Scanner;

//	Задача 14:
//	Да се състави програма, която по въведени координати на 2 позиции
//	от шахматната дъска извежда отговор дали са оцветени в еднакъв или различен цвят.
//	Шахматната дъска е квадратна.
//	Въвеждат се две двойки числа от интервала [1..8].
//	Пример: 2 2 3 2
//	Изход: Позициите са с различен цвят

public class ex14 {

	public static void main(String[] args) {
		
		byte firstRow;
		byte firstColumn;
		byte secondRow;
		byte secondColumn;

		boolean firstPickIsWhite;
		boolean secondPickIsWhite;
		boolean firstPickIsBlack;
		boolean secondPickIsBlack;
		boolean rangeChecker;
		
		System.out.println("With this exercise we will check if the entered rows and columns  of a chessborad are with the same color.");
		System.out.println("We can only use whole numbers between 1 and 8");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter first Row: ");
		firstRow = inputNumber.nextByte();
		System.out.print("Enter first Column: ");
		firstColumn = inputNumber.nextByte();
		System.out.print("Enter second Row: ");
		secondRow = inputNumber.nextByte();
		System.out.print("Enter second Column: ");
		secondColumn = inputNumber.nextByte();
		
		rangeChecker = ((firstRow > 0 && firstRow < 9) && (firstColumn > 0 && firstColumn < 9) && (secondRow > 0 && secondRow < 9) && (secondColumn > 0 && secondColumn < 9))? true : false;
		
		firstPickIsWhite = ((firstRow % 2 == 1) && (firstColumn % 2 == 1) || (firstRow % 2 == 0) && (firstColumn % 2 == 0))? true : false;
		secondPickIsWhite = ((secondRow % 2 == 1) && (secondColumn % 2 == 1) || (secondRow % 2 == 0) && (secondColumn % 2 == 0))? true : false;
		firstPickIsBlack = ((firstRow % 2 == 0) && (firstColumn % 2 == 1) || (firstRow % 2 == 1) && (firstColumn % 2 == 0))? true : false;
		secondPickIsBlack = ((secondRow % 2 == 0) && (secondColumn % 2 == 1) || (secondRow % 2 == 1) && (secondColumn % 1 == 0))? true : false;
		
		
		if (rangeChecker) {
			if ((firstPickIsWhite && secondPickIsWhite) || (firstPickIsBlack && secondPickIsBlack)) {
				System.out.println("The positions are with one color.");
			} else {
				System.out.println("The positions are with different color.");
			}
		} else {
			System.out.println("You know... the chessboard has only 8 rows and columns.");
		}
		
		inputNumber.close();
	}

}
