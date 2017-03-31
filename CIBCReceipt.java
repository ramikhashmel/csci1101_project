/*
 * Creates different types of receipts for different banks
 */
import java.util.Date;

public class CIBCReceipt implements ReceiptFormatter {

  private String machineID = "";
  private Date date;
  private String appID = "";
  private TransactionType transType;
  private Account acc;
  private Transaction trans;
  private int refNumber;
  
  public void setMachineID(String machineID) {
    this.machineID = machineID;
  }

  @Override
  public Date getDate() {
    return date;
  }

  @Override
  public void setDate(Date date) {
    this.date = date;
  }

  public String getAppID() {
    return appID;
  }

  public void setAppID(String appID) {
    this.appID = appID;
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
    sb.append(date.getMonth()).append(date.getDay()).append(" AT ").append(date.getHours());
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

  public void setRefNumber(int refNumber) {
    this.refNumber = refNumber;
  }

  public String getMachineID() {
    return machineID;
  }
}
