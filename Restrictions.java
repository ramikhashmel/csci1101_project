/*
 * This class provides common restrictions for keyboard input. For example,
 * the credit card restriction only allows 16 numbers. The pin restriction
 * only allows four numbers.
 */
public class Restrictions {
	/*
	 * The input restriction for asking the user for their card number
	 * (has to be exactly 16 digits)
	 */
	static public InputRestriction CCNumber() {
		InputRestriction cardNumberRestriction = new InputRestriction();
		cardNumberRestriction.setShouldBeNumeric(true);
		cardNumberRestriction.setMaxLength(16);
		cardNumberRestriction.setMinLength(16);
		return cardNumberRestriction;
	}

	/*
	 * Input restriction for asking the user for their pin
	 * (has to be exactly four digits)
	 */
	static public InputRestriction pin() {
		InputRestriction pinRestriction = new InputRestriction();
		pinRestriction.setShouldBeNumeric(true);
		pinRestriction.setMaxLength(4);
		pinRestriction.setMinLength(4);
		return pinRestriction;
	}
}
