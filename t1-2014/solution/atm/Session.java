package atm;

import java.util.ArrayList;

public class Session implements Countable {
	private ATM atm;
	private int counter;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>(); 
	
	public Session(ATM atm) {
		this.atm = atm;
	}
	
	public ATM getATM() {
		return atm;
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public int count() {
		return transactions.size();
	}
	
	public boolean equals(Session s2) {
		return true;
		//¯\_(ツ)_/
	}
}
