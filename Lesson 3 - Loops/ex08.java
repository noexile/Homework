import java.util.Scanner;

//	Задача 8: По зададено число n, да се изведе на екрана таблица по следния начин:
//
//	Въведете n:		Въведете n:		Въведете n:		Въведете n:
//	1				2				3				4
//	0				11				222				3333
//					33				444				5555
//									666				7777
//													9999
												
public class ex08 {

	public static void main(String[] args) {

		int loopRange = 0;
		int number;
		
		System.out.println("With this example we will input a number from the keyboard and write a square of numbers.");
		System.out.println("We can enter a whole number - integer. The number have to be bigger than 0.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			loopRange = inputNumber.nextInt();
		} while (loopRange < 1);
		
		number = loopRange - 1;
		
		for (int i = 0; i < loopRange; i++) {
			for (int j = 0; j < loopRange; j++) {
				System.out.print(number);
			}
			number += 2;
			System.out.println();
		}
		
		
		inputNumber.close();
	}

}
