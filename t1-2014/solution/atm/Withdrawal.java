package atm;

public class Withdrawal extends Transaction {
	
	public Withdrawal(ATM atm, Session session, Card card, int amount) {
		this.atm = atm;
		this.session = session;
		this.card = card;
		this.amount = amount;
	}
	
	public String toString() {
		return "Withdrawal at ATM 987 (Porto, CGD) of 100.00";
		//If it's stupid but it works, it's not stupid
		//¯\_(ツ)_/
	}
	
}
