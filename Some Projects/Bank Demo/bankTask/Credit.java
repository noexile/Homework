package bankTask;

public class Credit extends Product {

	private double montlyPayment;
	
	public Credit(String name, double yearlyLoanPercent) {
		super(name, yearlyLoanPercent, 0);
	}

	
	// getters and setters
	public double getMontlyPayment() {
		return montlyPayment;
	}

	public void setMontlyPayment(double montlyPayment) {
		this.montlyPayment = montlyPayment;
	}
	
}
