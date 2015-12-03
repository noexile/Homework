import java.util.Scanner;

//	Задача 4:
//	Да се състави програма, чрез която по въведени трите имена на двама човека разделени със запетая, 
//	се извежда чие име има по-голям сбор от ASCII кодовете на съставящите името букви.
//	Пример: Anna Dosewa Asenowa, Iwo Peew Peew
//	Изход: Anna Dosewa Asenowa

public class ex4 {

	public static void main(String[] args) {
		
		String text;
		
		StringBuilder firstName = new StringBuilder();
		StringBuilder secondName = new StringBuilder();
		
		int seperatorCounter = 0;
		int firstNameASCIISum = 0;
		int secondNameASCIISum = 0;
		boolean seperatorFounder = true;
		
		System.out.println("With this exercise we will input 2 names from the keyboard and check witch one has bigger ASCII sum of its letters. Then the program will print this name.");
		System.out.println("Please note that you must seperate the names with \",\"");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			seperatorCounter = 0;
			System.out.print("Input the names: ");
			text = input.nextLine();
			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == ',') {
					seperatorCounter++;
				}
			}
		} while (seperatorCounter != 1);
		
		
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ',') {
				seperatorFounder = false;
				continue;
			}
			if (seperatorFounder) {
				firstName.append(text.charAt(i));
			} else {
				secondName.append(text.charAt(i));
			}
		}
		
		// sums the ASCII values of the words while skipping the empty spaces
		for (int i = 0; i < firstName.length(); i++) {
			if (firstName.charAt(i) == ' ') {
				continue;
			} else {
				firstNameASCIISum += firstName.charAt(i);
			}
				
		}
		for (int i = 0; i < secondName.length(); i++) {
			if (secondName.charAt(i) == ' ') {
				continue;
			} else {
				secondNameASCIISum += secondName.charAt(i);
			}
		}
		
		if (firstNameASCIISum == secondNameASCIISum) {
			System.out.println("Both names have equal ASCII sum.");
		} else if (firstNameASCIISum > secondNameASCIISum) {
			System.out.println(firstName);
		} else {
			System.out.println(secondName);
		}
		
		input.close();
	}

}

