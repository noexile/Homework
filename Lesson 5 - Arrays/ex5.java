
//	Задача 5:
//	Напишете програма, която създава масив с 10 елемента и инициализира всеки от елементите със стойност, равна на индекса на елемента, умножен по 3.
//	Да се изведат елементите на екрана.

public class ex5 {

	public static void main(String[] args) {

		byte[] arr = new byte[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (byte) (i * 3);
		}

		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			} else {
				System.out.print(" }");
			}
		}
	}
}
