import java.util.Scanner;

//	Задача 6:
//	Да се състави програма, чрез която се въвежда изречение с отделни думи.
//	Като резултат на екрана да се извежда същия текст, но всяка отделна дума да започва с главна буква, а следващите я букви да са малки.
//	Пример: супер яката задача
//	Изход: Супер Яката Задача

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
