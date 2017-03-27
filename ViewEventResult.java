
public class ViewEventResult {
	private boolean didSucceed = true;
	private String message = "";
	private ViewState newState;
	
	public boolean didSucceed() {
		return didSucceed;
	}
	public void setDidSucceed(boolean didSucceed) {
		this.didSucceed = didSucceed;
	}
	public ViewEventResult(boolean didSucceed, String message) {
		super();
		this.didSucceed = didSucceed;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ViewState getNewState() {
		return newState;
	}
	public void setNewState(ViewState newState) {
		this.newState = newState;
	}
}
