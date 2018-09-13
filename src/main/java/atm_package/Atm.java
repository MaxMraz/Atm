package atm_package;

public class Atm {
	private double balance;
	private String requiredPin = "1234";

	// constructor
	public Atm(double initialBalance) {
		balance = initialBalance;
	}

	// allow access
	public boolean allowAccess(String enteredPin) {
		if (enteredPin.equals(requiredPin)) {
			return true;
		}
		return false;
	}

	
	public String getPin() {
		return requiredPin;
	}

	// get balance
	public double getBalance() {
		return balance;
	}

	// set balance
	public void setBalance(double amount) {
		balance = amount;
	}

	//deposit money
	public void deposit(double amount) {
		balance = balance + amount;
	}

	//withdraw money
	public double withdraw(double amount) {
		balance = balance - amount;
		return balance; // this method returns the new balance for your convenience
	}

}
