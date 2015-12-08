import java.util.Scanner;

//	Задача 15:
//	Да се състави програма, която въвежда естествено число от интервала [0..24].
//	Програмата да изведе съответстващо съобщение съобразно въведения час.
//	Периодите са:
//	[18..4] - Добър вечер;
//	[4..9] - Добро утро;
//	[9..18] - Добър ден
//	Пример: 10
//	Изход: Добър ден

public class ex15 {
	public static void main(String[] args) {
		byte time;
		
		boolean rangeChecker;
		
		System.out.println("With this example we will input a hour and the program will tell us what is the proper addressing is.");
		System.out.println("We can use only whole numbers. The time format is from 0 to 23h.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("What time it is: ");
		time = inputNumber.nextByte();
		
		rangeChecker = ((time > -1) && (time < 24))? true : false;
		
		if (rangeChecker) {
			if (time > 17 && time < 24 || time > 01 && time < 4) { // making correction here because if the time is 4, by the exercise condition we will have in the same time output as: "Good evening" and "Good morning"
				System.out.println("Good evening");
			} else if (time > 3 && time < 10) { // making correction here because if the time is 4, by the exercise condition we will have in the same time output as: "Good morning" and "Good afternoon"
				System.out.println("Good morning");
			} else {
				System.out.println("Good afternoon");
			}
		} else {
			System.out.println("The time cannot be: " + time + " h.");
		}
		
		inputNumber.close();
	}

}
