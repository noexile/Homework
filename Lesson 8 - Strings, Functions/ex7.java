import java.util.Scanner;

//	Задача 7:
//	Да се състави програма, която чете набор от думи разделени с интервал.
//	Като резултат да се извеждат броя на въведените думи, както и броя знаци в най-дългата дума.
//	Пример: asd fg hjkl
//	Изход: 3 думи, най-дългата е с 4 символа.

public class ex7 {

	public static void main(String[] args) {
		
		String text;
		String trimmedText;
		
		int symbolCounter = 0;
		int longestWordSymbolsCounter = 0;
		int wordCounter = 0;
		
		char emptySpace = ' ';
		
		System.out.println("With this exercise we will input a message with seperated words. The program will calculate how much words are enteres.");
		System.out.println("It will print the total number of words as well as how much symbols has the longest word.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter your message: ");
			text = input.nextLine();
			trimmedText = text.trim();
		} while (text.isEmpty() || trimmedText.isEmpty());
			
		// logic goes here ?!? ... you don't say ?
		for (int i = 0; i < text.length(); i++) {
			if ( i == 0 && text.charAt(i) != emptySpace) {
				symbolCounter++;
				wordCounter++;
				longestWordSymbolsCounter++;
			} else if (text.charAt(i) != emptySpace) {
				symbolCounter++;
				
				if (symbolCounter > longestWordSymbolsCounter) {
					longestWordSymbolsCounter = symbolCounter;
				}
				if (text.charAt(i-1) == emptySpace) {
					wordCounter++;
				}
			} else {
				symbolCounter = 0;
			}
		}
		
		System.out.println(wordCounter + " words, the longest is with " + longestWordSymbolsCounter + " symbols.");
		
		input.close();
	}

}