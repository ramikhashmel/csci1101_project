public class Account {
	private int balance;
	private int accountNumber;
	private int depositNum;
	private String name;
	private String address;
	private Phone phoneNumber;
	private Card card;

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAddress() {
		return address;
	}

	public int getBalance() {
		return balance;
	}

	public Card getCard() {
		return card;
	}

	public int getDepositNum() {
		return depositNum;
	}

	public String getName() {
		return name;
	}

	public Phone getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isValidCard() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setCard(Card card2) {
		// TODO Auto-generated method stub

	}

	public void setDepositNum(int depositNum) {
		this.depositNum = depositNum;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
