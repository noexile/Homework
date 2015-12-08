import java.util.Scanner;

// Задача 5:
// Въведете 3 различни числа от конзолата и ги разпечатайте в низходящ ред.

public class ex5 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;

		System.out.println("With this exercise we will print descending the values of two input numbers.");
		System.out.println("The numbers can be doubles but must be between -1000 and 1000.");

		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter value for A: ");
		a = inputNumber.nextDouble();
		System.out.print("Enter value for B: ");
		b = inputNumber.nextDouble();
		System.out.print("Enter value for C: ");
		c = inputNumber.nextDouble();

		boolean rangeChecker = ((a >= -1000 && a <= 1000) && (b >= -1000 && b <= 1000) && (c >= -1000 && c <= 1000)) ? true : false;
		boolean allNumbersDifferenceChecker = (a != b && a != c && b != c)? true : false;
		boolean aIsBiggerThanB = (a > b)? true : false;
		boolean aIsBiggerThanC = (a > c)? true : false;
		boolean bIsBiggerThanA = (b > a)? true : false;
		boolean bIsBiggerThanC = (b > c)? true : false;
		boolean cIsBiggerThanA = (c > a)? true : false;
		boolean aEqualsB = (a == b)? true : false;
		boolean aEqualsC = (a == c)? true : false;
		boolean bEqualsC = (b == c)? true : false;
		boolean aNotEqualsB = (a != b)? true : false;
		boolean aNotEqualsC = (a != c)? true : false;
		
		if (rangeChecker) {
			// checking if all of the numbers are different
			if (allNumbersDifferenceChecker) {
				if (aIsBiggerThanB && aIsBiggerThanC) {
					if (bIsBiggerThanC) {
						System.out.println("a: " + a + " > b: " + b + " > c: " + c);
					} else {
						System.out.println("a: " + a + " > c: " + c + " > b: " + b);
					}
				} else if (bIsBiggerThanA && bIsBiggerThanC) {
					if (aIsBiggerThanC) {
						System.out.println("b: " + b + " > a: " + a + " > c: " + c);
					} else {
						System.out.println("b: " + b + " > c: " + c + " > a: " + a);
					}
				} else {
					if (aIsBiggerThanB) {
						System.out.println("c: " + c + " > a: " + a + " > b:" + b);
					} else {
						System.out.println("c: " + c + " > b: " + b + " > a: " + a);
					}
				}
			} else if (aEqualsB && aNotEqualsC) {
				if (cIsBiggerThanA) {
					System.out.println("a: " + a + " = b: " + b + " < c: " + c);
				} else {
					System.out.println("a: " + a + " = b: " + b + " > c: " + c);
				}
			} else if (bEqualsC && aNotEqualsB) {
				if (aIsBiggerThanB) {
					System.out.println("a: " + a + " > b: " + b + " = c: " + c);
				} else {
					System.out.println("a: " + a + " < b: " + b + " = c: " + c);
				}
			} else if (aEqualsC && aNotEqualsB) {
				if (bIsBiggerThanA) {
					System.out.println("b: " + b + " > a: " + a + " = c:" + c);
				} else {
					System.out.println("b: " + b + " < a: " + a + " = c:" + c);
				}
			} else {
				System.out.println("a: " + a + " = b: " + b + " = c:" + c);
			}
		} else {
			System.out.println("One or more of the numbers you entered are not between -1000 and 1000");
		}

		inputNumber.close();
	}
}
