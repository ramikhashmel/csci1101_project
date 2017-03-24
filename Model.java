import java.util.ArrayList;

public class Model {
	ArrayList<Card> cards = new ArrayList<Card>();
	int balance;
	private Controller controller;

	public Model() {
		// read the credit card numbers from the file
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
		return false;
	}

	public void validateCardWithBank() {

	}

	public void validateDataFromAccount() {

	}

	public boolean checkIfPossibleToWithdraw(Account acc, int userWithdrawAmount) {
		int numOfFives = Vault.getFives();
		int numOfTens = Vault.getTens();
		int numOfTwenties = Vault.getTwenties();
		int numOfFifties = Vault.getFifties();

		int runningWithdraw = userWithdrawAmount;
		int currentPossibleWithdrawAmount = 0;
		int totalVaultValue = Vault.getTotal();
		int cashLimit = acc.getCashLimitRemaining();

		if (runningWithdraw != Math.round(runningWithdraw)) {
			// tell user that they cannot withdraw coins, and that they have to
			// take out round(v) instead
			return false;
		} else if (totalVaultValue < runningWithdraw) {
			// atm doesn't have enough money
			return false;
		} else if (runningWithdraw > cashLimit) {
			// you don't have a high enough daily withdrawal limit
			return false;
		} else {
			if ((runningWithdraw % 50) <= numOfFifties) {
				currentPossibleWithdrawAmount = currentPossibleWithdrawAmount + (runningWithdraw % 50) * 50;
				runningWithdraw = runningWithdraw - (runningWithdraw % 50) * 50;
			}
			if (currentPossibleWithdrawAmount + (runningWithdraw % 20) <= numOfTwenties) {
				currentPossibleWithdrawAmount = currentPossibleWithdrawAmount + (runningWithdraw % 20) * 20;
				runningWithdraw = -(runningWithdraw % 20) * 20;
			}
			if (currentPossibleWithdrawAmount + (runningWithdraw % 10) <= numOfTens) {
				currentPossibleWithdrawAmount = currentPossibleWithdrawAmount + (runningWithdraw % 10) * 10;
				runningWithdraw = -(runningWithdraw % 10) * 10;
			}
			if (currentPossibleWithdrawAmount + (runningWithdraw % 5) <= numOfFives) {
				currentPossibleWithdrawAmount = currentPossibleWithdrawAmount + (runningWithdraw % 5) * 5;
				runningWithdraw = -(runningWithdraw % 5) * 5;
			}
			if (runningWithdraw == 0) {
				// user can withdraw money because enough denominations exist
				// calculate how many bills they should withdraw
				
				return true;
			} else if (runningWithdraw > 0) {
				// user cannot withdraw that exact amount, however they can get out a certain amount
				return false; // ish
			} else {
				// there's no money left in the ATM, or a fatal calculation
				// error occurred
				
				return false;
			}
		}
	}
}
