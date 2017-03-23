public class ViewState {
	// when someone turns it on
	public int STARTING_UP;

	// the screen that gets displayed when nobody is using the machine
	public int WELCOME_SCREEN_PUBLIC;

	// the card number is invalid
	public int INVALID_CARD_NUMBER;

	// user entered in the wrong pin
	public int INVALID_PIN;

	// user entered in the wrong pin more than the maximum amount
	public int TRIES_EXCEEDED;

	// a general network error occured
	public int NETWORK_ERROR;

	// the card is expired
	public int EXPIRED_CARD;

	// there is no money in the user's account
	public int NO_MONEY_IN_ACCOUNT;

	// the user's account is frozen
	public int ACCOUNT_FROZEN;

	// when the user inserts their card into the machine
	public int WELCOME_SCREEN_CARD_AUTH;

	// the screen that asks if the user wants to withdraw or deposit
	public int CARD_AUTHENTICATED;

	// when the user taps on withdraw
	public int WITHDRAW_WELCOME;

	// when the user clicks deposit
	public int DEPOSIT_WELCOME;

	// when the user clicks deposit, and then clicks on get envelope
	public int DEPOSIT_ENVELOPE;

	public int DEPOSIT_ENVELOPE_GENERAL_ERROR;

	// there are no envelopes left
	public int DEPOSIT_ENVELOPE_NO_ENVELOPES_LEFT;

	// tells the user to put all of the money in one envelope, then
	// to press ok to open up the envelope slot
	public int DEPOSIT_ENVELOPE_CONFIRMATION;

	// something bad happened when withdrawing money
	public int WITHDRAW_ERROR;

	// the withdraw completed successfullly
	public int WITHDRAW_SUCCESS;
	public int DEPOSIT_ERROR;

	// tells the user to remove their card
	public int REMOVE_CARD;

	// should only be used if none of the other cases apply
	public int GENERAL_TRANSACTION_ABORTED;

	// the withdraw was aborted
	public int WITHDRAW_ABORTED;
	public int DEPOSIT_ABORTED;

	public int EMPTY_ENVELOPE;

	// no money left in ATM
	public int NO_MONEY_TO_DISPENSE;

	// something happened inside the machine that caused the bill that it was
	// processing to be rejected. The view doesn't have to tell the user this
	public int INTERNAL_BILL_REJECTED;

	// the user has exceeded their daily withdraw limit
	public int DAILY_WITHDRAW_EXCEEDED;

	// the user is notified that a $2.50 fee will apply with
	// every transaction
	public int FEES_WILL_APPLY;
}
