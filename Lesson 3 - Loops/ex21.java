import java.util.Scanner;

//	Задача 21:
//	Дадено е наредено тесте карти.
//	Наредбата по тежест на карта е: 2,3,4,5,6,7,8,9,10, Вале, Дама, Поп, Асо.
//	Наредбата по цвят на картите е: спатия, каро, купа, пика.
//	Да се създаде програма, чрез която се въвежда N - число от
//	интервала [1..51] и се извеждат въведения номер карта и
//	останалите по-големи карти от тестето.
//	Пример: 47.
//	Изход: Поп купа, Поп пика, Асо спатия, Асо каро, Асо купа, Асо пика

public class ex21 {

	public static void main(String[] args) {

		byte number;
		
		System.out.println("With this example we will enter a number from the kyaboard witch represents a card from a deck. After that we will print it and also the other cards bigger than it.");
		System.out.println("We can use only whole numbers - integers. Also as the deck has only 52 cards - we must enter a number between 1 and 52.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			number = inputNumber.nextByte();
		} while (number < 1 || number > 51);
		
		for (byte i = number; i <= 52; i++) {
			switch (i) {
				case 1:
				case 2:
				case 3:
				case 4:
					System.out.print("Two of ");
					break;
				case 5:
				case 6:
				case 7:
				case 8:
					System.out.print("Three of ");
					break;
				case 9:
				case 10:
				case 11:
				case 12:
					System.out.print("Four of ");
					break;
				case 13:
				case 14:
				case 15:
				case 16:
					System.out.print("Five of ");
					break;
				case 17:
				case 18:
				case 19:
				case 20:
					System.out.print("Six of ");
					break;
				case 21:
				case 22:
				case 23:
				case 24:
					System.out.print("Seven of ");
					break;
				case 25:
				case 26:
				case 27:
				case 28:
					System.out.print("Eight of ");
					break;
				case 29:
				case 30:
				case 31:
				case 32:
					System.out.print("Nine of ");
					break;
				case 33:
				case 34:
				case 35:
				case 36:
					System.out.print("Ten of ");
					break;
				case 37:
				case 38:
				case 39:
				case 40:
					System.out.print("Jack of ");
					break;
				case 41:
				case 42:
				case 43:
				case 44:
					System.out.print("Queen of ");
					break;
				case 45:
				case 46:
				case 47:
				case 48:
					System.out.print("King of ");
					break;
				case 49:
				case 50:
				case 51:
				case 52:
					System.out.print("Ace of ");
					break;
				default:
					System.out.println("If you read this - then something really, I mean really really f*cked up :) ... ");
					break;
			}
			for (int j = 0; j < 1; j++) {
				byte colorChecker = (byte) i;
				if (colorChecker % 4 == 1) {
					System.out.print("Clubs");
				} else if (colorChecker % 4 == 2) {
					System.out.print("Diamonds");
				} else if (colorChecker % 4 == 3) {
					System.out.print("Hearts");
				} else {
					System.out.print("Spades");
				}
				if (i != 52) {
					System.out.print(", ");
				} else {
					System.out.print(". ");
				}
			}
		}
		
		inputNumber.close();
	}
}
