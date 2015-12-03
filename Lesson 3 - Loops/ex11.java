import java.util.Scanner;

//	Въведете число N чрез конзолата и изкарайте като резултат следния триъгълник с височина N:
//	        *
//	       ***
//	      *****
//	.................
//	
//	Кaто допълнително упражнение – нарисувайте същия триъгълник, но незапълнен.

public class ex11 {

	public static void main(String[] args) {
		
		byte triangleHeight;
		char symbol = '*';
		char emptySpace = ' ';

		System.out.println("With this example we will create a triangle based on the input height.");
		System.out.println("The height can be a whole number - integer.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter the triangle height: ");
		triangleHeight = inputNumber.nextByte();
		
		for (byte row = 1; row <= triangleHeight; row++) {
			for (int j = 1; j <= triangleHeight - row; j++) {
				System.out.print(emptySpace);
			}
			for (int k = 1; k <= row + (row - 1); k++) {
				System.out.print(symbol);
				
// with the below code we print only the sides of the triangle 				
//				if (k == 1 || k == row + (row - 1) || row == triangleHeight) {
//					System.out.print(symbol);
//				} else {
//					System.out.print(emptySpace);
//				}
				
			}
			System.out.println();
		}
		
		inputNumber.close();
	}

}
