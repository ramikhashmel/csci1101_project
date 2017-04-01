/*
 * The model, which has most of the validation and logic checking methods
 */
import java.util.ArrayList;

public class Model {
  private static boolean isAuthenticated;
  private ArrayList<Account> accounts;
  private Bank bank;
  private ArrayList<Card> cards;
  private Vault vault;

  public Model() {
    // initialize fields
    this.accounts = new ArrayList<>();
    this.bank = new Bank();
    this.isAuthenticated = false;
    this.cards = new ArrayList();
    this.vault = new Vault();

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

    this.getVault().addTwenties(twenties);
  }

  /**
   * Checks if the card is valid
   *
   * @param card The card
   * @return Whether or not if the card is valid
   */
  public boolean isValidCard(Card card) {
    for (int i = 0; i < getCards().size(); i++) {
      Card dbCards = getCards().get(i);
      if (dbCards.getCardNumber().equals(card.getCardNumber()) && dbCards.getPin().equals(card.getPin())) {
        return true;
      }
    }
    return false;
  }

  public boolean isAuthenticated() {
    return isAuthenticated;
  }

  public void setAuthenticated(boolean isAuthenticated) {
    Model.isAuthenticated = isAuthenticated;
  }

  /**
   * Finds an account from a card
   *
   * @param card The card
   * @return The account associated with the card. If no accounts were found, it returns null
   */
  public Account findAccount(Card card) {
    for (int i = 0; i < accounts.size(); i++) {
      if (accounts.get(i).getCard().equals(card)) {
        return accounts.get(i);
      }
    }
    return null;
  }

  public ViewEventResult verifyCCNumber(String ccNumber, String pin, Controller controller) {
    Card card = new Card();
    card.setNumber(ccNumber);
    card.setPin(pin);

    if (isValidCard(card)) {
      return new ViewEventResult(true, "Card is valid");
    } else {
      return new ViewEventResult(false, "Card is invalid, try again.");
    }
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public Vault getVault() {
    return vault;
  }

  public void setVault(Vault vault) {
    this.vault = vault;
  }

  public void writeTransactionToFile(Transaction trans) {}

  public ArrayList<Card> getCards() {
    return cards;
  }
}
