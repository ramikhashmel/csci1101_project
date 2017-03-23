import java.util.Scanner;

public class ATM {
	static Scanner kb = new Scanner(System.in);

	/**
	 * Asks the user for any input. Warning: this can include any value,
	 * including an empty string or null
	 * 
	 * @param string
	 *            The message to ask the user when they input a value
	 * @return The value input by the user.
	 */
	private static String askUserForInput(String string) {
		return askUserForInput(string, new InputRestriction(
				InputRestriction.NoRestriction));
	}

	/**
	 * Asks the user for input, with a restriction
	 * 
	 * @param msg
	 *            The message to ask the user
	 * @param restriction
	 *            The restriction which is placed on the input
	 * @return The input from the user, which satisfies the restriction
	 */
	public static String askUserForInput(String msg,
			InputRestriction restriction) {

		String input = null;
		do {
			System.out.print(msg);
			input = kb.nextLine();
		} while (restriction.checkConformity(input).didSucceed());

		return input;
	}

	/**
	 * Asks the user for a number
	 * 
	 * @param msg
	 *            The message to ask the user
	 * @return The number from the user
	 */
	public static float askUserForNumber(String msg) {
		System.out.print(msg);
		return kb.nextFloat();
	}

	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller();

		controller.addView(view);
		controller.addModel(model);
		view.addController(controller);

		InputRestriction cardNumberRestriction = new InputRestriction();
		cardNumberRestriction.setShouldBeNumeric(true);
		cardNumberRestriction.setMaxLength(16);
		cardNumberRestriction.setMinLength(16);

		String cardNumber = askUserForInput("Card Number: ",
				cardNumberRestriction);
		String pin = askUserForInput("PIN: ");
	}
}
