package PersonDemo;

public class Student extends Person{
	
	private double score;
	
//	Student() {
//		пример за default конструктор.
//	}
	
	Student(String name, int age, boolean isMale, double score) {
		super(name, age, isMale);
		setScore(score);
	}
	
	public void setScore(double score) {
		if (score < 2 || score > 6) {
			System.out.println("The score can be between 2 and 6 !");
			return;
		}
		this.score = score;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void showStudentInfo() {
		showPersonInfo();
		System.out.println("Student score: " + this.score);
	}
	
}

/* И един въпрос, какво ще стане ако дефинирате конструктор без параметри Student() в класа Student ??? 
   Възможно ли е, и ако не защо. Как може да се оправи това?
   
   отговор:
   По зададеното условието на задачата не може да се направи default конструктор (без параметри) Student() в класа Student.
   Тъй като самият клас Student унаследява класа Person, то ние задължително трябва да създадем конструктор с параметри, тъй като в класа Person ние нямаме такъв по default.
   Следователно, вече веднъж създаден конструктор с някакви параметри ни ограничава от извикването на default-ния, който няма параметри.
   
   Да, това e възможно да се оправи, като в класа Person се създаде default конструктор (без параметри).
 */