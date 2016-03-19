package source;

import java.util.ArrayList;

public class Account {
	
	private String userName;
	private String passWord;
	private String email;
	// promenliva za data na suzdavane
	// promenliva za data za otchet v kalendara
	
	ArrayList<Task> tasks;
	ArrayList<Task> futureTasks; // array, v koyto shte se premestvat vsichki taskove koito sa s data po-golyama ot tekushtata - za sortirovka
	ArrayList<Task> oldTasks; // array, v koyto shte se premestvat vsichki taskove koito sa s data po-malka ot tekushtata - za sortirovka
	ArrayList<Task> payedTasks; // array, v koyto shte se premestvat vsichki taskove koito sa plateni - za sortirovka
	
	Account(String userName, String passWord, String email) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		// TODO
	}
	
	public void addTask(Task task) {
		// suzdava nov task
	}
	
	public void removeTask(Task task) {
		// premahva task
	}
	
	public void modifyTask(Task task) {
		
	}
	
	String getUserName() {
		return userName;
	}

	String getPassWord() {
		return passWord;
	}	
	
	
}
