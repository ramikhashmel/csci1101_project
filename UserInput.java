import java.util.ArrayList;
import java.util.Arrays;

public class UserInput {

	private boolean didCancel = false;

	public void cancel() {
		this.didCancel = true;
	}

	public boolean wasCancelled() {
		return this.didCancel;
	}

	public static boolean getBoolean(String string) {
		while (true) {
			String userInput = getString(string);
			ArrayList<String> truthValues = new ArrayList<String>();
			truthValues.addAll(Arrays.asList("true", "yes", "confirm", "positive", "t", "tr", "tru"));

			ArrayList<String> falseValues = new ArrayList<String>();
			falseValues.addAll(Arrays.asList("false", "no", "cancel", "incorrect", "f", "fa", "fal", "fals", "exit", "quit"));

			if (truthValues.contains(userInput)) {
				return true;
			} else if (falseValues.contains(userInput)) {
				return false;
			}
		}
	}

	public static int getInt(String string) {
		return getInt(string, null);
	}

	/**
	 * Asks the user for a number
	 * 
	 * @param msg
	 *            The message to ask the user
	 * @param cvvRestriction
	 * @return The number from the user
	 * @throws Exception
	 */
	// TODO: implement restriction
	public static int getInt(String msg, InputRestriction cvvRestriction) {
		System.out.print(msg);
		return ATM.kb.nextInt();
	}

	/**
	 * Asks the user for any input. Warning: this can include any value,
	 * including an empty string or null
	 * 
	 * @param string
	 *            The message to ask the user when they input a value
	 * @return The value input by the user.
	 */
	private static String getString(String string) {
		return UserInput.getString(string, null);
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
	public static String getString(String msg, InputRestriction restriction) {
		String input = null;
		do {
			System.out.print(msg);
			input = ATM.kb.nextLine();
			if (restriction == null) {
				break;
			}
		} while (!restriction.checkConformity(input).doesConform());

		return input;
	}

}
