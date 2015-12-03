import java.util.Scanner;

//	Задача 6:
//	Напишете програма, която първо чете 2 масива и после извежда съобщение дали са еднакви, и дали са с еднакъв размер.

public class ex6 {

	public static void main(String[] args) {
		int[] arrOne;
		int[] arrTwo;
		int arrSize;

		boolean areEqual = true;

		System.out.println("With this example we will input 2 array lengts and elements and then check if they are equal.");
		System.out.println("We can use only whole numbers - integers. The arrays' sizes must be bigger than 0.");
		System.out.println();
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter the size of the first Array: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);

		arrOne = new int[arrSize];

		for (int i = 0; i < arrOne.length; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arrOne[i] = input.nextInt();
		}

		System.out.println();
		do {
			System.out.print("Enter the size of the second Array: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);

		arrTwo = new int[arrSize];

		for (int i = 0; i < arrTwo.length; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arrTwo[i] = input.nextInt();
		}

		if (arrOne.length == arrTwo.length) {
			for (int i = 0; i < arrOne.length; i++) {
				if (arrOne[i] != arrTwo[i]) {
					areEqual = false;
					break;
				}
			}
			if (areEqual) {
				System.out.println("The arrays are equal both size and elements.");
			} else {
				System.out.println("The arrays have equal lengths but their elements are NOT equal.");
			}
		} else {
			System.out.println("The arrays have different lengths and therefore are NOT equal.");
		}

		input.close();
	}

}
