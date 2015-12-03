import java.util.Scanner;

public class ex26 {

	public static void main(String[] args) {
		byte number;
		
		System.out.println("With this example we will enter a number from the keyboard and print X + X with the height of the input number.");
		System.out.println("We can enter only whole numbers - integers. The number can be from 3 to 99");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			number = inputNumber.nextByte();
		} while (number < 3 || number > 99 || number % 2 == 0);

		for (int row = 0; row < number; row++) {

			for (int col = 1; col <= number; col++) {
				if (col == row + 1 || col == number - row) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			
			for (int i = 0; i < 2; i++) {
				System.out.print(" ");
			}

			for (int col = 0; col < number; col++) {
				if (col == (number / 2) || row == (number / 2)) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}

			for (int i = 0; i < 2; i++) {
				System.out.print(" ");
			}
			
			for (int col = 1; col <= number; col++) {
				if (col == row + 1 || col == number - row) {
					System.out.print("*");
				} else
					System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Krasi e slab na Dota 2 !!!");
		
		inputNumber.close();
	}

}
