
public class Restrictions {
	static public InputRestriction getCCNumberRestriction() {
		InputRestriction cardNumberRestriction = new InputRestriction();
		cardNumberRestriction.setShouldBeNumeric(true);
		cardNumberRestriction.setMaxLength(16);
		cardNumberRestriction.setMinLength(16);
		return cardNumberRestriction;
	}

	public static InputRestriction getPinRestriction() {
		InputRestriction pinRestriction = new InputRestriction();
		pinRestriction.setShouldBeNumeric(true);
		pinRestriction.setMaxLength(4);
		pinRestriction.setMinLength(4);
		return pinRestriction;
	}
}
