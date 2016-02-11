//	банкова сметка/продукт има:
//	• Име на сметката
//	• Банковата сметка може да бъде кредит или депозит
//	• Годишен лихвен процент (положително число)
//	• Период на продукта в месеци (от 1 до 60 месеца)
//	• Месечна вноска в случай на кредит
//	• Месечна сума изплатена в случай на депозит
//	• Наличност в левове (може и да е отрицателна в случай на кредит)

package bankTask;

public abstract class Product {
	
	private String name;
	private double yearlyLoanPercent;
	private int productDuration;
	private double ammount;
	
	// constructor
	public Product(String name, double yearlyLoanPercent, int productDuration) {
		this.name = name;
		this.yearlyLoanPercent = yearlyLoanPercent;
		this.productDuration = productDuration;
		this.ammount = ammount;
	}
	
	// getters and setters
	void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	public double getAmmount() {
		return ammount;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	double getYearlyLoanPercent() {
		return yearlyLoanPercent;
	}

	void setYearlyLoanPercent(double yearlyLoanPercent) {
		this.yearlyLoanPercent = yearlyLoanPercent;
	}

	int getProductDuration() {
		return productDuration;
	}

	void setProductDuration(int productDuration) {
		this.productDuration = productDuration;
	}
	
}
