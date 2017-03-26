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
			model.openOutputDrawer();
			// wait a few seconds
			model.closeOutputDrawer();
		} else {
			view.update(ViewState.WITHDRAW_ERROR);
		}
	}

	public void writeTransactionToFile(Transaction trans) {
	}

	/**
	 * @param view
	 * @param model
	 * @param view TODO
	 * @deprecated Use {@link View#askUserForCard()} instead
	 */
	public void checkCard(View view) {
		view.askUserForCard();
	}

	public void initialize() {
		view.askUserForCard();
		
	}
}