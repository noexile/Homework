import java.util.Scanner;

//	Задача 9:
//	Да се състави програма, чрез която по въведен низ съдържащ букви, цифри, знак минус '-' се извежда сборът на въведените числа 
//	като се отчита знакът '-' пред съответното число.
//	Вход: asd-12sdf45-56asdf100
//	Изход:
//	-12
//	45
//	-56
//	100
//	Сума = 77

public class ex9 {

	public static void main(String[] args) {
		
		String text;
		String trimmedText;
		StringBuilder number = new StringBuilder();
		
		int sum = 0;
		
		System.out.println("With this exercise we will enter a message from the keyboard. It will check if there is numbers in it and print them as well as the sum of them all.");
		System.out.println("We can use only whole numbers - integers for this example. The message cannot be empty.");
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Please enter your message: ");
			text = input.nextLine();
			trimmedText = text.trim();
		} while (text.isEmpty() || trimmedText.isEmpty());
		
		for (int i = 0; i < text.length(); i++) {
			
			if (Character.isDigit(text.charAt(i)) && i == 0) { // checks if the first char is digit
				number.append(text.charAt(i));
			} else if (Character.isDigit(text.charAt(i))) { // checks all other chars if they are digits
				if (text.charAt(i-1) == '-') { // if the previous char is '-' then add it
					number.append(text.charAt(i-1));
				}
				number.append(text.charAt(i));
				
			}
			
			if (i != 0 && Character.isDigit(text.charAt(i-1)) && !Character.isDigit(text.charAt(i))) { // checks if the current char is a digit and the previous are not - converts the StringBuilder to int, adds it to the total sum and prints it
				System.out.println(number);
				sum += Integer.parseInt(number.toString());
				number.setLength(0);
			} else if (Character.isDigit(text.charAt(i)) && i+1 == text.length()) { // checks if the last char is a digit - if yes - converts the StringBuilder to int, adds it to the total sum and prints it
				System.out.println(number);
				sum += Integer.parseInt(number.toString());
				number.setLength(0);
			}
		}
		
		System.out.println("Total sum = " + sum); // prints the final result
		
		input.close();
	}
}
