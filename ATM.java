import java.util.Scanner;

public class ATM {
	static Scanner kb = new Scanner(System.in);

	// entry point
	public static void main(String[] args) throws Exception {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller();

		controller.addView(view);
		controller.addModel(model);
		view.addController(controller);

		Account acc = new Account();
		String cardNumber = UserInput.getString("Card Number: ", null);

		Card card = new Card();
		card.setNumber(Integer.parseInt(cardNumber));

		String pin = UserInput.getString("PIN: ", Restrictions.getPinRestriction());

		InputRestrictionResult result = null;
		ViewState state = new ViewState();

		if (model.isValidCard(card)) {
			view.update(ViewState.CARD_VALID, result);
			view.update(ViewState.CARD_WITHDRAW_OR_DEPOSIT);
		} else {
			view.update(ViewState.CARD_INVALID, result);
		}
	}

}