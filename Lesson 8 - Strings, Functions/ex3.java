import java.util.Scanner;

//	Задача 3:
//	Да се състави програма, чрез която се въвеждат последователно две редици от символи без интервали.
//	Програмата да извежда съобщение за резултата от сравнението им по позиции.
//	Пример: хипопотам, хипопотук
//	Изход:
//	Двата низа са с равна дължина.
//	Разлика по позиции:
//	8 а-у
//	9 м-к

public class ex3 {

	public static void main(String[] args) {

		String firstMessage;
		String secondMessage;
		
		boolean haveEqualLength;
		
		int sortedMessage;
		
		System.out.println("With this example we will input 2 messages from the keyboard. Then the program will check their lengths and print witch is bigger of if they are equal.");
		System.out.println("It will also print the different index elements. Please note that you cannot enter empty message or such with spaces in it.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter the first message: ");
			firstMessage = input.nextLine();
		} while (firstMessage.isEmpty() || firstMessage.contains(" "));

		do {
			System.out.print("Enter the second message: ");
			secondMessage = input.nextLine();
		} while (secondMessage.isEmpty() || firstMessage.contains(" "));
		
		haveEqualLength = (firstMessage.length() == secondMessage.length());
		
		if (haveEqualLength) {
			System.out.println("Both messages have equal length");
		} else {
			if (firstMessage.length() > secondMessage.length()) {
				System.out.println("The first message is longer than the second one.");
			} else {
				System.out.println("The second message is longer than the first one.");
			}
		}
		
		sortedMessage = (firstMessage.length() < secondMessage.length()? firstMessage.length() : secondMessage.length());
		
		for (int i = 0; i < sortedMessage; i++) {
			if (firstMessage.charAt(i) != secondMessage.charAt(i)) {
				System.out.println((i+1) + " " + firstMessage.charAt(i) + "-" + secondMessage.charAt(i));
			}
		}
		
		input.close();
	}

}
