public class Controller {
	Bank bank;
	private View view;
	private Model model;
	CustomerReceipt custReceipt = new CustomerReceipt();
	InternalReceipt internReceipt = new InternalReceipt();

	public void addModel(Model model) {
		this.model = model;

	}

	public void addView(View view) {
		this.view = view;

	}

	public boolean checkCardLength() {
		return true;
	}

	public boolean checkExpiryDate() {
		return false;

	}

	public void dispenseCash() {

	}

	public boolean enoughDigits() {
		return false;

	}

	public boolean enoughMoneyInMachine() {
		return false;

	}

	public boolean validateCard() {
		return false;

	}

	public void writeTransactionToFile(Transaction trans) {
	}

	/**
	 * @param view
	 * @param model
	 */
	public void initialize() {
		// create new account, and ask user for a card number
		String cardNumber = UserInput.getString("Card Number: ", Restrictions.getCCNumberRestriction());
	
		Card card = new Card();
		card.setNumber(cardNumber);
	
		// get pin, and try to validate the card
		String pin = UserInput.getString("PIN: ", Restrictions.getPinRestriction());
	
		InputRestrictionResult result = null;
	
		// if it's valid, continue otherwise abort
		if (model.isValidCard(card)) {
			view.update(ViewState.CARD_VALID, result);
			view.update(ViewState.CARD_WITHDRAW_OR_DEPOSIT);
		} else {
			view.update(ViewState.CARD_INVALID, result);
		}
	}
}