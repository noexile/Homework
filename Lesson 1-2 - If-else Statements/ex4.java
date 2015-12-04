import java.util.Scanner;

// Задача 4:
// Въведете 2 различни числа от конзолата и ги разпечатайте в нарастващ ред.


public class ex4 {
	public static void main(String[] args) {
		double a;
		double b;
		
		System.out.println("With this exercise we will print ascending the values of two input numbers.");
		System.out.println("The numbers can be doubles but must be between -1000 and 1000.");
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter value for A: ");
		a = inputNumber.nextDouble();
		System.out.print("Enter value for B: ");
		b = inputNumber.nextDouble();
		
		boolean checker = ((a >= -1000 && a <= 1000) && (b >= -1000 && b <= 1000))? true : false;
		
		if (checker) {
			if (a > b) {
				System.out.println(a + " > " + b);
			} else if (b < a) {
				System.out.println(a + " < " + b);
			} else {
				System.out.println(a + " = " + b);
			}
		} else {
			System.out.println("One or two of the numbers you entered are not between -1000 and 1000");
		}
		
		inputNumber.close();
	}
}
