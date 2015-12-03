import java.util.Scanner;

//	Задача 11:
//	Да се създаде метод, който отпечатва масив в конзолата.

public class ex11 {

	public static void main(String[] args) {
		
		int[] arr;
		String arraySize;
		String inputDigit;
		int arrSize = 0;
				
		boolean isNotDigit;
		
		System.out.println("This exercise will use a method in order to print an array. Please enter the array size and element values.");
		System.out.println("You can use only whole numbers - integers. Please note that the size of the array must be bigger than 0.");
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
					arrSize = Integer.parseInt(arraySize);
				}
			}
			
		} while (arrSize < 1 || arraySize.isEmpty() || isNotDigit);
		
		
		arr = new int[arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			do {
				System.out.print("Enter the value of " + (i+1) + " element: ");
				inputDigit = input.nextLine();
				isNotDigit = false;
				
				for (int j = 0; j < inputDigit.length(); j++) {
					if(j == 0 && inputDigit.charAt(j) == '-') {
						continue;
					}
					if(!Character.isDigit(inputDigit.charAt(j))) {
						isNotDigit = true;
						break;
					}
					if(j == inputDigit.length() - 1) {
						arr[i] = Integer.parseInt(inputDigit);
					}
				}
				
			} while ((inputDigit.length() == 1 && inputDigit.charAt(0) == '-') || inputDigit.isEmpty() || isNotDigit);
			
		}
		
		printArray(arr);
		
		input.close();
	}

	static void printArray(int[] arr) {
		
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			} else {
				System.out.print(" ]");
			}
		}
	}
}