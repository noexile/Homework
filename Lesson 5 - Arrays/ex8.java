import java.util.Scanner;

//	Задача 8:
//	Напишете програма, която намира и извежда най-дългата редица от еднакви поредни елементи в даден масив.

public class ex8 {

	public static void main(String[] args) {

		int[] arr;
		int arrSize;
		
		System.out.println("With this exercise we will input an array and his elements. The program will print the longest equal row of values.");
		System.out.println("We can use whole numbers - integers. The array must be bigger than 0.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the array size: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);
			
		arr = new int[arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + (i+1) + " element: ");
			arr[i] = input.nextInt();
		}
		
		int counter = 1;
		int printedNumberCounter = 1;
		int theNumber = arr[0];
		int printedNumber = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				counter++;
				theNumber = arr[i];
				if (counter >= printedNumberCounter) {
					printedNumber = theNumber;
					printedNumberCounter = counter;
				}
			} else {
				counter = 1;
			}
		}

		for (int i = 0; i < printedNumberCounter; i++) {
			System.out.print(printedNumber);
			if (i < printedNumberCounter - 1) {
				System.out.print(", ");
			}
		}
		
		input.close();
	}
}
