import java.util.Scanner;

class ATM {
  static final Scanner kb = new Scanner(System.in);
  private static Controller controller;

  public static String getID() {
    return "0078P";
  }

  // entry point
  public static void main(String[] args) throws Exception {

    // create the mvc
    View view = new View();
    Model model = new Model();
    controller = new Controller();

    // register them with each other
    controller.addView(view);
    controller.addModel(model);
    view.addController(controller);

    controller.initialize();
    View.initialize(args);
  }

  public static Controller getController() {
    return controller;
  }
}
