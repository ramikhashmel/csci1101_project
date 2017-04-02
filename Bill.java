/*
 * A bill, which contains a value and a serial number. These are deposited from the ATM, and are
 * used in the vault.
 */
public class Bill {
  private final int amount;

  private enum CurrencyType {
    CAD, US
  }

  private CurrencyType currency;
  private final int serialNumber;
  private boolean isTorn;

  @Override
  public String toString() {
    return "Bill [amount=" + amount + ", currency=" + getCurrency() + ", serialNumber="
        + serialNumber + ", isTorn=" + isTorn + "]";
  }

  public Bill(int amount) {
    this.amount = amount;
    serialNumber = Utilities.randNumber(100000, 10000000);

    // a 10% chance the bill is torn
    if (Utilities.randProbability(0.1)) {
      this.isTorn = true;
    }
  }

  public int getAmount() {
    return amount;
  }

  private String getCurrency() {
    return currency.toString();
  }

  public void setCurrency(CurrencyType currency) {
    this.currency = currency;
  }

  public boolean getIsTorn() {
    return isTorn;
  }

  public int getSerialNumber() {
    return serialNumber;
  }
}
