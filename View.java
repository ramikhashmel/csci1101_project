//http://www.austintek.com/mvc/#austintek_mvc.view_2

public class View {
	private Controller controller;

	public View() {
		// initializes the GUI window; attaches buttons to methods
	}

	public void addController(Controller controller) {
		this.controller = controller;

	}

	public void update(Object arg) {
		System.out.println("View      : object passed is " + arg.getClass());
		// then do stuff with arg here
	}

	public void update(ViewState state) {
		// this would fire when the input does not have to be restricted
	}

	public void update(ViewState state, Card card) {
		// update the screen, but have the card information handy to verify with
		// the controller
		// if the card is valid and has enough money
	}

	public void update(ViewState state, InputRestrictionResult result) {
		if (result != null) {
			// use the result to show the error, and the view state to update
			// the state
		} else {
			update(state);
		}
	}

	public void userPressedEnter() {
		// get the data from the controller
	}
}