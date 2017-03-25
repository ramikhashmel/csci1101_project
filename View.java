//http://www.austintek.com/mvc/#austintek_mvc.view_2

public class View {
	Controller controller;
	Card card;

	public View() {
		// initializes the GUI window; attaches buttons to methods
	}

	public void addController(Controller controller) {
		this.controller = controller;

	}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void update(ViewState state) {
		// this would fire when the input does not have to be restricted
		System.out.println("update() called with new view state " + state.name());
	}

	public void update(ViewState state, InputRestrictionResult result) {
		if (result != null) {
			// use the result to show the error, and the view state to update
			// the state
		} else {
			update(state);
		}
	}

	public void userPressedEnter() {
		// get the data from the controller
	}

	/**
	 * @param model
	 */
	public void askUserForCard() {
		card = new Card();
		
		update(ViewState.WELCOME_SCREEN_CARD_AUTH);
		
		// create new account, and ask user for a card number
		String cardNumber = UserInput.getString("Card Number: ", Restrictions.CCNumber());
		
		card.setNumber(cardNumber);
	
		// get pin, and try to validate the card
		String pin = UserInput.getString("PIN: ", Restrictions.pin());
		card.setPin(pin);
		
		InputRestrictionResult result = null;
	
		// if it's valid, continue otherwise abort
		if (getCard() != null && controller.model.isValidCard(getCard())) {
			update(ViewState.CARD_VALID, result);
			update(ViewState.CARD_WITHDRAW_OR_DEPOSIT);
		} else {
			update(ViewState.CARD_INVALID, result);
		}
	}
}