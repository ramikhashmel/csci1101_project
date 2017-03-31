/*
 * Creates different types of receipts for different banks
 */
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class CIBCReceipt implements ReceiptFormatter {

  private final SimpleDateFormat dateFormat;
  private String machineID = null;
  private Date date;
  private String appID = "";
  private TransactionType transType;
  private Account acc;
  private Transaction trans;
  private Integer refNumber = null;

  public CIBCReceipt() {
    this.machineID = String.valueOf(Utilities.randNumber(1000, 9999));
    this.date = new Date();
    this.appID = String.valueOf(Utilities.randNumber(1000,9999));
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
    StringBuilder sb = new StringBuilder();
    sb.append("Hi ").append(acc.getName().toUpperCase()).append("\n\n");
    sb.append("Here is your recent ATM transaction receipt.\n\n");
    sb.append("MACHINE ID  ").append(this.getMachineID()).append("\n\n");
    sb.append("CARD NUMBER ").append(acc.getCard().getCardNumber().toString()).append("\n\n");
    sb.append(dateFormat.format(date));
    sb.append(":").append(date.getMinutes()).append("   REF # " + this.getRefNumber());
    sb.append("\n\n");
    sb.append(this.getTransType().toString()).append("   $").append(this.trans.getAmount());
    sb.append("\n\n");
    sb.append("FROM CHEQUING   ").append(this.acc.getAccountNumber()).append("\n\n");
    sb.append("ACCOUNT BALANCE $").append(this.acc.getBalance()).append("\n\n");
    sb.append("DAILY CANADIAN CASH LIMIT").append("\n");
    sb.append("REMAINING   $").append(this.acc.getRemainingDailyWithdrawLimit());
    return sb.toString();
  }

  private int getRefNumber() {
    return this.refNumber;
  }

  private String getMachineID() {
    return machineID;
  }
}
