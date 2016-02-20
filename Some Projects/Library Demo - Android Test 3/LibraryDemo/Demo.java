package LibraryDemo;

import Library.Library;
import Library.Person;

public class Demo {
	
	public static Library lib;
	
	public static void main(String[] args) {
		
		lib = new Library();
		
//		lib.showAllBooks();
//		lib.showAllTextbooks();
//		lib.showAllMagazines();
		
		Person person1 = new Person("Ivan");
		Person person2 = new Person("Dragan");
		Person person3 = new Person("Petkan");
		Person person4 = new Person("Hasan");
		Person person5 = new Person("Kaliman");
		
//		lib.generateFileToWhireAllCurrentlyTakenItems();
		
		lib.start();
		person1.start();
		person2.start();
		person3.start();
		person4.start();
		person5.start();
		
	}
}
