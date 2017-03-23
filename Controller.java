public class Controller {
	Bank bank;
	private View view;
	private Model model;

	public void addModel(Model model) {
		this.model = model;

	}

	public void addView(View view) {
		this.view = view;

	}

	public boolean checkCardLength() {
		return true;
	}

	public boolean checkExpiryDate() {
		return false;

	}

	public boolean checkSum() {
		return false;

	}

	public void dispenseCash() {

	}

	public boolean enoughDigits() {
		return false;

	}

	public boolean enoughMoneyInMachine() {
		return false;

	}

	public boolean validateCard() {
		return false;

	}

	public void writeTransactionToFile(Transaction trans) {
	}
}
