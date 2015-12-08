import java.util.Scanner;

//	Задача 13:
//	Да се състави програма, която да отгатне колко е студено/топло по въведената температура t в градус Целзий.
//	Температурните интервали са:
//	под -20 ледено студено;
//	между 0 и -20 - студено;
//	между 15 и 0 - хладно;
//	между 25 и 15 - топло;
//	над 25 – горещо.
//	Входни данни: цяло число от интервала [-100..100].
//	Пример: 12
//	Изход: хладно


public class ex13 {

	public static void main(String[] args) {
		
		byte temp;
		
		boolean rangeChecker;

		System.out.println("With this example we will input a temperature and tell you if it is cold or hot.");
		System.out.println("Please note that you can enter double as a value.");
		System.out.println("The entered temperature range can be from -100 to 100 and is calculated in Celsius.");
		System.out.println();
		
		Scanner inputNumber = new Scanner (System.in);
		System.out.print("What is the temperature outside: ");
		temp = inputNumber.nextByte();
		
		rangeChecker = (temp > -101 && temp < 101)? true : false;
		
		if (rangeChecker) {
			System.out.println("The temperature is: ");
			if (temp > 25) {
				System.out.print("hot.");
			} else if (temp >= 15) {
				System.out.print("warm.");
			} else if (temp >= 0) {
				System.out.print("chilly.");
			} else if (temp >= -20) {
				System.out.print("cold.");
			} else {
				System.out.print("freezing. There is a white bear walking down the road ...");
			}
		} else {
			System.out.println("Please enter a temperature between -100 and 100!");
		}
		
		inputNumber.close();
	}
}
