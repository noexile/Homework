import java.util.Scanner;

//	Задача 18:
//	Дадени са два едномерни масива с естествени числа.
//	Да се състави програма, която сравнява всички числа с еднакви индекси от двата масива и записва в трети масив, по-голямото от двете числа.
//	Да се изведе съдържанието и на трите масива
//	Пример:
//	18,19,32,1,3, 4, 5, 6, 7, 8
//	1, 2, 3,4,5,16,17,18,27,11
//	Изход:
//	18,19,32 ,4,5,16,17,18,27,11

public class ex18 {

	public static void main(String[] args) {
		int[] arrOne;
		int[] arrTwo;
		int[] arrThree;
		int arrSize;
		
		System.out.print("With this exercise we will enter 2 arrays and their element values. Then the program will compare the values in every equal cell number from the 2 arrays and put the biggest one into a third array. The new array will be printed.");
		System.out.println("For this example we can use only whole numbers - integers. The arrays must be bigger than 0.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the size of the 1st array: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);
		
		arrOne = new int[arrSize];
		
		for (int i = 0; i < arrOne.length; i++) {
			System.out.print("Enter " + (i+1) + " element's value of the 1st array: ");
			arrOne[i] = input.nextInt();
		}
		
		do {
			System.out.print("Enter the size of the 2nd array: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);
		
		arrTwo = new int[arrSize];
		
		for (int i = 0; i < arrTwo.length; i++) {
			System.out.print("Enter " + (i+1) + " element's value of the 2nd array: ");
			arrTwo[i] = input.nextInt();
		}
		
		if (arrOne.length > arrTwo.length) {
			arrThree = new int[arrTwo.length];
		} else {
			arrThree = new int[arrOne.length];
		}
		
		for (int i = 0; i < arrThree.length; i++) {
			if (arrOne[i] > arrTwo[i]) {
				arrThree[i] = arrOne[i];
			} else {
				arrThree[i] = arrTwo[i];
			}
		}
		
		for (int i = 0; i < arrThree.length; i++) {
			System.out.print(arrThree[i]);
			if (i < arrThree.length - 1) {
				System.out.print(", ");
			}
		}
		
		input.close();
	}

}
