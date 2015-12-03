import java.util.Scanner;

//	Задача 8:
//	Да се състави програма, чрез която се въвежда ред от символи (стринг, низ).
//	Програмата да изведе на екрана дали въведения стринг е палиндром, т.е. дали четен отляво-надясно и отдясно-наляво е един и същ.
//	Вход: капак
//	Изход: да.
//	Вход: тенджера
//	Изход: не.

public class ex8 {

	public static void main(String[] args) {
		
		String text;
		
		boolean isEqual = true;
		
		System.out.println("With this exercise we will input a word from the keyboard and check if it is a polyndrome.");
		System.out.println("We are not allowed to input empty spaces.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter your word: ");
			text = input.nextLine();
		} while (text.contains(" ") || text.isEmpty());
		
		
		for (int i = 0; i < text.length() / 2; i++) {
			if (!(text.charAt(i) == text.charAt(text.length() - i - 1))) {
				isEqual = false;
				break;
			}
		}
		
		if (isEqual) {
			System.out.println("The entered word: " + text + " is a polyndrome");
		} else {
			System.out.println("The entered word: " + text + " is NOT a polyndrome");
		}
		
		input.close();
	}

}
