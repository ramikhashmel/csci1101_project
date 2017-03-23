public class Card {
	private int cardNumber;
	private String institution;
	private int expMonth;
	private int expYear;
	private int cvv;

	public int getCardNumber() {
		return cardNumber;
	}

	public String getCvv() {
		return (cvv + "");
	}

	public int getExpMonth() {
		return expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public String getInstitution() {
		return institution;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}
