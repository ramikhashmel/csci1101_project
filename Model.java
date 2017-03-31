/*
 * The model, which has most of the validation and logic checking methods
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Label;

public class Model {
  private static boolean isAuthenticated;
  ArrayList<Card> cards = new ArrayList<Card>();
  // initial balance of $20,000
  int balance = 20000;

  static ArrayList<Account> accounts = new ArrayList<Account>();

  private Controller controller;

  private Vault vault = new Vault();

  public Model() {

    // create a test account
    Account acc = new Account();
    acc.setAccountNumber(12345);
    acc.setBalance(1000);
    acc.setCard(new Card("1234567812341234"));
    acc.setName("Bob Jones");
    accounts.add(acc);

    // create 25 random test cards
    cards.add(new Card("1234567891234567", 359, "1234", "Alex Fifield"));

    for (int i = 0; i < 25; i++) {
      int firstHalf = (int) (Math.random() * 100000000);
      int secondHalf = (int) (Math.random() * 100000000);
      String number = firstHalf + "" + secondHalf;
      cards.add(new Card(number));
    }

    cards.add(new Card("1234567812341234"));

    // fill up vault with twenty twenties
    ArrayList<Bill> twenties = new ArrayList<Bill>();
    for (int i = 0; i < 20; i++) {
      twenties.add(new Bill(20));
    }

    Vault.addTwenties(twenties);
  }

  public void addController(Controller controller) {
    this.controller = controller;
  }

  /**
   * Checks if the card is valid
   * 
   * @param card The card
   * @return Whether or not if the card is valid
   */
  public boolean isValidCard(Card card) {
    for (int i = 0; i < cards.size(); i++) {
      if (card.equals(cards.get(i).getCardNumber())) {
        return true;
      }
    }
    return false;
  }


  /**
   * Checks if the withdraw amount is possible or not, by checking the user's account and how much
   * money is left in the ATM, and what denominations are available.
   * 
   * @param acc The user's account
   * @param withdrawAmt The withdraw amount
   * @return Whether or not the transaction can be completed
   */
  public static boolean checkIfPossibleToWithdraw(Account acc, float withdrawAmt, Label withdraw) {
    if (withdrawAmt != (int) withdrawAmt) {
      withdraw.setText("You cannot withdraw coins. However, you can withdraw " + (int) withdrawAmt
          + " instead.");
      return false;
    } else if (Vault.getTotal() < withdrawAmt) {
      withdraw.setText("The ATM does not have enough money to service your request.");
      return false;
    } else if (withdrawAmt > acc.getRemainingDailyWithdrawLimit()) {
      withdraw.setText("This withdraw would exceed your daily withdraw limit.");
      return false;
    } else
      return uncheckedWithdraw(withdrawAmt, withdraw);
  }

  /**
   * Checks if it is possible to withdraw, but does not check the status of the vault, the user's
   * cash limit, or if the amount is valid
   * 
   * @param withdrawAmt The amount to withdraw
   * @param withdraw The withdraw label
   * @return Whether or not the value can be withdrawn, and if it can, returns the bills that need
   *         to be withdrawn from the vault
   */
  private static boolean uncheckedWithdraw(float withdrawAmt, Label withdraw) {
    // get the data from the vault and see how many of each denomination
    // we have
    Map<Integer, Integer> denominationsAvailable = new HashMap<Integer, Integer>();
    denominationsAvailable.put(50, Vault.getNumOfFifties());
    denominationsAvailable.put(20, Vault.getNumOfTwenties());
    denominationsAvailable.put(10, Vault.getNumOfTens());
    denominationsAvailable.put(5, Vault.getNumOfFives());

    int runningWithdraw = (int) withdrawAmt;

    Map<Integer, Integer> withdrawDenominations = new HashMap<Integer, Integer>();

    /*
     * Iterate through all of the bills, and subtract the largest possible bill as many times as
     * possible from the user's withdraw amount.
     */
    for (int i = 0; i < Utilities.stdDenominations.size(); i++) {
      int currBillVal = Utilities.stdDenominations.get(i);
      int numOfNeededBills = (int) (runningWithdraw / currBillVal);

      if (numOfNeededBills <= denominationsAvailable.get(currBillVal)) {
        withdrawDenominations.put(currBillVal, numOfNeededBills);
        runningWithdraw = runningWithdraw - (numOfNeededBills * currBillVal);
      } else {
        withdrawDenominations.put(currBillVal, 0);
      }
    }

    // if the amount that remains is zero, then we can make a withdraw
    if (runningWithdraw == 0) {
      // user can withdraw money because enough denominations exist
      // calculate how many bills they should withdraw
      System.out.println("$50 x " + withdrawDenominations.get(50));
      System.out.println("$20 x " + withdrawDenominations.get(20));
      System.out.println("$10 x " + withdrawDenominations.get(10));
      System.out.println("$5 x " + withdrawDenominations.get(5));
      return true;
    } else if (runningWithdraw > 0) {
      /*
       * There was a remainder left from calculating the bills, so the remainder cannot be
       * withdrawn. Subtract the remainder from the user's withdraw amount and ask if they'd like to
       * have that out instead.
       */
      withdraw.setText("You can't withdraw that amount. Would you like to withdraw $"
          + (withdrawAmt - runningWithdraw) + " instead?");
      return false;
    } else {
      // there's no money left in the ATM, or a fatal calculation
      // error occurred
      return false;
    }
  }

  public Vault getVault() {
    return vault;
  }

  public static void setAuthenticated(boolean isAuthenticated) {
    Model.isAuthenticated = isAuthenticated;
  }

  public static boolean isAuthenticated() {
    return isAuthenticated;
  }

  /**
   * Finds an account from a card
   * 
   * @param card The card
   * @return The account associated with the card. If no accounts were found, it returns null
   */
  public static Account findAccount(Card card) {
    for (int i = 0; i < accounts.size(); i++) {
      if (accounts.get(i).getCard().equals(card)) {
        return accounts.get(i);
      }
    }
    return null;
  }
}
