public class Card {
	private String cardNumber;
	private String institution;

	private int cvv;
	private String pin;

	private boolean isDebit;

	@Override
	public boolean equals(Object obj) {
		Card other = (Card) obj;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardholderName == null) {
			if (other.cardholderName != null)
				return false;
		} else if (!cardholderName.equals(other.cardholderName))
			return false;
		if (cvv != other.cvv)
			return false;
		if (institution == null) {
			if (other.institution != null)
				return false;
		} else if (!institution.equals(other.institution))
			return false;
		return true;
	}

	private String cardholderName;

	public Card() {

	}
	public Card(String cardNumber, int cvv, String pin, String cardholderName) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.pin = pin;
		this.cardholderName = cardholderName;
	}

	public Card(String string) {
		this.cardNumber = string;
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

	public String getPin() {
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

	public void setPin(String string) {
		this.pin = string;
	}
	
	public void setNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		
	}
}
