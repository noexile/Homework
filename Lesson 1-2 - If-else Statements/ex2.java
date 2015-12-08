import java.util.Scanner;

// Задача 2:
// Въведете 2 различни целочислени числа от конзолата. Запишете
// тяхната сума, разлика, произведение, остатък от деление и
// целочислено деление в отделни променливи и разпечатайте тези
// резултати в конзолата. Опитайте същото с числа с плаваща запетая.

public class ex2 {

	public static void main(String[] args) {
		int a;
		int b;
		
		int collect;
		int draw;
		int multiply;
		int devideWithRemnant;
		int devideWithoutRemnant;
		
		System.out.println("With this exercise we will collect, draw, multiply, divide with and without remnant 2 numbers.");
		System.out.println("The numbers must be integers and be between -1000 and 1000.");

		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Input number A: ");
		a = inputNumber.nextInt();
		System.out.print("Input number B: ");
		b = inputNumber.nextInt();
		
		if ((a >= -1000 && a <= 1000) && (b >= -1000 && b <= 1000)) {
			collect = a + b;
			draw = a - b;
			multiply = a * b;
			System.out.println(a + " + " + b + " = " + collect);
			System.out.println(a + " - " + b + " = " + draw);
			System.out.println(a + " * " + b + " = " + multiply);
			
			if (b == 0) {
				System.out.println("You can NOT divide by 0.");
			} else {
				devideWithRemnant = a % b;
				devideWithoutRemnant = a / b;
				System.out.println(a + " % " + b + " = " + devideWithRemnant);
				System.out.println(a + " / " + b + " = " + devideWithoutRemnant);
			}
		} else {
			System.out.println("One or two of the numbers you entered are not between -1000 and 1000");
		}
		
		
/* ----------------- double example ----------------- */
		
//		double a;
//		double b;
//		
//		double collect;
//		double draw;
//		double multiply;
//		double devideWithRemnant;
//		double devideWithoutRemnant;
//		
//		System.out.println("With this exercise we will collect, draw, multiply, divide with and without remnant 2 numbers.");
//		System.out.println("The numbers must be integers and be between -1000 and 1000.");
//
//		Scanner inputNumber = new Scanner(System.in);
//		System.out.print("Input number A: ");
//		a = inputNumber.nextDouble();
//		System.out.print("Input number B: ");
//		b = inputNumber.nextDouble();
//		
//		if (a >= -1000 && a <= 1000) {
//			collect = a + b;
//			draw = a - b;
//			multiply = a * b;
//			System.out.println(a + " + " + b + " = " + collect);
//			System.out.println(a + " - " + b + " = " + draw);
//			System.out.println(a + " * " + b + " = " + multiply);
//			
//			if (b == 0) {
//				System.out.println("You can NOT divide by 0.");
//			} else {
//				devideWithRemnant = a % b;
//				devideWithoutRemnant = a / b;
//				System.out.println(a + " % " + b + " = " + devideWithRemnant);
//				System.out.println(a + " / " + b + " = " + devideWithoutRemnant);
//			}
//		} else {
//			System.out.println("One or two of the numbers you entered are not between -1000 and 1000");
//		}

		inputNumber.close();
	}
}
