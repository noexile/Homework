import java.util.Scanner;

//	Задача 19: Да се състави програма, чрез която по въведено естествено число от интервала [10..99] се извежда поредица числа, 
//	при спазване на следните изисквания:
//	1) ако предходното число е четно се извежда 0.5*числото;
//	2) ако предходното число е нечетно се извежда 3*числото +1.
//	Извеждането продължава докато не се получи стойност 1.
//	Пример: 11
//	Изход: 34 17 52 26 13 40 20 10 5 16 8 4 2 1.

public class ex19 {

	public static void main(String[] args) {

		short number;
		
		System.out.println("With this example we will enter a umber and then make some calculations with it.");
		System.out.println("If the previous number is even - then we multiply 0.5 * our number. If the number is odd - then we multiply 3 * our number and also add 1.");
		System.out.println("The program ends when the final result reaches 1.");
		System.out.println("We have to use a whole number - integer. It have to be in the range of 1 to 99.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the number: ");
			number = inputNumber.nextShort();
		} while (number < 1 || number > 99);
		
		
		while (number != 1) {
			if (number % 2 == 0) {
				number *= 0.5;
			} else {
				number *= 3;
				number++;
			}
			System.out.print(number + " ");
		}
		
		inputNumber.close();
	}

}
