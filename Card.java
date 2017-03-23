public class Card {
	private String cardNumber;
	private String institution;

	private int cvv;
	private int pin;

	private boolean isDebit;

	private String cardholderName;

	public Card() {

	}
	public Card(String cardNumber, int cvv, int pin, String cardholderName) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.pin = pin;
		this.cardholderName = cardholderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvv() {
		return (cvv + "");
	}

	public String getInstitution() {
		return institution;
	}

	public String getName() {
		return cardholderName;
	}

	public int getPin() {
		return pin;
	}

	public boolean isDebit() {
		return isDebit;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void setDebit(boolean isDebit) {
		this.isDebit = isDebit;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public void setName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public void setNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		
	}
}
