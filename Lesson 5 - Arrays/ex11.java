import java.util.Scanner;

//	Задача 11:
//	Да се състави програма, която въвежда от клавиатурата 7 цели числа в едномерен масив
//	Програмата да изведе всички числа кратни на 5, но по големи от 5.
//	Пример: -23, -55, 17, 75, 56, 105, 134
//	Изход: 75,105 - 2 числа

public class ex11 {

	public static void main(String[] args) {

		int[] arr = new int[7];
		byte counter = 0;
		
		System.out.println("For this exercise we will input 7 numbers in an array. The program will check witch of the numbers module divided (5) by 5 = 0 and print those numbers witch are also bigger than 5.");
		System.out.println("We can use only whole numbers - integers.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		// inputs the array values to each element
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arr[i] = input.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 == 0 && arr[i] > 9) {
				counter++;
				if (counter == 1) {
					System.out.print(arr[i]);
				} else {
					System.out.print(", " + arr[i]);
				}
				
			}
		}
		
		if (counter == 0) {
			System.out.println("There are no numbers that can be divided by 5 and bigger than 5 in this array");
		} else if (counter == 1){
			System.out.println(" - " + counter + " number");
		} else {
			System.out.println(" - " + counter + " numbers");
		}
		
		input.close();
	}

}
