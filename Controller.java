public class Controller {
  View view;
  Model model;
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

  public void setBank(Bank bank) {
    model.setBank(bank);
  }

  public Vault getVault() {
    return model.getVault();
  }

  public void setVault(Vault vault) {
    model.setVault(vault);
  }

  public Account findAccount(Card card) {
    return model.findAccount(card);
  }

  public ViewEventResult verifyCCNumber(String text, String text1, Controller controller) {
    return model.verifyCCNumber(text, text1, controller);
  }
}
