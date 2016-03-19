package bankTask;

public class Deposit extends Product {
	
	private double montlyPayedDepositInterest;
		
	
	// constructor
	public Deposit(String name, double yearlyLoanPercent, int productDuration) {
		super(name, yearlyLoanPercent, productDuration);
	}
	

	// getters and setters
	public double getMontlyPayedDepositInterest() {
		return montlyPayedDepositInterest;
	}
	
	public void setMontlyPayedDepositInterest(double montlyPayedDepositInterest) {
		this.montlyPayedDepositInterest = montlyPayedDepositInterest;
	}
	
}
