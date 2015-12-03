import java.util.Scanner;

//	Задача 7:
//	Напишете програма, която първо чете масив и после създава нов масив със същия размер по следния начин: 
//	стойността на всеки елемент от втория масив да е равна на сбора от предходния и следващият елемент на съответния елемент от първия масив. 
//	Първият и последният елемент на втория масив трябва да си останат равни на първият и последният от елемент от първия масив.
//	Да се изведе получения масив.

public class ex7 {

	public static void main(String[] args) {

		int[] arr;
		int[] copyArr;
		int arrSize;
		
		System.out.println("With this exercise we will create an array and input its elements. Then a second array will be created and it will copy the 1st and last element's values.");
		System.out.println("All other numbers in between will be the sum of the original array's previous and next value.");
		System.out.println("We can use only whole numbers - integers. The array must be bigger than 0.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter the array size: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);
		
		arr = new int[arrSize];
		copyArr = new int[arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + (i+1) + " element: ");
			arr[i] = input.nextInt();
		}
		
		if (arrSize == 1) {
			System.out.println("The second array looks like this: { " + arr[0] + " }");
		} else if (arrSize == 2) {
			System.out.println("The second array looks like this: { " + arr[0] + ", " + arr[1] + " }");
		} else {
			copyArr[0] = arr[0];
			copyArr[arr.length - 1] = arr[arr.length - 1];
			for (int i = 1; i < copyArr.length - 1; i++) {
				copyArr[i] = arr[i-1] + arr[i+1];
			}
			
			System.out.print("{ ");
			for (int i = 0; i < copyArr.length; i++) {
				System.out.print(copyArr[i]);
				if (i < copyArr.length - 1) {
					System.out.print(", ");
				} else {
					System.out.print(" }");
				}
			}
		}
		
		
		input.close();
	}

}
