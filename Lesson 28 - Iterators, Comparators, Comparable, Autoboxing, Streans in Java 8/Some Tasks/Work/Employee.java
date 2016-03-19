//	Each employee has name, age, salary and an ID number. Departments are known by their name only.

package Work;

public class Employee {
	
	private String name;
	private int age;
	private int salary;
	private String iDNumber;
	
	
	// constructor
	public Employee(String name, int age, int salary, String iDNumber) {
		setName(name);
		setAge(age);
		setSalary(salary);
		setiDNumber(iDNumber);
	}
	
	
	// methods
	@Override
	public String toString() {
		return "Employee: " + getName() + ", age: " + getAge() + ", salary: " + getSalary() + ", iDNumber: " + getiDNumber();
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	protected void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	
	protected void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getiDNumber() {
		return iDNumber;
	}
	
	protected void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	
}
