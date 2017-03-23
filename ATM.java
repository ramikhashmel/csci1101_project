import java.util.Scanner;

public class ATM {
	static Scanner kb = new Scanner(System.in);

	// entry point
	public static void main(String[] args) throws Exception {
		
		// create the mvc
		View view = new View();
		Model model = new Model();
		Controller controller = new Controller();

		// register them with each other
		controller.addView(view);
		controller.addModel(model);
		view.addController(controller);

		controller.initialize();
		
		controller.updateView();
	}

}