public class Phone {
	private boolean shouldAssumeCanadianCountryCode = false;
	String phoneNumber;

	public Phone(String phoneNumber) {
		phoneNumber.replaceAll("[^0-9]", "");

		this.phoneNumber = phoneNumber;
	}

	public boolean equals(Phone otherPhone) {
		return (otherPhone.getUnformattedPhoneNumber().equals(this.getUnformattedPhoneNumber()));
	}

	/**
	 * Gets the unformatted phone number (only digits)
	 * 
	 * @return The unformatted phone number
	 */
	public String getUnformattedPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Checks if the phone number is a well formatted Canadian phone number
	 * 
	 * @return Whether or not the phone number is well formatted or not
	 */
	public boolean isValid() {
		// e.g. 555-5555, 902-555-5555, or 1-902-555-5555
		return ((phoneNumber.length() == 7) || (phoneNumber.length() == 10) || (phoneNumber.length() == 11));
	}

	/**
	 * Whether or not to assume that the phone number is Canadian or not
	 * 
	 * @param shouldAssumeCanadianCountryCode
	 */
	public void setShouldAssumeCanadianCountryCode(boolean shouldAssumeCanadianCountryCode) {
		this.shouldAssumeCanadianCountryCode = shouldAssumeCanadianCountryCode;
	}

	/**
	 * Whether or not to assume that the phone number is Canadian or not
	 * 
	 * @return Whether to assume or not
	 */
	public boolean shouldAssumeCanadianCountryCode() {
		return shouldAssumeCanadianCountryCode;
	}

	@Override
	public String toString() {
		if (this.shouldAssumeCanadianCountryCode()) {
			phoneNumber = "902" + phoneNumber;
		}
		switch (phoneNumber.length()) {
		case 7: // e.g. 555-5555
			return phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3);
		case 10:
			return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
					+ phoneNumber.substring(6);
		case 11:
			return "+" + phoneNumber.substring(0, 1) + " (" + phoneNumber.substring(1, 4) + ") "
					+ phoneNumber.substring(4, 7) + "-" + phoneNumber.substring(7);
		default:
			return phoneNumber;
		}
	}
}