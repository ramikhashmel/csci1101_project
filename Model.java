import java.util.ArrayList;

public class Model {
	ArrayList<Card> cards = new ArrayList<Card>();
	int balance;
	private Controller controller;

	public Model() {
		// read the credit card numbers from the file
	}

	public void addController(Controller controller) {
		this.controller = controller;
	}

	public void aggregateFromAccount() {

	}

	public boolean checkAuthencity() {
		return false;
	}

	public void checkIfPossibleToWithdraw() {

	}

	public void dispenseMoney() {

	}

	public boolean isValidCard(Card card) {
		return false;
	}

	public void validateCardWithBank() {

	}

	public void validateDataFromAccount() {

	}
}
