// the states that the atm view can be in
public enum ViewState {
	// these should all be set to random numbers, but each state
	// has to be a different number unless they are the same state
	VALID_CARD_SCREEN,
	// when someone turns it on
	STARTING_UP,

	// the screen that gets displayed when nobody is using the machine
	WELCOME_SCREEN_PUBLIC,

	// the card number is invalid
	INVALID_CARD_NUMBER,

	// user entered in the wrong pin
	INVALID_PIN,

	// user entered in the wrong pin more than the maximum amount
	TRIES_EXCEEDED,

	// a general network error occurred
	NETWORK_ERROR,

	// the card is expired
	EXPIRED_CARD,

	// there is no money in the user's account
	NO_MONEY_IN_ACCOUNT,

	// the user's account is frozenm ACCOUNT_FROZEN,

	// when the user inserts their card into the machine
	WELCOME_SCREEN_CARD_AUTH,

	// the screen that asks if the user wants to withdraw or deposit
	CARD_AUTHENTICATED,

	// when the user taps on withdraw
	WITHDRAW_WELCOME,

	// when the user clicks deposit
	DEPOSIT_WELCOME,

	// when the user clicks deposit, and then clicks on get envelope
	DEPOSIT_ENVELOPE,

	DEPOSIT_ENVELOPE_GENERAL_ERROR,

	// there are no envelopes left
	DEPOSIT_ENVELOPE_NO_ENVELOPES_LEFT,

	// tells the user to put all of the money in one envelope, then
	// to press ok to open up the envelope slot
	DEPOSIT_ENVELOPE_CONFIRMATION,

	// something bad happened when withdrawing money
	WITHDRAW_ERROR,

	// the withdraw completed successfullly
	WITHDRAW_SUCCESS,
	DEPOSIT_ERROR,

	// tells the user to remove their card
	REMOVE_CARD,

	// should only be used if none of the other cases apply
	GENERAL_TRANSACTION_ABORTED,

	// the withdraw was aborted
	WITHDRAW_ABORTED,
	DEPOSIT_ABORTED,

	// nothing was in the envelope that was deposited
	EMPTY_ENVELOPE,

	// no money left in ATM
	NO_MONEY_TO_DISPENSE,

	// something happened inside the machine that caused the bill that it was
	// processing to be rejected. The view doesn't have to tell the user this
	INTERNAL_BILL_REJECTED,

	// the user has exceeded their daily withdraw limit
	DAILY_WITHDRAW_EXCEEDED,

	// the user is notified that a $2.50 fee will apply with
	// every transaction
	FEES_WILL_APPLY,
	
	// when the atm successfully authenticates
	CARD_VALID, CARD_WITHDRAW_OR_DEPOSIT,
	
	// something was wrong with the card
	CARD_INVALID;
}
