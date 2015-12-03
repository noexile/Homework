import java.util.Scanner;

//	Задача 2:
//	Нека по въведен масив да се конструира нов, като половината му елементи са точно като на оригиналния, а другите да са тези
//	елементи, но в обратен ред. Последно, да се изведе новия масив на екрана.

public class ex2 {

	public static void main(String[] args) {

		int[] arr;
		int[] copyArray;
		int size;
		int originalArrLength = 0;
		
		System.out.println("With this example we will create an array with N elements. Then we will enter the elements in it.");
		System.out.println("The result will be a new printed array with double the size of the elements from the original. The first N numbers will be the same and the second half will be the numbers entered backwards.");
		System.out.println("The array must be bigger than 0.");
		System.out.println();
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter the array size: ");
			size = input.nextInt();
		} while (size < 1);
		
		arr = new int[size];
		copyArray = new int[size*2];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + ( i + 1 ) + " element: ");
			arr[i] = input.nextInt();
		}
		
		for (int i = 0; i < copyArray.length; i++) {
			if (i < arr.length) {
				copyArray[i] = arr[i];
			} else {
				copyArray[i] = arr[arr.length - originalArrLength - 1];
				originalArrLength++;
			}
		}
		
		for (int i = 0; i < copyArray.length; i++) {
			System.out.print(copyArray[i] + " ");
		}
		
		input.close();
	}

}