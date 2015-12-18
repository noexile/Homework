package PersonDemo;

public class Person {
	
	private String name;
	private int age;
	private boolean isMale;
	
//	Person() {
//		пример за default конструктор.
//	}
	
	Person(String name, int age, boolean isMale) {
		setName(name);
		setAge(age);
		setIsMale(isMale);
	}
	
	public void setIsMale(boolean isMale) {
		if (isMale) {
			this.isMale = true;
			return;
		}
		this.isMale = false;
	}
	
	public boolean getIsMale() {
		return this.isMale;
	}
	
	public void setAge(int age) {
		if (age < 0) {
			System.out.println("You cannot enter negative age!");
			return;
		}
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		if (name.trim().isEmpty()) {
			System.out.println("You must enter a name!");
			return;
		}
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	void showPersonInfo() {
		System.out.println("name: " + this.getName());
		System.out.println("age: " + this.getAge() + " years");
		System.out.println("sex: " + (this.getIsMale()? "male" : "female"));
	}
}
