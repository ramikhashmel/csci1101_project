// the states that the atm view can be in
public enum ViewState {
	// when the program starts for the first time (when it is idle and no
	// account has been entered)
	WELCOME_SCREEN_PUBLIC,

	// the card number is invalid
	INVALID_CARD_NUMBER,

	// user entered in the wrong pin
	INVALID_PIN,

	// user entered in the wrong pin more than the maximum amount
	TRIES_EXCEEDED,

	// there is no money in the user's account
	NO_MONEY_IN_ACCOUNT,

	// when the user inserts their card into the machine and is prompted
	// to enter in their pin
	WELCOME_SCREEN_CARD_AUTH,

	// the screen that asks if the user wants to withdraw or deposit, given
	// that they entered in the correct pin
	CARD_AUTHENTICATED,

	// when the user taps on withdraw
	WITHDRAW_WELCOME,

	// when the user clicks deposit
	DEPOSIT_WELCOME,

	// tells the user to put all of the money in one envelope, then
	// to press ok to open up the envelope slot
	DEPOSIT_ENVELOPE_CONFIRMATION,

	// any error with withdrawing
	WITHDRAW_ERROR,
	
	// an error with depositing
	DEPOSIT_ERROR,
	
	// the withdraw completed successfully
	WITHDRAW_SUCCESS,

	// tells the user to remove their card when they dip it
	// into the reader and it has been read
	REMOVE_CARD,

	// should only be used if none of the other cases apply
	GENERAL_TRANSACTION_ABORTED,

	// the withdraw was aborted
	WITHDRAW_ABORTED,
	DEPOSIT_ABORTED,

	// no money left, there is not enough money to complete the
	// transaction, or there is not the proper denomination available
	// to complete the transaction from the ATM's vault
	NO_MONEY_TO_DISPENSE,

	// something happened inside the machine that caused the bill that it was
	// processing to be rejected. This is only an issue if there are not enough
	// bills to complete the transaction
	INTERNAL_BILL_REJECTED,

	// the user has exceeded their daily withdraw limit
	DAILY_WITHDRAW_EXCEEDED,

	// the user is notified that a $2.50 fee will apply with
	// every transaction
	FEES_WILL_APPLY,
	
	// when the atm successfully authenticates
	CARD_VALID,
	
	// the card could not be read properly
	CARD_INVALID;
}
