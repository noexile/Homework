import java.util.Scanner;

//	Задача 10:
//	Трябва да се напълни цистерна с вода. Имате 2 кофи с вместимост 2 и 3 литра и ги ползвате едновременно.
//	Да се състави програма, която по даден обем извежда как ще прелеете	течността с тези кофи, т.е. по-колко пъти ще се пълни всяка от
//	кофите. Кофите не могат да се ползват с частично количество вода.
//	Входни данни: естествено число от интервала [10..9999].
//	Пример: 107
//	Изход: 21 пъти по 2 литра,
//	21 пъти по 3 литра
//	допълнително кофа от 2 литра

public class ex10 {

	public static void main(String[] args) {
		short number;
		short divisionCounter;
		byte leftoverNumber;

		boolean rangeChecker;

		System.out.println("With this example we will check how much we have to use 2 buckets of 2 lt. and 3 lt. to move a specific amount of water.");
		System.out.println("We can use only whole numbers between 10 and 9999");
		System.out.println();

		Scanner inputNumber = new Scanner(System.in);
		System.out.println("How many liters of water you want to check? ");
		number = inputNumber.nextShort();

		rangeChecker = (number < 10000 && number > 9) ? true : false;

		divisionCounter = (short) (number / 5);
		leftoverNumber = (byte) (number % 5);

		if (rangeChecker) {
			if (leftoverNumber == 1) { // this means that we must consider that we have 1 lt left witch we cannot pour into the 2 lt. and 3 lt. buckets
				divisionCounter -= 1; // divisionCounter = divisionCounter - 1;
			}

			System.out.println((divisionCounter) + " buckets of 2 lt.");
			System.out.println((divisionCounter) + " buckets of 3 lt.");

			if (leftoverNumber == 1) {
				System.out.println("Extra either three buckets of 2 liters or two buckets of 3 liters.");
			}
			
			
			if (leftoverNumber == 2 || leftoverNumber == 4) {
				System.out.println("Extra " + leftoverNumber/2 + " bucket of 2 lt..");
			} 
			
			if (leftoverNumber == 3)	{
				System.out.println("Extra bucket of 3 lt..");
			}
			

		} else {
			System.out.println("Please enter a number between 10 and 9999!");
		}
	}
}
