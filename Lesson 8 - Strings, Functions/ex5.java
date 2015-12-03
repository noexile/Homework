import java.util.Scanner;

//	������ 5:
//	�� �� ������� ��������, ���� ����� �� �������� 2 ������ �� ����� (����).
//	��� � ����� ������ ������� ���� � ���� ����, �� �� ������ �� ������ ������� ������ ������������, � ������� ����������, 
//	���� �� �� �� �������� � ����� �� ����. ��� �������� ����� ��� ���� �� �� ������ ���� ������������ ���������.
//	������ :
//	�
//	�
//	�����
//	�
//	�
//	�

public class ex5 {

	public static void main(String[] args) {
		
		String firstWord;
		String secondWord;
		
		boolean letterMatch = false;
		int letterMatchPosition = 0;
		
		System.out.println("With this exercise we will input 2 words and check if the first letter from the second word matches with one of the first word.");
		System.out.println("Then we will print the first vertically and the second horizontally starting from the matching letter of the first word.");
		System.out.println("Please note that you are allowed to write only 1 word - not using space -> \" \"");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the first word: ");
			firstWord = input.nextLine();
			
			System.out.print("Enter the second word: ");
			secondWord = input.nextLine();
		} while (firstWord.contains(" ") || secondWord.contains(" ") || firstWord.isEmpty() || secondWord.isEmpty());
		
		for (int i = 0; i < firstWord.length(); i++) {
			if (secondWord.charAt(0) == firstWord.charAt(i)) {
				letterMatch = true;
				letterMatchPosition = i;
				break;
			}
		}
		
		if (letterMatch) {
			for (int i = 0; i < firstWord.length(); i++) {
				if (letterMatchPosition != i) {
					System.out.println(firstWord.charAt(i));
				} else {
					System.out.println(secondWord);
				}
			}
		} else {
			System.out.println("You don't have a matching letters!");
		}
		
		
		input.close();
	}

}
