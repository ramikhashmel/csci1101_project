/*
 * The card that the user uses to authenticate to the ATM.
 */
public class Card {
  private String cardNumber;
  private String institution;

  private int cvv;
  private String pin;

  private String cardholderName;

  public Card() {

  }

  public Card(String string) {
    this.cardNumber = string;
  }

  public Card(String cardNumber, int cvv, String pin, String cardholderName) {
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    this.pin = pin;
    this.cardholderName = cardholderName;
  }

  public boolean equals(Card obj) {
    return (cardNumber.equals(obj.cardNumber));
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public String getCvv() {
    return (cvv + "");
  }

  public String getInstitution() {
    return institution;
  }

  public String getName() {
    return cardholderName;
  }

  public String getPin() {
    return pin;
  }

  public void setCvv(int cvv) {
    this.cvv = cvv;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public void setName(String cardholderName) {
    this.cardholderName = cardholderName;
  }

  public void setNumber(String cardNumber) {
    this.cardNumber = cardNumber;

  }

  public void setPin(String string) {
    this.pin = string;
  }
}
