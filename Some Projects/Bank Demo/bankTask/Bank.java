package bankTask;

import java.util.ArrayList;

public class Bank {
	
	public static final double LOAN_INTEREST_PERCENT = 5;
	private String name;
	private String address;
	private double money;
	private double reserve;
	private ArrayList<Credit> bankCredits;
	private ArrayList<Deposit> bankDebits;
	
	public Bank(String name, String address, double money) {
		try {
			if (name.trim().isEmpty() || name == null || address.trim().isEmpty() || address == null || money < 0) {
				throw new InvalidFormatException();
			}
			
			this.name = name;
			this.address = address;
			this.bankCredits = new ArrayList<Credit>();
			this.bankDebits = new ArrayList<Deposit>();
			this.money = ((money / 100) * 90);
			this.reserve = ((money / 100) * 10);
			
		} catch (InvalidFormatException e) {
			System.out.println(e);
		} 
	}
	
	// methods
	void receiveDeposit(double ammount, Deposit deposit, Client client) {
		if (client.getMoney() < ammount) {
			System.out.println("Insufficient ammount to deposit!");
		}
		
		deposit.setAmmount(ammount);
		this.bankDebits.add(deposit);
		this.money += ammount;
		this.reserve += (ammount * 0.9);
	}
	
	public void payAllInterest() {
		for (int i = 0; i < this.bankCredits.size(); i++) {
			if (this.bankCredits.get(i) == null) {
				continue;
			}
			
			this.bankCredits.get(i).setAmmount(this.bankCredits.get(i).getAmmount() + payedPercentage(bankCredits.get(i)));
		}
	}
	
	
	private double payedPercentage(Credit credit) {
		return ((credit.getAmmount() / 100) * credit.getYearlyLoanPercent());
	}

	void giveLoan(double money, Credit credit, Client client) {
		if (client == null || credit == null) {
			System.out.println("Please input correct data for credit / client.");
			return;
		} else if (money < 0) {
			System.out.println("The input ammount cannot be negative!");
			return;
		}
		
		int temp = (int) money;
		
		for (int i = 0; i < client.getBankCredit().size(); i++) {
			if (client.getBankCredit().get(i) == null) {
				continue;
			}	
			temp += ((client.getBankCredit().get(i).getAmmount() / client.getBankCredit().get(i).getProductDuration()) * client.getBankCredit().get(i).getYearlyLoanPercent());			
		}
		
		if (temp > (client.getMonthlySalary() / 2)) {
			System.out.println("The bank will not give " + client.getName() + " a loan due to much expenses of the client.");
			return;
		}
		
		if (temp  > this.reserve) {
			System.out.println("The bank will not give " + client.getName() + " a loan. Insufficient money in the reserve.");
			return;
		}
		
		this.money -= money;
		this.reserve -= (money * 0.1);
		this.bankCredits.add(credit);
		client.getBankCredit().add(credit);
		credit.setAmmount(money);
		client.setMoney(client.getMoney() + money);
	}
	
	public void printCurrentDeposits() {
		for (int i = 0; i < this.bankDebits.size(); i++) {
			System.out.println(this.bankDebits.get(i).getName() + " " + this.bankDebits.get(i).getAmmount());
		}
	}
	
	public void printCurrentCredits() {
		for (int i = 0; i < this.bankCredits.size(); i++) {
			System.out.println(this.bankCredits.get(i).getName() + " " + this.bankCredits.get(i).getAmmount());
		}
	}
	
	// getters and setters
	public ArrayList<Credit> getBankCredits() {
		return bankCredits;
	}

	public ArrayList<Deposit> getBankDebits() {
		return bankDebits;
	}
	
	public String getName() {
		return name;
	}
	
	public double getMoney() {
		return money;
	}
	
	public double getReserve() {
		return reserve;
	}

}