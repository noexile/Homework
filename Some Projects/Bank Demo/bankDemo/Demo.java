//�� �� ��������� ���� ��������, ����� ��� �������� ��������������:
// DONE �� �� ������� abstract class �� ������ ������� � ������� �������������� ������� ��-����.
// DONE �� �� �������� �� ������� ������� �� ������� � ������, ����� ���������� �������� �������.
// DONE �� �� �������� 2 �������� � Short Deposit � ������ �� 3 ������ � ����� 3% � Long Deposit � ������ �� 12 ������ � ����� 5%.
// DONE �� �� �������� 2 ������� � Home Credit � ����� 6% � Consumer Credit � ����� 10%. ���� ������� �� ������� �� �������� �� ������� �� �������.
// DONE �� �� ������� 1 ����� � ��������
// DONE �� �� �������� 10 ������� � �������� ���� � ���� � ������� �������. ������������ ��������� ����� �������� � �������. ���� ������� �� �� ������ � ����� clients.
// DONE ������������ �������� 10 ������� �� �� ������ �� 80% �� 100% (�� ������ �� �������� �����) ������ �� ������� � �������.
// DONE ���� ���� �� �� ������ ��������� ��������� �� ������� ����� � ������ ������� ������.
// DONE ����� ���� �� ���� ������� �� ����� �� ������� ������� ������� �� �������.
// DONE �� �� ������� ���������� (������ ��������) �� ������ �������, ������ ��������, ������ ��������� ������� � ���������� �� ����������� �� �������.

package bankDemo;

import java.util.ArrayList;
import java.util.Random;

import bankTask.Bank;
import bankTask.Client;
import bankTask.Credit;
import bankTask.Deposit;
import bankTask.Product;

public class Demo {
	
	static final int CLIENTS_TO_CREATE = 10;
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		Bank bnb = new Bank("BNB", "ul. Baluci 12", 20_000);
		ArrayList<Client> clients = new ArrayList<Client>();
		
		// creating clients
		for (int i = 0; i < CLIENTS_TO_CREATE; i++) {
			clients.add(new Client("Client " + (i + 1), "ul. Nezabravka " + (i + 1), rand.nextInt(2001 - 200) + 200, rand.nextInt(1001 - 400) + 400));
//			System.out.println(clients.get(i).getName() + " " + clients.get(i).getAddress() + " " + clients.get(i).getMoney() + " " + clients.get(i).getMonthlySalary());
		}
		
		Product shortDeposit = new Deposit("Short Deposit", 3, 3);
		Product longDeposit = new Deposit("Long Deposit", 5, 12);
		
		Product homeCredit = new Credit("Home Credit", 6);
		Product consumerCredit = new Credit("Home Credit", 10);
		
		// clients making deposits
		for (int i = 0; i < clients.size(); i++) {
			int tempMoney = (int) ((clients.get(i).getMoney() / 100) * (rand.nextInt(101 - 80) + 80));
			boolean tempDepositChooser = rand.nextBoolean();
			Product tempDeposit = (tempDepositChooser? shortDeposit : longDeposit);
			if (tempDeposit instanceof Deposit) {
				clients.get(i).makeDeposit(tempMoney, (Deposit) tempDeposit, bnb);
			}
		}
		
		// printing added deposits in the bank
		bnb.printCurrentDeposits();
		
		// printing bank's current amount
		System.out.println(bnb.getName() + " current amount: " + bnb.getMoney() + " lv.");
		System.out.println(bnb.getName() + " current reserve: " + bnb.getReserve() + " lv.");
		
		
		// clients taking credits
		for (int i = 0; i < clients.size(); i++) {
			int tempMoney = (int) ((clients.get(i).getMonthlySalary() / 100) * rand.nextInt(101 - 1) + 1);
			boolean tempCreditChooser = rand.nextBoolean();
			Product tempCredit = (tempCreditChooser? homeCredit : consumerCredit);
			if (tempCredit instanceof Credit) {
				clients.get(i).requestLoan(tempMoney, (Credit) tempCredit, bnb);
			}
		}
		
		// printing taken credits from the bank
		bnb.printCurrentCredits();
	}
}
