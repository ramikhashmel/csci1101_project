/*
 * This class allows restrictions to be placed on user input so that
 * the program receives valid data.
 */

public class InputRestriction {
	public static final Object NoRestriction = null;
	private boolean shouldBeNumeric = false;
	private Integer maxLength = null;
	private Integer minLength = null;
	private String errorMsg = null;

	public InputRestriction() {

	}

	// TODO: clean up null reference implementation
	public InputRestriction(Object obj) {

	}

	/**
	 * Checks whether or not the input conforms to the restrictions
	 * 
	 * @param input
	 *            The input
	 * @return The results of the input conformity audit
	 */
	InputRestrictionResult checkConformity(String input) {
		InputRestrictionResult result = new InputRestrictionResult();
		if ((minLength == null || (input.length() >= minLength))
				&& (maxLength == null || (input.length() <= maxLength))) {
			if (shouldBeNumeric) {
				if (input.replaceAll("[^0-9]", "").length() == input.length()) {
					result.setDoesConform(true);
				}
			} else {
				result.setDoesConform(true);
			}
		}

		// if the input conforms, then return the success result
		// otherwise set the error message and return
		if (result.doesConform()) {
			return result;
		} else {
			result.setErrorMessage(errorMsg);
			result.setDoesConform(false);
			return result;
		}
	}

	public void mustBeNumeric() {
		this.shouldBeNumeric = true;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setExactLength(int finalLen) {
		this.maxLength = finalLen;
		this.minLength = finalLen;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public void setShouldBeNumeric(boolean shouldBeNumeric) {
		this.shouldBeNumeric = shouldBeNumeric;
	}

	public class InputRestrictionResult {
		private boolean doesConform = false;
		private boolean shouldDisplayErrorMessage = true;

		private String errorMessage;

		public String getErrorMessage() {
			if (errorMessage != null) {
				return errorMessage;
			} else {
				return "The input does not meet the specified requirements.";
			}
		}

		public boolean isShouldDisplayErrorMessage() {
			return shouldDisplayErrorMessage;
		}

		public void setDoesConform(boolean doesConform) {
			this.doesConform = doesConform;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public void setShouldDisplayErrorMessage(
				boolean shouldDisplayErrorMessage) {
			this.shouldDisplayErrorMessage = shouldDisplayErrorMessage;
		}

		public boolean doesConform() {
			return doesConform;
		}
	}

}
