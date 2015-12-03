import java.util.Scanner;

//	Задача 13:
//	Да се създаде метод, който приема два масива от числа и връща масив, съдържащ всички елементи на подадените масиви, като в
//	първата част на масива са елементите на първия подаден масив, а във втората част – тези на втория подаден масив.

public class ex13 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		String messageForArrayOne = "Enter the size of the 1st array: ";
		String messageForArraytwo = "Enter the size of the 2nd array: ";
		String messageForElementInputForArrayOne = " element in array 1: ";
		String messageForElementInputForArrayTwo = " element in array 2: ";

		System.out.println("With this exercise we will input 2 array sizes and their element values. The program will then create a new array with both their element values.");
		System.out.println("We can use only whole numbers - integers. The array must be bigger than 0.");
		System.out.println();

		int[] firstArray = createArray(messageForArrayOne, input, messageForElementInputForArrayOne);
		int[] secondArray = createArray(messageForArraytwo, input, messageForElementInputForArrayTwo);

		int[] combinedArray = combineArrays(firstArray, secondArray);
		
		printArray(combinedArray);
		
		input.close();
	}

	private static void printArray(int[] combinedArray) {
		System.out.print("[ ");
		for (int i = 0; i < combinedArray.length; i++) {
			System.out.print(combinedArray[i]);
			if (i < combinedArray.length - 1) {
				System.out.print(", ");
			} else {
				System.out.print(" ]");
			}
		}
		
	}

	static int[] createArray(String messageForArrayOne, Scanner input, String message) {
		
		int[] array;	
		int arrSize = 0;
		String arraySize;
		boolean isNotDigit;
		
		String arrayNumbers;

		do {
			System.out.print(messageForArrayOne);
			arraySize = input.nextLine();
			isNotDigit = false;

			for (int i = 0; i < arraySize.length(); i++) {
				if (!Character.isDigit(arraySize.charAt(i))) {
					isNotDigit = true;
					break;
				}
				if (i == arraySize.length() - 1) {
					arrSize = Integer.parseInt(arraySize);
				}
			}
		} while (arraySize.isEmpty() || arrSize < 1 || isNotDigit);
		
		array = new int[arrSize];

		for (int i = 0; i < arrSize; i++) {
			do {
				System.out.print("Enter the value of " + (i + 1) + message);
				arrayNumbers = input.nextLine();
				isNotDigit = false;
				if (arrayNumbers.isEmpty()) {
					continue;
				}
				
				int j = 0;
				
				if(arrayNumbers.charAt(0) == '-') {
					j = 1;
				} 
				
				for (; j < arrayNumbers.length(); j++) {
					
					if (!Character.isDigit(arrayNumbers.charAt(j))) {
						isNotDigit = true;
						break;
					}
					if (j == arrayNumbers.length() - 1) {
						array[i] = Integer.parseInt(arrayNumbers);
					}
				}

			} while ((arrayNumbers.length() == 1 && arrayNumbers.charAt(0) == '-') || arrayNumbers.isEmpty() || isNotDigit);

		}

		return array;
	}

	static int[] combineArrays(int[] firstArray, int[] secondArray) {

		int counter = 0;

		int[] newArray = new int[firstArray.length + secondArray.length];
		for (int i = 0; i < newArray.length; i++) {
			if (i < firstArray.length) {
				newArray[i] = firstArray[i];
			} else {
				newArray[i] = secondArray[counter];
				counter++;
			}
		}

		return newArray;
	}

}
