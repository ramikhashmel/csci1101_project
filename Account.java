public class Account {
	private int balance;
	private int cardNumber;
	private int accountNumber;
	private int depositNum;
	private String name;
	private String address;
	private Phone phoneNumber;

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAddress() {
		return address;
	}

	public int getBalance() {
		return balance;
	}

	public int getCardNumber() {
		return cardNumber;
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

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
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
