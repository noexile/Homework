package StudentDemo;

public class StudentGroup {
	
	String groupSubject;
	Student[] students;
	short freePlaces;
	
	StudentGroup() {
		emptyGroup(); // constructor's body is the same as the method emptyGroup();
	}
	
	StudentGroup(String subject) {
		this();
		this.groupSubject = subject;
	}
	
	void addStudent(Student student) {
		
		if (this.freePlaces == 0 || !student.subject.equalsIgnoreCase(this.groupSubject)) {
			return;
		}
				
		this.students[this.students.length - this.freePlaces] = student;
		this.freePlaces--;
	}
	
	void emptyGroup() {
		this.students = new Student[5];
		this.freePlaces = 5;
	}
	
	String theBestStudent() {
		
		int maxGradeStudentIndex = 0;
		
		for (int i = 1; i < this.students.length; i++) {
			if (this.students[i-1].grade < this.students[i].grade) {
				maxGradeStudentIndex = i;
			}
		}
		
		return this.students[maxGradeStudentIndex].name;		
	}
	
	void printStudentsInGroup() {
		for (int i = 0; i < this.students.length; i++) {
			if (students[i] != null) {
				System.out.println("Student " + (i+1) + " in group " + this.groupSubject + ":");
				System.out.println("Name: " + this.students[i].name);
				System.out.println("Age: " + this.students[i].age);
				System.out.println("Grade: " + this.students[i].grade);
				System.out.println("Subject: " + this.students[i].subject);
				System.out.println("Year in college: " + this.students[i].yearInCollege);
				System.out.println("Money: " + this.students[i].money);
				System.out.println(this.students[i].isDegree? "Has finished education!" : "Still a student.");
				System.out.println("---------------------------");
			}
		}
	}
}
