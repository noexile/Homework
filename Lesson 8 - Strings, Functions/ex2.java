import java.util.Scanner;

//	Задача 2:
//	Да се състави програма, чрез която от клавиатурата се въвеждат последователно две думи с дължина 10-20 знака.
//	Програмата да размени първите им 5 знака и да изведе дължината на по-дългата, както и новото им съдържание.
//	Пример: uchilishe uchenik
//	Изход: 9 uchenishe

public class ex2 {

	public static void main(String[] args) {
		
		String firstText;
		String secondText;
		String longText;
		String shortText;
		StringBuilder displayText = new StringBuilder("");
		
		int biggestText;
		
		System.out.println("With this exercise we will input 2 words from the keyboard. The program will then check witch is the longest one. It will also print the first 5 letters from the short word and make them the first 5 letters of the long one with the rest of the long word's characters.");
		System.out.println("Pelase note that the words must be at least 5 letters short. You can input every characters and digits you want and also empty space.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the first display message: ");
			firstText = input.nextLine();
		} while (firstText.length() < 5 || firstText.length() > 20);
		
		do {
			System.out.print("Enter the second display message: ");
			secondText = input.nextLine();
		} while (secondText.length() < 5 || secondText.length() > 20);
		
		boolean textLengthEquals = (firstText.length() == secondText.length());
		
		if (firstText.length() > secondText.length()) {
			biggestText = firstText.length();
			longText = firstText;
			shortText = secondText;
		} else {
			biggestText = secondText.length();
			shortText = firstText;
			longText = secondText;
		}
		
		if (!textLengthEquals) {
			for (int i = 0; i < biggestText; i++) {
				if (i < 5) {
					displayText.append(shortText.charAt(i));
				} else {
					displayText.append(longText.charAt(i));
				}
			}
		} else {
			System.out.println("Both messages have equal text length.");
		}
		
		System.out.print(displayText.length() + " " + displayText);
		
		input.close();
	}

}
