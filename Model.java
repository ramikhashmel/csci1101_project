import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
	private static boolean isAuthenticated;
	ArrayList<Card> cards = new ArrayList<Card>();
	static ArrayList<Account> accounts = new ArrayList<Account>();
	int balance;
	private Controller controller;
	private Vault vault = new Vault();

	public Model() {
		Account acc = new Account();
		acc.setAccountNumber(12345);
		acc.setBalance(1000);
		acc.setCard(new Card("1234567812341234"));
		acc.setName("Bob Jones");
		// read the credit card numbers from the file
		cards.add(new Card("1234567812341234"));
	}

	public void addController(Controller controller) {
		this.controller = controller;
	}

	public void aggregateFromAccount() {

	}

	public boolean checkAuthencity() {
		return false;
	}

	public void dispenseMoney() {

	}

	public boolean isValidCard(Card card) {
		for (int i = 0; i < cards.size(); i++) {
			if (card.equals(cards.get(i))) {
				return true;
			}
		}
		return false;
	}

	public void validateCardWithBank() {

	}

	public void validateDataFromAccount() {

	}

	/**
	 * Checks if the withdraw amount is possible or not, by checking the user's
	 * account and how much money is left in the ATM, and what denominations are
	 * available.
	 * 
	 * @param acc
	 *            The user's account
	 * @param withdrawAmt
	 *            The withdraw amount
	 * @return Whether or not the transaction can be completed
	 */
	public static boolean checkIfPossibleToWithdraw(Account acc, float withdrawAmt) {
		if (withdrawAmt != (int) withdrawAmt) {
			System.out.println(
					"You cannot withdraw coins. However, you can withdraw " + (int) withdrawAmt + " instead.");
			return false;
		} else if (Vault.getTotal() < withdrawAmt) {
			System.out.println("The ATM does not have enough money to service your request.");
			return false;
		} else if (withdrawAmt > acc.getCashLimitRemaining()) {
			System.out.println("This withdraw would exceed your daily withdraw limit.");
			return false;
		} else {

			// get the data from the vault and see how many of each denomination
			// we have
			Map<Integer, Integer> denominationsAvailable = new HashMap<Integer, Integer>();
			denominationsAvailable.put(50, Vault.getNumOfFifties());
			denominationsAvailable.put(20, Vault.getNumOfTwenties());
			denominationsAvailable.put(10, Vault.getNumOfTens());
			denominationsAvailable.put(5, Vault.getNumOfFives());

			int runningWithdraw = (int) withdrawAmt;

			Map<Integer, Integer> withdrawDenominations = new HashMap<Integer, Integer>();

			/*
			 * Iterate through all of the bills, and subtract the largest
			 * possible bill as many times as possible from the user's withdraw
			 * amount.
			 */
			for (int i = 0; i < Utilities.stdDenominations.size(); i++) {
				int currBillVal = Utilities.stdDenominations.get(i);
				int numOfNeededBills = (int) (runningWithdraw / currBillVal);

				if (numOfNeededBills <= denominationsAvailable.get(currBillVal)) {
					withdrawDenominations.put(currBillVal, numOfNeededBills);
					runningWithdraw = runningWithdraw - (numOfNeededBills * currBillVal);
				} else {
					withdrawDenominations.put(currBillVal, 0);
				}
			}

			// if the amount that remains is zero, then we can make a withdraw
			if (runningWithdraw == 0) {
				// user can withdraw money because enough denominations exist
				// calculate how many bills they should withdraw
				System.out.println("$50 x " + withdrawDenominations.get(50));
				System.out.println("$20 x " + withdrawDenominations.get(20));
				System.out.println("$10 x " + withdrawDenominations.get(10));
				System.out.println("$5 x " + withdrawDenominations.get(5));
				return true;
			} else if (runningWithdraw > 0) {
				/*
				 * There was a remainder left from calculating the bills, so the remainder
				 * cannot be withdrawn. Subtract the remainder from the user's withdraw amount
				 * and ask if they'd like to have that out instead.
				 */
				System.out.println("You can't withdraw that amount. Would you like to withdraw $"
						+ (withdrawAmt - runningWithdraw) + " instead?");
				return false;
			} else {
				// there's no money left in the ATM, or a fatal calculation
				// error occurred
				return false;
			}
		}
	}

	public Vault getVault() {
		return vault;
	}

	public void openOutputDrawer() {
		// TODO Auto-generated method stub

	}

	public void closeOutputDrawer() {
		// TODO Auto-generated method stub

	}

	public static void setAuthenticated(boolean b) {
		isAuthenticated = b;	
	}

	public static boolean isAuthenticated() {
		return isAuthenticated;
	}

	public static Account findAccount(Card card) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getCard().equals(card)) {
				return accounts.get(i);
			}
		}
		return null;
	}
}
