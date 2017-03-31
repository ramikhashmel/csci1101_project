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
