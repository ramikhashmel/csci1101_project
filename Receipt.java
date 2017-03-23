import java.util.ArrayList;

public class Receipt {
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	public void addTransaction(Transaction transaction) {
		// append date to every transaction
		transactions.add(transaction);
	}

	// default toString but we need to override it
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < transactions.size(); i++) {
			sb.append(transactions.get(i).toString() + "\n");
		}
		return sb.toString();
	}
}
