
//	Задача 14:
//	Имате предварително въведен едномерен масив, съдържащ реални числа.
//	Да се състави програма, чрез която се избират само елементи от масива със стойности от интервала [-2.99..2.99] и се отпечатват в нов масив. 
//	Новият масив да се извежда на екрана.
//	Пример: 7.1,8.5,0.2,3.7,0.99,1.4,-3.5,-110,212,341,1.2
//	Изход: 0.2; 0.99; 1.4; 1.2

public class ex14 {

	public static void main(String[] args) {

		System.out.println("With this exercise we will check the values of the cells in one array and copy the ones that are between -2.99 and 2.99 into another array.");
		System.out.println();
		
		double[] arr = { 7.1 , 8.5 , 0.2 , 3.7 , 0.99 , 1.4 , -3.5 , -110 , 212 , 341 , 1.2 , 2 , 1.99 };
		double[] copyArr;
		int counter = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= -2.99 && arr[i] <= 2.99) {
				counter++;
			}
		}
		
		copyArr = new double[counter];
		counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= -2.99 && arr[i] <= 2.99) {
				copyArr[counter] = arr[i];
				counter++;
			}
		}
		
		for (int i = 0; i < copyArr.length; i++) {
			System.out.print(copyArr[i]);
			if (i < copyArr.length - 1) {
				System.out.print("; ");
			}
		}
	}

}
