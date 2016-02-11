package bankTask;

import java.util.ArrayList;

public class Client {
	
	private String name;
	private String address;
	private double money;
	private double monthlySalary;
	private ArrayList<Deposit> bankDeposit;
	private ArrayList<Credit> bankCredit;
	
	// constructor
	public Client(String name, String address, double money, double monthlySalary) {
		this.name = name;
		this.address = address;
		this.money = money;
		this.monthlySalary = monthlySalary;
		this.bankDeposit = new ArrayList<>();
		this.bankCredit = new ArrayList<>();
	}
	
	// methods
	public void makeDeposit(double money, Deposit deposit, Bank bank) {
		if (money > this.money) {
			System.out.println("Insufficient ammount of money. The client has: " + this.money);
			return;
		}
		
		bank.receiveDeposit(money, deposit, this);
		this.money -= money;
		this.bankDeposit.add(deposit);
	}
	
	public void requestLoan(double money, Credit credit, Bank bank) {
		bank.giveLoan(money, credit, this);
	}
		
	public void payLoan(Credit credit, double money) {
		if (!bankCredit.contains(credit)) {
			System.out.println("The client does not have such credit");
			return;
		} 

		for (int i = 0; i < this.bankCredit.size(); i++) {
			if (bankCredit.get(i).equals(credit)) {
				if (bankCredit.get(i).getAmmount() < money) {
					this.money -= (bankCredit.get(i).getAmmount() - money);
					System.out.println(bankCredit.get(i).getName() + " is fully payed ! Money returned to client: " + (money - bankCredit.get(i).getAmmount()));
					bankCredit.remove(i);
					return;
				}
				
				bankCredit.get(i).setAmmount(bankCredit.get(i).getAmmount() - money);
				System.out.println("Money payed for credit: " + money + ". Ammount left to cover the credit: " + bankCredit.get(i).getAmmount());
				return;
			}
		}
	}

	// getters and setters
	void setMoney(double money) {
	this.money = money;	
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getMoney() {
		return money;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	ArrayList<Deposit> getBankDeposit() {
		return bankDeposit;
	}

	ArrayList<Credit> getBankCredit() {
		return bankCredit;
	}
	
}
