package source;

import java.util.ArrayList;

public class MainPage {
	
	ArrayList<Account> accounts;
	
	public MainPage () {
		this.accounts = new ArrayList<Account>();
		// TODO
	}
	
	// tekstovo pole za userName
	// tekstovo pole za passWord
	
	
	// buton login 
	public void searchUsername(String userName, String password) {
		
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accounts.get(i) == null) {
				continue;
			}
			
			if (accounts.get(i).getUserName().equals(userName)) {
				if (accounts.get(i).getPassWord().equals(password)) {
					// TODO
					// login account
				}
				System.out.println("Incorrect password for username: " + userName);
			}
			System.out.println("Incorrect username!");
		}
		
		System.out.println("Invalid username!");
		// opciya za vrushtane otnovo na main page-a
	}
	
	// buton register
	public void registerNewAccount(String userName, String passWord, String email) {
		for (int i = 0; i < this.accounts.size(); i++) {
			if (accounts.get(i).getUserName().equals(userName)) {
				System.out.println();
				// opciya za vrushtane otnovo na register page-a
			}
			
			// proverka za sigurna parola
			// proverka za email
			
			this.accounts.add(new Account(userName, passWord, email));
			return;
		}
	}
}
