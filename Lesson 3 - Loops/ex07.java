import java.util.Scanner;

//	Задача 7: Започвайки от 3, да се изведат на екрана първите n 
//	числа които се делят на 3. Числата да са разделени със запетая.

public class ex07 {

	public static void main(String[] args) {
		
		short number = 0;
		
		System.out.println("With this example we will enter a number and print all of the numbers that are between it and 3 and also can be divided by 3.");
		System.out.println("You can enter only a while number - ineger. You can enter a number between 3 and 10 000.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			number = inputNumber.nextShort();
		} while (number < 3 || number > 10_000);
		
		for (int i = 3; i <= number; i++) {
			if (i % 3 == 0) {
				System.out.print(i);
			}
			if ((i % 3 == 0) && (i+2 < number || i + 3 < number)) {
				System.out.print(", ");
			}
		}
		
		inputNumber.close();
	}

}
