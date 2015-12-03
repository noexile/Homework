import java.util.Scanner;

//	Задача 13:
//	Да се състави програма, чрез която се въвежда число и се представя като число в двоична бройна система.
//	Програмата, чрез масив, да изчислява последователно всички цифри на въведеното естествено число в 2-ична бройна система.
//	Пример: 99
//	Изход: 1100011

public class ex13 {

	public static void main(String[] args) {

		int number;
		int tens = 1;
		int division = 1;
		int result = 0;
		int counter = 0;
		int[] arr;

		System.out.println("With this exercise we will input a number from the keyboard. Then the program will calculate its binary representative and add the digits into array.");
		System.out.println("In the end we will print the number as a binary code from the new array.");
		System.out.println("We can use whole numbers for this example. The number must be bigger than 0.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Enter a number: ");
			number = input.nextInt();
		} while (number < 1);
		

		while ( number > 0) {
			int bit = number % 2;
			number = number / 2;
			result = result + (bit * tens);
			tens = tens * 10;
			counter++;
		}
		
		tens = 1;
		arr = new int[counter];
				
		for (int i = arr.length - 1; i >= 0; i--) {
			tens = tens * 10;
			arr[i] = (result % tens) / division;
			division = division * 10;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		input.close();
	}

}
