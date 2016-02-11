//	������� ������/������� ���:
//	� ��� �� ��������
//	� ��������� ������ ���� �� ���� ������ ��� �������
//	� ������� ������ ������� (����������� �����)
//	� ������ �� �������� � ������ (�� 1 �� 60 ������)
//	� ������� ������ � ������ �� ������
//	� ������� ���� ��������� � ������ �� �������
//	� ��������� � ������ (���� � �� � ����������� � ������ �� ������)

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
