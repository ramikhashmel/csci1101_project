public class Account {
  private int balance;
  private int accountNumber;
  private int depositNum;
  private String name;
  private Card card;
  private ContactInformation contactInfo;

  private int limit;

  public int getAccountNumber() {
    return accountNumber;
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

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setCard(Card card2) {
    this.card = card2;
  }

  public void setDepositNum(int depositNum) {
    this.depositNum = depositNum;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCashLimit(int limit) {
    this.limit = limit;
  }

  public int getCashLimitRemaining() {
    return limit;
  }
}
