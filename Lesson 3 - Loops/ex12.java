
//	Задача 12: Да се състави програма, която извежда всички естествени трицифрени числа, 
//	които нямат еднакви цифри т.е. 100,101, 606 и т.н. не се извеждат.

public class ex12 {

	public static void main(String[] args) {
		
		short firstDigit;
		short secondDigit;
		short thirdDigit;

		for (short i = 100; i < 1000; i++) {
			firstDigit = (short) (i / 100);
			secondDigit = (short) (i / 10);
			secondDigit %= 10;
			thirdDigit = (short) (i % 10);
			
			if (firstDigit != secondDigit && firstDigit != thirdDigit && secondDigit != thirdDigit) {
				System.out.println(i);
			}
		}

	}
}
