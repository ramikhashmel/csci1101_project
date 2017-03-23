
public class Restrictions {
	static public InputRestriction getCCNumberRestriction() {
		InputRestriction cardNumberRestriction = new InputRestriction();
		cardNumberRestriction.setShouldBeNumeric(true);
		cardNumberRestriction.setMaxLength(16);
		cardNumberRestriction.setMinLength(16);
		return cardNumberRestriction;
	}

	public static InputRestriction getPinRestriction() {
		// TODO Auto-generated method stub
		return null;
	}
}
