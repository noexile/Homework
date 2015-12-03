
//	������ 17:
//	���� ������ �� ���������� ����� �� �������� �������������� ������, ��� �� ���������� � �� ���������� ���������:
//	N1 < N2 > N3 < N4 > N5 <..
//	��������� ��������, ����� ��������� ���� �������� � ��������� ����� ������ �� ����� ���������� ������� ����������.
//	������: 1 3 2 4 3 7
//	�����: ��������� ������������ �� �������������� ������ ������

public class ex17 {

	public static void main(String[] args) {
		
		int[] arr = {2,  1, 3, 1, 3, 2, 4, 3, 5, 1, 1 };
		
		boolean isSpiked = true;
		
		System.out.println("With this exercise we will check if an array is spiked or not. N1 < N2 > N3 < N4 > N5 <..");
		System.out.println();
		
		for (int i = 1; i < arr.length - 1; i++) {
			boolean top = (arr[i] > arr[i-1] && arr[i] > arr[i+1]);
			boolean bottom = (arr[i] < arr[i-1] && arr[i] < arr[i+1]);
			
			if ( !bottom && !top) {
				isSpiked = false;
			}
		}

		if (isSpiked) {
			System.out.println("The array is spiked:");
		} else {
			System.out.println("The array is NOT spiked:");
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
