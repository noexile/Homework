//	Търговските обекти съдържат следните характеристики:
//	• адрес
//	• работно време
//	• площ
//	• данък към държавата.

package Market;

import java.util.Random;

public abstract class TargovskiObekt {

	private final int NUMBER_OF_PRODUCTS = 10_000;
	
	private String address;
	private String workingTime;
	private int area;
	private int countryTax;
	protected Product[] products;
	private int freePlacesForProducts;	
	
	// constructor
	public TargovskiObekt(String address, String workingTime, int area, int countryTax) {
		setAddress(address);
		setWorkingTime(workingTime);
		setArea(area);
		setCountryTax(countryTax);

		this.products = new Product[NUMBER_OF_PRODUCTS];
		setFreePlacesForProducts(NUMBER_OF_PRODUCTS);
	}
	
	// methods
	
	protected static int setArea(int highNumber, int lowNumber) {
		Random rand = new Random();
		int temp = rand.nextInt((highNumber - lowNumber) + 1) + lowNumber;
		return temp;
	}
	
	
	// getters and setters
	protected String getAddress() {
		return address;
	}
	
	protected void setAddress(String address) {
		this.address = address;
	}
	
	protected String getWorkingTime() {
		return workingTime;
	}
	
	protected void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}
	
	protected int getArea() {
		return area;
	}
	
	protected void setArea(int area) {
		this.area = area;
	}
	
	protected int getCountryTax() {
		return countryTax;
	}
	
	protected void setCountryTax(int countryTax) {
		this.countryTax = countryTax;
	}

	protected void printBallance() {
		// TODO Auto-generated method stub
		
	}

	protected int getFreePlacesForProducts() {
		return freePlacesForProducts;
	}

	protected void setFreePlacesForProducts(int freePlacesForProducts) {
		this.freePlacesForProducts = freePlacesForProducts;
	}
	
	
}
