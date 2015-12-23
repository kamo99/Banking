import java.util.Scanner;
import java.time.MonthDay;

class Main {
	public static void main(String[] args) {
		final MonthDay today = MonthDay.now();

		System.out.println("Welcome to the Bank of Madahar");
		System.out.println("Today, it is " + today);

		final String id = input("What is your account ID? ");
		final String pin = input("What is your PIN? ");
		final User currentUser = new User(id, pin);
		System.out.println("Welcome, valued customer " + currentUser + "!");
		System.out.println("You seem to be a new customer!");
		while (true) {
			final String hasCheckingResp = input("Do you want to make a checking account? (y/n) ");
			if (hasCheckingResp.equals("n")) {
				break;
			}
			else if (hasCheckingResp.equals("y")) {
				currentUser.setCheckings(new CheckingAccount(currentUser));
				break;
			}
			else
				System.out.println("I didn't understand that.");
		}

		while (true) {
			final String hashSavingsResp = input("Do you want to make a savings account? (y/n) ");
			if (hashSavingsResp.equals("n")) {
				break;
			}
			else if (hashSavingsResp.equals("y")) {
				currentUser.setSavings(new SavingsAccount(currentUser));
				break;
			}
			else
				System.out.println("I didn't understand that.");
		}


		while (true) {
			System.out.println("Please select an action:");
			System.out.println("P -- Obtain a summary statement");
			System.out.println("S -- Obtain a Savings Transaction");
			System.out.println("C -- Obtain a Checkings Transaction");
			System.out.println("Q -- Quit");
			final String choice = input("").toUpperCase();

			if (choice.equals("Q"))
				break;

			else if (choice.equals("P")) {
				System.out.println(currentUser.getReceipts());
			}

			else if (choice.equals("S")) {
				try {
					System.out.println("You have $" + currentUser.getSavings().getBalance());
					String direction = input("Do you want to (withdraw) or (deposit)? ");
					if (direction.equals("withdraw")) {
						final double withdrawl = Integer.parseInt(input("How much do you want to withdraw? "));
						try {
							currentUser.getSavings().withdraw(withdrawl);
						} catch (Exception error) {
							System.out.println(error);
						}
					} else if (direction.equals("deposit")) {
						final double deposition = Integer.parseInt(input("How much do you want to desposit? "));
						try {
							currentUser.getSavings().deposit(deposition);
						} catch (Exception error) {
							System.out.println(error);
						}
					} else {
						System.out.println("I did not understand that");
					}
				} catch (Exception error) {
					System.out.println("You don't have a Savings Account");
				}
			}

			else if (choice.equals("C")) {
				try {
					System.out.println("You have $" + currentUser.getCheckings().getBalance());
					String direction = input("Do you want to (withdraw) or (deposit)? ");
					if (direction.equals("withdraw")) {
						final double withdrawl = Integer.parseInt(input("How much do you want to withdraw? "));
						try {
							currentUser.getCheckings().withdraw(withdrawl);
						} catch (Exception error) {
							System.out.println(error);
						}
					} else if (direction.equals("deposit")) {
						final double deposition = Integer.parseInt(input("How much do you want to desposit? "));
						try {
							currentUser.getCheckings().deposit(deposition);
						} catch (Exception error) {
							System.out.println(error);
						}
					} else {
						System.out.println("I did not understand that");
					}
				} catch (Exception error) {
					System.out.println("You don't have a Checkings Account");
				}
			}

			else {
				System.out.println("I did not understand that");
			}
		}
	}

	public static String input(String message) {
		System.out.print(message);
		final Scanner shell = new Scanner(System.in);
		final String response = shell.nextLine();
		return response;
	}
}
