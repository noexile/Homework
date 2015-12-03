import java.util.Scanner;

//	������ 6:
//	�� �� ������� ��������, ���� ����� �� ������� ��������� � ������� ����.
//	���� �������� �� ������ �� �� ������� ����� �����, �� ����� ������� ���� �� ������� � ������ �����, � ���������� � ����� �� �� �����.
//	������: ����� ����� ������
//	�����: ����� ����� ������

public class ex6 {

	public static void main(String[] args) {
		
		String text;
		String trimmedText;
		
		System.out.println("With this exercise we will input a text from the keyboard. The program will print the this text with all the first letters of each word capitilised.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter your text: ");
			text = input.nextLine();
			trimmedText = text.trim();
		} while (text.isEmpty() || trimmedText.isEmpty());
		
		
		for (int i = 0; i < text.length(); i++) {
			if (i == 0 || text.charAt(i-1) == ' ') {
				System.out.print(text.toUpperCase().charAt(i));
			} else {
				System.out.print(text.charAt(i));
			}
		}
		
		input.close();
	}

}
