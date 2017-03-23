import java.util.Scanner;

public class ATM {
	static Scanner kb = new Scanner(System.in);

	// entry point
	public static void main(String[] args) throws Exception {
		
		// create the mvc
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller();

		// register them with each other
		controller.addView(view);
		controller.addModel(model);
		view.addController(controller);

		// create new account, and ask user for a card number
		Account acc = new Account();
		String cardNumber = UserInput.getString("Card Number: ", Restrictions.getCCNumberRestriction());

		Card card = new Card();
		card.setNumber(cardNumber);

		// get pin, and try to validate the card
		String pin = UserInput.getString("PIN: ", Restrictions.getPinRestriction());

		InputRestrictionResult result = null;
		ViewState state = new ViewState();

		// if it's valid, continue otherwise abort
		if (model.isValidCard(card)) {
			view.update(ViewState.CARD_VALID, result);
			view.update(ViewState.CARD_WITHDRAW_OR_DEPOSIT);
		} else {
			view.update(ViewState.CARD_INVALID, result);
		}
	}

}