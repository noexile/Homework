import java.util.Scanner;

//	Задача 12:
//	Да се създаде метод, който приема за входни данни число N и връща масив от числа с дължина N, който съдържа всички числа от 1 до N.

public class ex12 {

	public static void main(String[] args) {
		
		int number = 0;
		String arraySize;
		boolean isNotDigit;
		
		System.out.println("This exercise will use a method in order to print numbers from 1 to N.");
		System.out.println("You can use only whole numbers to choose the array size. Please note that the size of the array must be bigger than 0.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the array's size: ");
			arraySize = input.nextLine();
			isNotDigit = false;
			
			for (int i = 0; i < arraySize.length(); i++) {
				if (!Character.isDigit(arraySize.charAt(i))) {
					isNotDigit = true;
					break;
				} 
				if (i == arraySize.length() - 1) {
					number = Integer.parseInt(arraySize);
				}
			}
			
		} while (number < 1 || isNotDigit);
		
		printArray(number);		
		
		input.close();
	}

	static void printArray(int number) {
		
		int[] arr = new int[number];
		
		for (int i = 1; i <= arr.length; i++) {
			arr[i-1] = i;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
	}

}
