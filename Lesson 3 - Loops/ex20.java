
//	Задача 20:
//	Да се състави програма, чрез която се извежда квадрат от
//	цифри. Сумите от елементите на произволен ред или стълб са
//	равни на 45.
//	Пример:
//	1 2 3 4 5 6 7 8 9 0
//	2 3 4 5 6 7 8 9 0 1
//	3 4 5 6 7 8 9 0 1 2
//	4 5 6 7 8 9 0 1 2 3
//	5 6 7 8 9 0 1 2 3 4
//	6 7 8 9 0 1 2 3 4 5
//	7 8 9 0 1 2 3 4 5 6
//	8 9 0 1 2 3 4 5 6 7
//	9 0 1 2 3 4 5 6 7 8
//	0 1 2 3 4 5 6 7 8 9

public class ex20 {

	public static void main(String[] args) {

		System.out.println("This example prints a square witch digits. Each row or column has different digits with sum = 45");
		for (byte i = 1; i <= 10; i++) {
			for (byte j = 0; j < 10; j++) {
				byte currentNumber = (byte) (i + j);
				currentNumber %= 10;
				System.out.print(currentNumber + " ");
			}
			System.out.println();
		}

	}

}
