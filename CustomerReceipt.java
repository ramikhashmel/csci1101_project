import java.util.ArrayList;

/*
 * Prints out the receipt to the user, includes last four digits of CC number, and very generalized
 * information. Does not include whether or not any bills were stuck in the machine, or how much
 * money is left in the machine, for example. Also thanks the customer for using the ATM.
 */

class CustomerReceipt {
  private final ArrayList<CustomerTransaction> transactions = new ArrayList<>();

  /**
   * Adds a transaction to the end of the receipt
   * 
   * @param transaction The transaction to add
   */
  public void addTransaction(CustomerTransaction transaction) {
    transactions.add(transaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Here's your receipt:\n");
    for (CustomerTransaction transaction : transactions) {
      sb.append(transaction.toString());
    }

    sb.append("\nPrinted on: <date today>\nThank you for using " + Utilities.ATMName);
    return sb.toString();
  }
}
