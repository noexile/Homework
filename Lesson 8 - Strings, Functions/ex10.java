import java.util.Scanner;

//	Задача 10:
//	Да се състави програма, която по даден низ връща друг, символите, на който са получени като към всеки код на символ
//	от ASCII таблицата е добавеното числото 5 и е записан новополучения символ.
//	Пример :
//	Вход: Hello
//	Изход: Mjqqt

public class ex10 {

	public static void main(String[] args) {
		
		String text;
		String trimmedText;
		StringBuilder newText = new StringBuilder();
		
		System.out.println("With this exercise we will input text from the keyboard and then increace the character values by 5 from the ASCII table.");
		System.out.println("The program will print the result.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter your message: ");
			text = input.nextLine();
			trimmedText = text.trim();
		} while (text.isEmpty() || trimmedText.isEmpty());
		
		
		for (int i = 0; i < text.length(); i++) {
			newText.append((char)(text.charAt(i)+5));
		}
		
		System.out.println(newText);
		
		input.close();
	}

}
