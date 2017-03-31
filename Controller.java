public class Controller {
  Bank bank;
  View view;
  Model model;
  CustomerReceipt custReceipt = new CustomerReceipt();

  public void addModel(Model model) {
    this.model = model;
  }

  public void addView(View view) {
    this.view = view;
  }

  public void dispenseCash(double amount) {
    if (model.getVault().withdraw(amount)) {
      view.update(ViewState.WITHDRAW_SUCCESS);
    } else {
      view.update(ViewState.WITHDRAW_ERROR);
    }
  }

  public ViewEventResult verifyCCNumber(String ccNumber, String pin) {
    Card card = new Card();
    card.setNumber(ccNumber);
    card.setPin(pin);

    if (model.isValidCard(card)) {
      return new ViewEventResult(true, "Card is valid");
    } else {
      return new ViewEventResult(false, "Card is invalid, try again.");
    }
  }

  public void writeTransactionToFile(Transaction trans) {}

  public void initialize() {
    view.askUserForCard();
  }
}
