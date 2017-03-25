public class CustomerTransaction extends Transaction {
	// i.e. withdraw or deposit
	String typeOfTrans = "";

	float amount = 0;

	public Account getAcc() {
		return acc;
	}

	public float getAmount() {
		return amount;
	}

	public String getTypeOfTrans() {
		return typeOfTrans;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setTypeOfTrans(String typeOfTrans) {
		this.typeOfTrans = typeOfTrans;
	}
}
