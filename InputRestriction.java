import java.util.ArrayList;

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
	private ArrayList<String> options = new ArrayList<String>();

	/**
	 * Checks whether or not the input conforms to the restrictions
	 * 
	 * @param input
	 *            The input
	 * @return The results of the input conformity audit
	 */
	InputRestrictionResult checkConformity(String input) {
		InputRestrictionResult result = new InputRestrictionResult();
		
		// if options are set, make sure that the text is contained
		// within one of them
		if (options.size() != 0) {
			if (!options.contains(input)) {
				result.setDoesConform(false);
				return result;
			}
		}
		
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

	/**
	 * The error message to return if the user did not enter
	 * in the right data
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Forces the input to be a certain length; otherwise
	 * an error occurs and the user must reinput their value
	 * @param exactLen The exact length of the text
	 */
	public void setExactLength(int exactLen) {
		this.maxLength = exactLen;
		this.minLength = exactLen;
	}

	/**
	 * The maximum length of the text
	 * @param maxLength The max length of the text (in characters)
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * The minimum length of the text
	 * @param minLength The minimum length of the text (in characters)
	 */
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	/**
	 * @param shouldBeNumeric
	 */
	public void setShouldBeNumeric(boolean shouldBeNumeric) {
		this.shouldBeNumeric = shouldBeNumeric;
	}

	/**
	 * Only allows the user to enter in a certain option
	 * @param options The list of options the user can choose from.
	 */
	public void setOptions(ArrayList<String> options) {
		if (options.size() > 1) {
			this.options  = options;
		} else {
			System.out.println("Options not set. Min length is two.");
		}
	}
	
	/**
	 * Removes all options
	 */
	public void clearOptions() {
		this.options.clear();
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

		/*
		 * Whether or not to display the error message
		 */
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
