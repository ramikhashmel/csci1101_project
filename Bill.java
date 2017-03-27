import java.util.Date;

public class Bill {
	private int amount;
	private String currency;
	private int serialNumber;
	private boolean isTorn;
	private Date dateIssued;

	public Bill(int amount) {
		this.amount = amount;
		serialNumber = Utilities.randNumber(100000, 10000000);
		
		// a 10% chance the bill is torn
		if (Utilities.randProbability(0.1)) {
			this.isTorn = true;
		}
	}
	
	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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