import java.util.Scanner;

// Задача 7:
// Въведете 3 променливи от клавиатурата – час (целочислен тип), сума
// пари (число с плаваща запетая), дали съм здрав – булев тип.
// Съставете програма, която взема решения на базата на тези данни по
// следния начин:
// - ако съм болен, няма да излизам
// - ако имам пари, ще си купя лекарства
// - ако нямам – ще стоя вкъщи и ще пия чай
// - ако съм здрав, ще отида на кино с приятели
// - ако имам по-малко от 10 лв, ще отида на кафе.
// Полученото решение покажете като съобщение в конзолата.

public class ex7 {
	public static void main(String[] args) {

		byte hour;
		double money;
		boolean isSick;
		boolean hourChecker;
		boolean moneyChecker;

		System.out.println("With this exercise we will check multiple if-else conditions to make a decision based on user input data.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		System.out.println("What hour it is?");
		System.out.print("Please note that you can enter only integer hours between 0 and 23:");
		hour = input.nextByte();
		System.out.print("What amount of money do you have ?");
		money = input.nextDouble();
		System.out.print("Are you sick ? Please enter true / false");
		isSick = input.nextBoolean();

		hourChecker = (hour >= 0 && hour < 24) ? true : false;
		moneyChecker = (money >= 0) ? true : false;

		if (hourChecker && moneyChecker) {
			if (isSick) {
				System.out.println("Sorry to tell you but you are sick!");
				if (money > 0) {
					System.out.println("Thus go buy some medicine!");
				} else {
					System.out.println("And unfortunately you are broke... so go make yourself some tea. Tea always help!");
				}
			} else {
				if (money > 10) {
					System.out.println("To simplify your life - go ease at the cinema!");
				} else {
					System.out.println("Aint got much money? Just go drink coffee with your lazy friends.");
				}
			}
		}
		if (!hourChecker) {
			System.out.println("You probably live in the 4th dimension. Earth time is only between 0 and 23...");
		}
		if (!moneyChecker) {
			System.out.println(
					"I am crossing fingers for you my friend... it really sucks to have nevative ammount of money...");
		}
	}
}
