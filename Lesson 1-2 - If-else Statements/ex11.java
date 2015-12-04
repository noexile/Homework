import java.util.Scanner;

//	Задача 11:
//	Съставете програма, която по дадено трицифренo число проверява
//	дали числото се дели на всяка своя цифра. Във въведеното число да няма цифра 0.

public class ex11 {

	public static void main(String[] args) {
		
		short number;
		byte firstDigit;
		byte secondDigit;
		byte thirdDigit;
		

		System.out.println("With this example we will check if a number can be devided with every of its digits. It can not have a 0 /zero/ digit.");
		System.out.println("You can enter inly whole numbers - integers! Please input a number between 100 and 999.");
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter your number: ");
		number = inputNumber.nextShort();
		
		boolean rangeChecker = ((number > 99) && (number < 1000))? true : false;
		
		if (rangeChecker) {
			firstDigit = (byte) (number / 100);
			secondDigit = (byte) (number % 100);
			secondDigit /= 10; // secondDigit = secondDigit / 10;
			thirdDigit = (byte) (number % 10);
			
			boolean zeroChecker = ((firstDigit != 0) && (secondDigit != 0) && (thirdDigit != 0))? true : false;
			boolean divisionChecker = (((number % firstDigit) == 0) && ((number % secondDigit) == 0) && ((number % firstDigit) == 0))? true : false;
			
			if (zeroChecker) {
				if (divisionChecker) {
					System.out.println("Your number: " + number + " can be divided with to all of its digits: " + firstDigit + ", " + secondDigit + " and " + thirdDigit);
				} else {
					System.out.println("your number: " + number + " can NOT be divided with to all of its digits: " + firstDigit + ", " + secondDigit + " and " + thirdDigit);
				}
			} else {
				System.out.println("Your number contains 0 in it and we cannot divide with zero.");
				System.out.println("Now go to your math teacher in elementary school and attend his classes again!");
			}
		} else {
			System.out.println("As not following the instructions of entering a number between 100 and 999... we infected your system with a virus who will cause your hdd to melt in:");
			System.out.println("3");
			System.out.println("2");
			System.out.println("1");
			System.out.println("bye bye");
		}
		
		inputNumber.close();
	}

}
