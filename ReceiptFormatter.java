import java.util.Date;

public class ReceiptFormatter {
  /*
   * The type of receipt based on the bank
   */
  public enum Format {
    BMO, CIBC, TD, SCOTIABANK, TANGERINE
  }

  public enum TransactionType {
    INQUIRY, WITHDRAW, TRANSFER
  }

  private String machineID = "";
  private Date date;
  private String appID = "";
  private TransactionType transType;
  private Account acc;
  private Transaction trans;
  @SuppressWarnings("unused")
  private int refNumber;

  public String getMachineID() {
    return machineID;
  }

  public void setMachineID(String machineID) {
    this.machineID = machineID;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getAppID() {
    return appID;
  }

  public void setAppID(String appID) {
    this.appID = appID;
  }

  public TransactionType getTransType() {
    return transType;
  }

  public void setTransType(TransactionType transType) {
    this.transType = transType;
  }

  public Account getAcc() {
    return acc;
  }

  public void setAcc(Account acc) {
    this.acc = acc;
  }

  @SuppressWarnings("deprecation")
  public String getCIBCReceipt() {
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
    sb.append("REMAINING   $").append(this.acc.getCashLimitRemaining());
    return sb.toString();
  }

  private String getRefNumber() {
    // TODO Auto-generated method stub
    return null;
  }

  public void setRefNumber(int refNumber) {
    this.refNumber = refNumber;
  }
}
