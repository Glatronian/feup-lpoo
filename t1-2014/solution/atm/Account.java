package atm;

public class Account {
	private double balance;
	private String name;
	
	Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	String getName() {
		return name;
	}
	
	double getBalance() {
		return balance;
	}
}
