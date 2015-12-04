import java.util.Scanner;

// ������ 1:
// �� �� ������� ��������� ��� ����������� � �� �� �������� 2 ����� ��
// ������������ A � B (���� �� �� � ������� ������� � double).
// ����� �� �� ������� 3-�� ����� C � �� �� ������� ���� �� � �/� A � B.
// �� �� ������ ��������� ��������� �� ���� ���� C � ����� A � B.

public class ex1 {

	public static void main(String[] args) {
		double a;
		double b;
		double c;

		System.out.println("With this exercise we will check if the input number C is between the range of numbers A and B.");
		System.out.println("The number can be double.");

		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter number A: ");
		a = inputNumber.nextDouble();
		System.out.print("Enter number B: ");
		b = inputNumber.nextDouble();
		System.out.print("Enter number C: ");
		c = inputNumber.nextDouble();

		boolean equalityCheckerForNumberA;
		boolean equalityCheckerForNumberB;
		boolean equalityCheckerForNumberAAndB;

		equalityCheckerForNumberA = !(c == a) ? true : false;
		equalityCheckerForNumberB = !(c == b) ? true : false;
		equalityCheckerForNumberAAndB = (c == b && c == a) ? true : false;
		
		if (equalityCheckerForNumberA && equalityCheckerForNumberB) {
			if (a < b) {
				if (c > a && c < b) {
					System.out.println("Number " + c + " is between " + a + " and " + b);
				} else {
					System.out.println("Number " + c + " is NOT between " + a + " and " + b);
				}
			} else { // a > b
				if (c > b && c < a) {
					System.out.println("Number " + c + " is between " + a + " and " + b);
				} else {
					System.out.println("Number " + c + " is NOT between " + a + " and " + b);
				}
			}
			
		} else if (equalityCheckerForNumberAAndB) {
			System.out.println("The numbers are equal -> A: " + a + " = B: " + b + " = C: " + c);
		} else {
			if (equalityCheckerForNumberA == true) {
				System.out.println("Number B: " + b + " = Number C: " + c);
			} else {
				System.out.println("Number A: " + a + " = Number C: " + c);
			}

		}
		inputNumber.close();
	}

}
