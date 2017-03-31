// The vault, where the money is stored and accessed

import java.util.ArrayList;
import java.util.ListIterator;

public class Vault {
  private static ArrayList<Bill> fives = new ArrayList<Bill>();
  private static ArrayList<Bill> tens = new ArrayList<Bill>();
  private static ArrayList<Bill> twenties = new ArrayList<Bill>();
  private static ArrayList<Bill> fifties = new ArrayList<Bill>();

  public static ListIterator<Bill> getFifties(int amt) {
    if (fifties.size() * 50 >= amt) {
      return fifties.listIterator(fifties.size() - amt);
    }
    return null;
  }

  public static ListIterator<Bill> getFives(int amt) {
    if (fives.size() * 5 >= amt) {
      return fives.listIterator(fives.size() - amt);
    }
    return null;
  }

  public static int getNumOfFifties() {
    return fifties.size();
  }

  public static int getNumOfFives() {
    return fives.size();
  }

  public static int getNumOfTens() {
    return tens.size();
  }

  public static int getNumOfTwenties() {
    return twenties.size();
  }

  public static ListIterator<Bill> getTens(int amt) {
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
  public static int getTotal() {
    return (fives.size() * 5 + tens.size() * 10 + twenties.size() * 20 + fifties.size() * 50);
  }

  public static ListIterator<Bill> getTwenties(int amt) {
    if (twenties.size() * 20 >= amt) {
      return twenties.listIterator(twenties.size() - amt);
    }
    return null;
  }

  public static void addFifties(ArrayList<Bill> fifties) {
    Vault.fifties.addAll(fifties);
  }

  public static void addFives(ArrayList<Bill> fives) {
    Vault.fives.addAll(fives);
  }

  public static void addTens(ArrayList<Bill> tens) {
    Vault.tens.addAll(tens);
  }

  public static void addTwenties(ArrayList<Bill> twenties) {
    Vault.twenties.addAll(twenties);
  }

  public boolean withdraw(double amount) {
    // TODO Auto-generated method stub
    return false;
  }
}
