package PersonDemo;

public class JustADemo {

	public static void main(String[] args) {
		
		Person[] personArr = new Person[10];
		
		Person vankata = new Person("Ivan Draganov", 30, true);
		Person tedi = new Person("Teodora Ilieva", 16, false);
		
		Student simona = new Student("Simona Hrisimova", 21, false, 5.78);
		Student zaho = new Student("Zahari Mishev", 22, true, 4.75);
		
		Employee lili = new Employee("Liliya Mandrahertzova", 17, false, 40);
		Employee stoencha = new Employee("Stoyan Peev", 28, true, 70);

		
		personArr[0] = vankata;
		personArr[1] = tedi;
		personArr[2] = simona;
		personArr[3] = zaho;
		personArr[4] = lili;
		personArr[5] = stoencha;
		
		for (int i = 0; i < personArr.length; i++) {
			if (personArr[i] == null) {
				continue;
			}
			if (personArr[i] instanceof Student) {
				((Student) personArr[i]).showStudentInfo();
			} else if (personArr[i] instanceof Employee) {
				((Employee) personArr[i]).showEmployeeInfo();
			} else if (personArr[i] instanceof Person){ // we make the parent class last for checking instead of just an 'else' statement as someday we might add some new classes. This one should stay at last!
				personArr[i].showPersonInfo();
			}
			System.out.println();
		}
		
		for (int i = 0; i < personArr.length; i++) {
			if (personArr[i] == null) {
				continue;
			}
			if (personArr[i] instanceof Employee) {
				System.out.println(personArr[i].getName() + ": " + ((Employee) personArr[i]).calculateOvertime(2) + " overtime payment");	
			}
					
		}
		
	}
	
}
