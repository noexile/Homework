import java.util.Scanner;

//	Задача 22:
//	Да се състави програма, която извежда първите 10 най-малки числа, 
//	които се делят на 2, 3 или на 5 и които са по-големи от въведено естествено число.
//	Числата се извеждат, заедно с техния пореден номер.
//	Входни данни: число от интервала [1..999]
//	Пример: 1
//	Изход: 1:2; 2:3, 3:4, 4:5, 5:6, 6:8, 7:9, 8:10, 9:12, 10:14
//	Използвайте цикъл while.

public class ex22 {

	public static void main(String[] args) {

		short number;
		byte counter = 1;
		
		boolean infinity = true;
		
		System.out.println("With this example we will input a number and after that print the next 10 numbers that are divided by2, 3 or 5.");
		System.out.println("We can use only whole numbers - integers. The range of the input number is from 1 to 999.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			number = inputNumber.nextShort();
		} while (number < 1 || number > 999);
		
		while (infinity) {
			if ((number+1) % 2 == 0 || (number+1) % 3 == 0 || (number+1) % 5 == 0) {
				System.out.print(counter + ":" + (number+1));
				counter++;
			}
			if (counter <= 10 && ((number+1) % 2 == 0 || (number+1) % 3 == 0 || (number+1) % 5 == 0)) {
				System.out.print(", ");
			} 
			if (counter == 11) {
				infinity = false;
			}
			number++;
		}
		
		inputNumber.close();
	}

}
