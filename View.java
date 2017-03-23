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

	public void userPressedEnter() {
		// controller.getData(userInput);
	}
}
