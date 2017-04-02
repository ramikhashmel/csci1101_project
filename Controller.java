public class Controller {
  private View view;
  private Model model;
  CustomerReceipt custReceipt = new CustomerReceipt();

  public void addModel(Model model) {
    this.model = model;
  }

  public void addView(View view) {
    this.view = view;
  }

  public void initialize() {
    view.askUserForCard();
  }

  public boolean isAuthenticated() {
    return model.isAuthenticated();
  }

  public void setAuthenticated(boolean isAuthenticated) {
    model.setAuthenticated(isAuthenticated);
  }

  public Bank getBank() {
    return model.getBank();
  }

  public Vault getVault() {
    return model.getVault();
  }

  public Account findAccount(Card card) {
    return model.findAccount(card);
  }

  public ViewEventResult verifyCCNumber(String text, String text1, Controller controller) {
    return model.verifyCCNumber(text, text1, controller);
  }
}
