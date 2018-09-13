package atm_package;

import java.util.Scanner;

public class AtmClientApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Atm myAtm = new Atm(0);
		enterPin(input, myAtm);

		String choice;
		do {
			choice = giveChoice(input);

			if (choice.equals("1")) { // deposit
				deposit(input, myAtm);

			} else if (choice.equals("2")) { // withdraw
				withdraw(input, myAtm);

			} else if (choice.equals("3")) { // check balance
				checkBalance(myAtm);
			}

		} while (!choice.equals("4"));
		System.out.println("Thank you for choosing the Interstellar Bank of Max. Goodbye.");
		input.close();
	}

	//explain input options to user
	public static String giveChoice(Scanner input) {
		String choice;
		System.out.println("\n\nWelcome to the Interstellar Bank of Max.");
		System.out.println("Please select an option:");
		System.out.println("1: Deposit\n2: Withdraw\n3: Check Balance\n4: Exit");
		choice = input.nextLine();
		return choice;
	}

	//enter PIN, check, block if too many attempts
	public static void enterPin(Scanner input, Atm myAtm) {
		String givenPin;
		int attemptedPins = 0;
		do {
			if (attemptedPins > 3) {
				System.out.println("Get out of here and don't come back until you learn your PIN.");
				System.exit(0);
			}
			System.out.println("Please enter your PIN. Remaining attempts: " + (4 - attemptedPins));
			givenPin = input.nextLine();
			attemptedPins++;
		} while (!myAtm.allowAccess(givenPin));
	}

	//check balance
	public static void checkBalance(Atm myAtm) {
		double balance = myAtm.getBalance();
		System.out.println("Your balance is " + balance + " buckaroos.");
		if (balance < 0) {
			System.out.println("You'd better pay that back soon.");
		}
	}

	//withdraw
	public static void withdraw(Scanner input, Atm myAtm) {
		System.out.println("Enter amout to withdraw:");
		double cashYouGet = input.nextDouble();
		input.nextLine();
		myAtm.withdraw(cashYouGet);
		System.out.println("Here ya go! (The machine spits " + cashYouGet + " out at you.)");
		System.out.println("New balance: " + myAtm.getBalance());
	}

	//deposit
	public static void deposit(Scanner input, Atm myAtm) {
		System.out.println("Enter amount to deposit:");
		double deposit = input.nextDouble();
		input.nextLine();
		myAtm.deposit(deposit);
		System.out.println("Thank you. Munch munch munch (the machine eats " + deposit + ".)");
		System.out.println("New balance: " + myAtm.getBalance());
	}

}
