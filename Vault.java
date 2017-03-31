// The vault, where the money is stored and accessed

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Vault {
  private ArrayList<Bill> fives = new ArrayList<>();
  private ArrayList<Bill> tens = new ArrayList<>();
  private ArrayList<Bill> twenties = new ArrayList<>();
  private ArrayList<Bill> fifties = new ArrayList<>();

  public ListIterator<Bill> getFifties(int amt) {
    if (fifties.size() * 50 >= amt) {
      return fifties.listIterator(fifties.size() - amt);
    }
    return null;
  }

  public ListIterator<Bill> getFives(int amt) {
    if (fives.size() * 5 >= amt) {
      return fives.listIterator(fives.size() - amt);
    }
    return null;
  }

  public int getNumOfFifties() {
    return fifties.size();
  }

  public int getNumOfFives() {
    return fives.size();
  }

  public int getNumOfTens() {
    return tens.size();
  }

  public int getNumOfTwenties() {
    return twenties.size();
  }

  public ListIterator<Bill> getTens(int amt) {
    if (tens.size() * 10 >= amt) {
      return tens.listIterator(tens.size() - amt);
    }
    return null;
  }

  /**
   * Gets the total dollar value of all of the bills in the vault
   * 
   * @return
   */
  public int getTotal() {
    return (fives.size() * 5 + tens.size() * 10 + twenties.size() * 20 + fifties.size() * 50);
  }

  public ListIterator<Bill> getTwenties(int amt) {
    if (twenties.size() * 20 >= amt) {
      return twenties.listIterator(twenties.size() - amt);
    }
    return null;
  }

  public void addFifties(ArrayList<Bill> fifties) {
    this.fifties.addAll(fifties);
  }

  public void addFives(ArrayList<Bill> fives) {
    this.fives.addAll(fives);
  }

  public void addTens(ArrayList<Bill> tens) {
    this.tens.addAll(tens);
  }

  public void addTwenties(ArrayList<Bill> twenties) {
    this.twenties.addAll(twenties);
  }

  public Iterator<Bill> getDenominationValue(int i) {
    switch (i) {
      case 5:
        return getFives(i);
      case 10:
        return getTens(i);
      case 20:
        return getTwenties(i);
      case 50:
        return getFifties(i);
    }
    return null;
  }
}
