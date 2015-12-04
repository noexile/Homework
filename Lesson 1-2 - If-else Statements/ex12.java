import java.util.Scanner;

//	Задача 12:
//	Високосни години са всички години кратни на 4 с изключения столетията, 
//	но без столетия кратни на 400, т.е. 1900 не е високосна, но 1600 и 2000 са високосни.
//	Съставете програма, която по дадени ден, месец, година отпечатва следващата дата.
//	Входни данни: три числа за ден, месец, година.
//	Пример: 28, 2, 2000
//	Изход: 1,3,2000

public class ex12 {

	public static void main(String[] args) {


		boolean isJanMarMayJulAugOctDec;
		boolean isAprJunSepNov;
		byte daysInMonth;
		
		byte day;
		byte month;
		short year;
		short centuryNumber = 1;
		
		boolean isLeapYear;

		boolean monthRengeChecker;
		boolean yearRangeChecker;
		
		System.out.println("With the following example we will enter a date of the calendar and print the next day as a result.");
		System.out.println("Please note that you can enter only integer numbers.");
		System.out.println("Also please be carefull of the range of the date given. Use the instructions that follow.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter day of month from 1 to 31: ");
		day = inputNumber.nextByte();
		System.out.print("Enter month from 1 to 12: ");
		month = inputNumber.nextByte();
		System.out.print("Enter year from 1 to 9999: ");
		year = inputNumber.nextShort();
		
		if (year > 99 && year < 10000) {
			centuryNumber = (short) (year / 100);
			centuryNumber %= 4; // checking if the century is divided by 4 i.e. is Leap
		}
		if (year == 40 || year == 80) {
			centuryNumber = 0;
		}
		yearRangeChecker = (year > 0 && year < 10000)? true : false;
		monthRengeChecker = (month > 0 && month < 13)? true : false;
		
		isLeapYear = ((year % 4 == 0) && centuryNumber == 0)? true : false;
		
		isJanMarMayJulAugOctDec = (month == 1 || month ==3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)? true : false;
		isAprJunSepNov = (month == 4 || month == 6 || month == 9 || month == 11)? true : false;
		if (isJanMarMayJulAugOctDec) {
			daysInMonth = 31;
		} else if (isAprJunSepNov) {
			daysInMonth = 30;
		} else if (isLeapYear) {
			daysInMonth = 29;
		} else {
			daysInMonth = 28;
		}
		
		if (yearRangeChecker) {
			if (monthRengeChecker) {
				if (day <= daysInMonth && day > 0) {
					if (day == daysInMonth) {
						day = 1;
						month++;
						if (month >= 12) {
							month = 1;
							year++;
						}
					} else {
						day++;
					}
					System.out.println("The next day of your chosen date is " + day + ", " + month + ", " + year);
				} else {
					System.out.println("The chosen month has only " + daysInMonth + " in it.");
				}
			} else {
				System.out.println("You know ... up till not the months are 12 ...");
			}
		} else {
			System.out.println("Please enter a year in the given range of 1 to 9999.");
		}
		
		inputNumber.close();
	}

}
