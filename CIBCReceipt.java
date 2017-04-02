/*
 * Creates different types of receipts for different banks
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CIBCReceipt implements ReceiptFormatter {

  private final SimpleDateFormat dateFormat;
  private String machineID = null;
  private final Date date;
  private TransactionType transType;
  private Account acc;
  private Transaction trans;
  private Integer refNumber = null;

  public CIBCReceipt() {
    this.machineID = String.valueOf(Utilities.randNumber(1000, 9999));
    this.date = new Date();
    String appID = String.valueOf(Utilities.randNumber(1000, 9999));
    this.refNumber = Utilities.randNumber(100000,9999999);

    // e.g. MAR28 17 AT 16:20
    this.dateFormat = new SimpleDateFormat("MMMdd yy 'AT' HH:mm");
  }
  @Override
  public Date getDate() {
    return date;
  }

  @Override
  public TransactionType getTransType() {
    return transType;
  }

  @Override
  public void setTransType(TransactionType transType) {
    this.transType = transType;
  }

  @Override
  public Account getAcc() {
    return acc;
  }

  @Override
  public void setAcc(Account acc) {
    this.acc = acc;
  }

  public String toString() {
    return "Hi " + acc.getName().toUpperCase() + "\n\n" +
        "Here is your recent ATM transaction receipt.\n\n" +
        "MACHINE ID  " + this.getMachineID() + "\n\n" +
        "CARD NUMBER " + acc.getCard().getCardNumber() + "\n\n" +
        dateFormat.format(date) +
        ":" + Calendar.getInstance().get(Calendar.MINUTE) + "   REF # " + this.getRefNumber() +
        "\n\n" +
        this.getTransType().toString() + "   $" + this.trans.getAmount() +
        "\n\n" +
        "FROM CHEQUING   " + this.acc.getAccountNumber() + "\n\n" +
        "ACCOUNT BALANCE $" + this.acc.getBalance() + "\n\n" +
        "DAILY CANADIAN CASH LIMIT" + "\n" +
        "REMAINING   $" + this.acc.getRemainingDailyWithdrawLimit();
  }

  private int getRefNumber() {
    return this.refNumber;
  }

  private String getMachineID() {
    return machineID;
  }
}
