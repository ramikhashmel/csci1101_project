public class InputRestrictionResult {
	private boolean doesConform = false;
	private boolean shouldDisplayErrorMessage = true;

	private String errorMessage;

	public boolean didSucceed() {
		// TODO Auto-generated method stub
		return doesConform();
	}

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

	public void setShouldDisplayErrorMessage(boolean shouldDisplayErrorMessage) {
		this.shouldDisplayErrorMessage = shouldDisplayErrorMessage;
	}

	public boolean doesConform() {
		return doesConform;
	}
}
