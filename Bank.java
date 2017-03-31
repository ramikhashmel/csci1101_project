/*
 * Contains information about the bank of the account. Used when printing receipts (so that the
 * receipt format can be identified), and the UI of the app
 */
import java.util.ArrayList;

public class Bank {
  ArrayList<Account> accounts = new ArrayList<Account>();
  String bankName;
  int bankNumber;
  int branchCode;

  public ArrayList<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(ArrayList<Account> accounts) {
    this.accounts = accounts;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public int getBankNumber() {
    return bankNumber;
  }

  public void setBankNumber(int bankNumber) {
    this.bankNumber = bankNumber;
  }

  public int getBranchCode() {
    return branchCode;
  }

  public void setBranchCode(int branchCode) {
    this.branchCode = branchCode;
  }

  /**

   * Transfers the money from one account to another one
   */
  /**
   * @param source The source account
   * @param dest The destination account
   */
  public void transfer(Account source, Account dest) {

  }
}
