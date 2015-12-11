package StudentDemo;

public class Student {
	
	String name;
	String subject;
	double grade;
	byte yearInCollege = 0;
	int age;
	boolean isDegree;
	double money;
	
	Student() {
		this.grade = 4.0;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}
	
	Student(String name, String subject, int age) {
		this();
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	
	void upYear() {
		
		if (isDegree) {
			System.out.println("The student " + this.name + " has already graduated!");
			return;
		} else {
			yearInCollege++;
			if (yearInCollege == 4) {
				isDegree = true;
			}
			
		}

		
	}
	
	double receiveScholarship(double min, double amount) {
		
		if (this.grade >= min && this.age < 30) {
			this.money += amount;		
		}
		return this.money;
	}
	
	
}
