import java.util.Date;

public class Bill {
	int amount;
	String currency;
	int serialNumber;
	boolean isTorn;
	Date dateIssued;

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Date getDateIssued() {
		return dateIssued;
	}

	public boolean getIsTorn() {
		return isTorn;
	}

	public int getSerialNumber() {
		return serialNumber;
	}
}