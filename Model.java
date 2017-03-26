import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class Model {
	ArrayList<Card> cards = new ArrayList<Card>();
	int balance;
	private Controller controller;
	private Vault vault = new Vault();

	public Model() {
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
	 * @param userWithdrawAmount
	 *            The withdraw amount
	 * @return Whether or not the transaction can be completed
	 */
	public static boolean checkIfPossibleToWithdraw(Account acc, int userWithdrawAmount) {
		if (userWithdrawAmount != (int) userWithdrawAmount) {
			System.out.println(
					"You cannot withdraw coins. However, you can withdraw " + (int) userWithdrawAmount + " instead.");
			return false;
		} else if (Vault.getTotal() < userWithdrawAmount) {
			System.out.println("The ATM does not have enough money to service your request.");
			return false;
		} else if (userWithdrawAmount > acc.getCashLimitRemaining()) {
			System.out.println("This withdraw would exceed your daily withdraw limit.");
			return false;
		} else {

			// get the data from the vault and see how many of each denomination
			// we have
			Map<Integer, Integer> denominationsAvailable = new HashMap<Integer, Integer>();
			denominationsAvailable.put(50, Vault.getFifties());
			denominationsAvailable.put(20, Vault.getTwenties());
			denominationsAvailable.put(10, Vault.getTens());
			denominationsAvailable.put(5, Vault.getFives());

			int runningWithdraw = userWithdrawAmount;

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
						+ (userWithdrawAmount - runningWithdraw) + " instead?");
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
}
