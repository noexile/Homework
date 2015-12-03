import java.util.Scanner;

//	Задача 25:
//	Да се направи програма, която по дадено число N, да изчислява
//	N!, т.е. 1*2*3*4...*N.
//	Пример: 5
//	Изход: 120
//	Използвайте цикъл do-while.

public class ex25 {

	public static void main(String[] args) {

		int number;
		long sum = 1;
		int counter = 1;
		
		System.out.println("With this example we will enter a number from the keyboard and print the multiplied result of all the numbers from 1 to it.");
		System.out.println("We can use only whole numbers - integers. The number must be bigger than 0.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			number = inputNumber.nextInt();
		} while (number < 1);

		do {
			sum *= counter;
			counter++;
		} while (counter <= number);
		System.out.println(sum);
		
		inputNumber.close();
	}

}
