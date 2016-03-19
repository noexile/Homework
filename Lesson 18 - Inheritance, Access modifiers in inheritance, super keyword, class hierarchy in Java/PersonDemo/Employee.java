package PersonDemo;

public class Employee extends Person{
	
	private double daySalary;
	
	Employee(String name, int age, boolean isMale, double daySalary) {
		super(name, age, isMale);
		setDaySalary(daySalary);
	}
	
	public void setDaySalary(double daySalary) {
		if (daySalary < 0) {
			System.out.println("The daily salary cannot be nagative!");
			return;
		}
		this.daySalary = daySalary;
	}
	
	public double getDaySalary() {
		return this.daySalary;
	}
	
	public double calculateOvertime(double hours) {
		double coef = 1.5;
		
		if (super.getAge() < 18) {
			coef = 0;
		}
		
		return  (this.getDaySalary() / 8) * hours * coef;
	}
	
	public void showEmployeeInfo() {
		showPersonInfo();
		System.out.println("Daily salary: " + this.daySalary);
	}
	
}
