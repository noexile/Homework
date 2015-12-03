import java.util.Scanner;

//	Задача 18:
//	Да се състави програма, чрез която се въвежда две числа от интервала [1..9].
//	Програмата да извежда таблицата за умножение. Максималната стойност на множителите е определена от 2-те числа.
//	Пример: 2 2
//	Изход:
//	1*1= 1;
//	1*2= 2;
//	2*1= 2;
//	2*2= 4;

public class ex18 {

	public static void main(String[] args) {

		byte firstNumber;
		byte secondNumber;
		
		System.out.println("With this example we will enter 2 numbers and print the multiplication table untill the maximum multipliers witch is the numbers that we enter.");
		System.out.println("We can enter only whole numbers - integers. They can be from 1 to 9.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		do {
			System.out.print("Enter the first number: ");
			firstNumber = inputNumber.nextByte();
			System.out.print("Enter the second number: ");
			secondNumber = inputNumber.nextByte();
		} while (firstNumber < 1 || firstNumber > 9 || secondNumber < 1 || secondNumber > 9);
		
		for (byte i = 1; i <= firstNumber; i++) {
			for (byte j = 1; j <= secondNumber; j++) {
				byte result = (byte) (i * j);
				System.out.print(i + " * " + j + " = " + result);
				System.out.println();
			}
		}
		
		
		inputNumber.close();
	}

}
