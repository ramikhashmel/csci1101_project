/*
 * Prints out the receipt to the user, includes last four digits of CC number, and 
 * very generalized information. Does not include whether or not any bills were
 * stuck in the machine, or how much money is left in the machine, for example.
 * Also thanks the customer for using the ATM.
 */

public class CustomerReceipt extends Receipt {

	public CustomerReceipt() {

	}

	// would never have full access to the card object
	// not necessary
	public int lastFourDigitsOfCard() {
		return 0;
	}

	@Override
	public String toString() {
		return "Here's your receipt:\n" + super.toString() + "\nPrinted on: <date today>\nThank you for using "
				+ Utilities.ATMName;

	}
}