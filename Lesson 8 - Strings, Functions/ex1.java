import java.util.Scanner;

//	������ 1:
//	�� �� ������� ��������, ���� ����� �� �������� ��� ���� ��������� �� 40 ������ � ����� �����.
//	���� �������� �� ������ �� �� �������� �������� ���� � ������ � ���� � ����� �����.
//	������: Abcd Efgh
//	�����: ABCD abcd EFGH efgh

public class ex1 {

	public static void main(String[] args) {
		
		String firstText;
		String secondText;
		
		System.out.println("With this exercise we will input from the keyboard 2 messages. The program will then print them as upper case and lower case texts.");
		System.out.println("Please note that the length of each message can be up to 40 symbols. Also note, that everything exept letters will be trimmed and the final result will contain only letters!");
		System.out.println("Last but not least - you can only enter english letters from a to z.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the first display message: ");
			firstText = input.nextLine();
		} while (firstText.length() < 1 || firstText.length() > 40);
		
		do {
			System.out.print("Enter the second display message: ");
			secondText = input.nextLine();
		} while (secondText.length() < 1 || secondText.length() > 40);
		
		// the below regex removes everything exept the english letters
		firstText = firstText.replaceAll("[^a-zA-Z]", "");
		secondText = secondText.replaceAll("[^a-zA-Z]", "");
		
		System.out.print(firstText.toUpperCase() + " ");
		System.out.print(firstText.toLowerCase() + " ");
		System.out.print(secondText.toUpperCase() + " ");
		System.out.print(secondText.toLowerCase());
			
		
		input.close();
	}

}
