/*
 * Contains information about the bank of the account. Used when printing receipts (so that the
 * receipt format can be identified), and the UI of the app
 */
import java.util.ArrayList;

public class Bank {
  private ArrayList<Account> accounts = new ArrayList<>();
  private String bankName;
  private int bankNumber;
  private int branchCode;

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

}
