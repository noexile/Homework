import java.util.Scanner;

//	������ 3:
//	�� �� ������ �����, ���� ����� �� �� ������� ����� � 10 �������� �� ������� �����:
//	������� 2 �������� �� ������ �� ���������� �����.
//	����� ������� ������� �� ������ � ����� �� ����� �� ���������� 2 �������� � ������.
//	���� ���� �������� ������.

public class ex3 {

	public static void main(String[] args) {
	
		int[] arr = new int[10];
		int starterNumbers;
		
		System.out.println("With this example we will enter a number. Then we will print an array with 10 elements with the first two numbers = the input number. Each next numbers will be the sum of the previous ones.");
		System.out.println("The input numbers must be whole numbers - integers.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		starterNumbers = input.nextInt();
		
		arr[0] = starterNumbers;
		arr[1] = starterNumbers;
		
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		
		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");				
			} else {
				System.out.print(" }");	
			}
		}
				
		input.close();
	}

}
