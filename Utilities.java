import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


abstract class Utilities {
  private static final Random rand = new Random();

  public static final boolean isDebugging = true;
  public static final String ATMName = "Brand New ATM";

  // the denominations that the vault can hold
  public static final List<Integer> stdDenominations =
      new ArrayList<>(Arrays.asList(50, 20, 10, 5));

  /**
   * Generates a random credit card number
   * 
   * @return A random credit card number
   */
  static public String genRandCCNumber() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 16; i++) {
      sb.append(randNumber(0, 9));
    }
    return sb.toString();
  }

  /**
   * Generates a random number
   * 
   * @param min The smallest number to generate
   * @param max The maximum number to generate
   * @return A random number between min and max, inclusive
   */
  static public int randNumber(int min, int max) {
    return rand.nextInt(max) + min;
  }

  /**
   * Returns true based the desired probability
   * 
   * @param prob The probability to return true
   * @return True on the desired probability amount
   */
  static public boolean randProbability(double prob) {
    // http://stackoverflow.com/questions/11701399/
    // round to three decimal places; multiply to remove decimal
    double percentProb = (double) Math.round(prob * 1000) / 10;

    return Utilities.randNumber(0, 100) <= Math.round(percentProb);

  }
}
