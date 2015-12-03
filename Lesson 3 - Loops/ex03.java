
//	Задача 3: Да се изведат на екрана всички нечетни числа от -10 до 10.


public class ex03 {

	public static void main(String[] args) {
		
		for (int i = -10; i < 11; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

	}

}
