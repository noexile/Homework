package StudentDemo;

public class College {

	public static void main(String[] args) {
		
		StudentGroup fizika = new StudentGroup("Fizika");
		StudentGroup biologia = new StudentGroup("Biologia");
		
		Student ivan = new Student("Ivan Seryozhev", "biologia", 34);
		Student petur = new Student("Petur Panayotov", "bioLogIa", 18);
		Student kolyo = new Student("Nikola Kitarista Antonov", "fizIka", 32);
		Student maria = new Student("Maria Ivanova", "Biologia", 24);
		Student petranka = new Student("Petranka Kostadinova", "biologia", 29);
		Student zyumbyul = new Student("Zyumbyul Pchelinov", "Fizika", 19);
		Student mitko = new Student("Mitko Tzekov", "fizika", 21);
		Student geri = new Student("Gergana Karayordanova", "BIOLOGIA", 22);
		Student petko = new Student("Petko Totev", "bIoLoGIa", 30);
		
//		fizika.addStudent(ivan);
//		fizika.addStudent(petur);
//		fizika.addStudent(kolyo);
//		fizika.addStudent(maria);
//		fizika.addStudent(petranka);
//		fizika.addStudent(zyumbyul);
//		fizika.addStudent(mitko);
//		fizika.addStudent(geri);
//		fizika.addStudent(petko);
//		
//		fizika.printStudentsInGroup();
//		fizika.emptyGroup();
		
		ivan.grade = 5.10;
		petur.grade = 5.40;
		maria.grade = 5.75;
		
		ivan.receiveScholarship(5, 200);
		petur.receiveScholarship(5, 200);
		maria.receiveScholarship(5, 200);
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		petranka.upYear();
		
		biologia.addStudent(ivan);
		biologia.addStudent(petur);
		biologia.addStudent(kolyo);
		biologia.addStudent(maria);
		biologia.addStudent(petranka);
		biologia.addStudent(zyumbyul);
		biologia.addStudent(mitko);
		biologia.addStudent(geri);
		biologia.addStudent(petko);
		biologia.addStudent(petko);
		biologia.addStudent(petko);
		
		biologia.printStudentsInGroup();
		
		String theBest = biologia.theBestStudent();
		System.out.println(theBest + " is the best student in the group!");
		
	}

}
