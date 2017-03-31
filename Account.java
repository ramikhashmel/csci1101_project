/*
 * This is the bank account of the user
 */
public class Account {
  private float balance;
  private int accountNumber;
  private int depositNum;
  private String name;
  private Card card;
  private ContactInformation contactInfo;

  private int dailyWithdrawLimit;

  public int getAccountNumber() {
    return accountNumber;
  }

  public float getBalance() {
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

  public void setBalance(float balance) {
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

  public void setDailyWithdrawLimit(int limit) {
    this.dailyWithdrawLimit = limit;
  }

  public int getRemainingDailyWithdrawLimit() {
    return dailyWithdrawLimit;
  }

  public ContactInformation getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(ContactInformation contactInfo) {
    this.contactInfo = contactInfo;
  }
}
