/*
 * Manages restrictions, getting, setting, and validating user input based on user-defined rules
 */
import java.util.ArrayList;

class UserInput {
  /**
   * Asks the user for a number
   * 
   * @param msg The message to ask the user
   * @param restriction The restriction
   * @return The number from the user
   */
  public static int getInt(String msg, InputRestriction restriction) {
    System.out.print(msg);
    return ATM.kb.nextInt();
  }

  /**
   * Asks the user for any input. Warning: this can include any value, including an empty string or
   * null
   * 
   * @param string The message to ask the user when they input a value
   * @return The value input by the user.
   */
  private static String getString(String string) {
    return UserInput.getString(string, null);
  }

  /**
   * Asks the user for input, with a restriction
   * 
   * @param msg The message to ask the user
   * @param restriction The restriction which is placed on the input
   * @return The input from the user, which satisfies the restriction
   */
  private static String getString(String msg, InputRestriction restriction) {
    String input;
    do {
      System.out.print(msg);
      input = ATM.kb.nextLine();
      if (restriction == null) {
        break;
      }
    } while (!restriction.checkConformity(input).doesConform());

    return input;
  }
}


/*
 * This class allows restrictions to be placed on user input so that the program receives valid
 * data.
 */

class InputRestriction extends UserInput {
  public static final Object NoRestriction = null;
  private boolean shouldBeNumeric = false;
  private Integer maxLength = null;
  private Integer minLength = null;
  private String errorMsg = null;
  private boolean ignoreWhitespace = true;
  private ArrayList<String> options = new ArrayList<>();

  /**
   * Checks whether or not the input conforms to the restrictions
   * 
   * @param input The input
   * @return The results of the input conformity audit
   */
  InputRestrictionResult checkConformity(String input) {
    InputRestrictionResult result = new InputRestrictionResult();

    if (shouldIgnoreWhitespace()) {
      input = input.trim();
    }

    // if options are set, make sure that the text is contained
    // within one of them
    if (options.size() != 0) {
      if (!options.contains(input)) {
        result.setDoesConform(false);
        return result;
      }
    }

    if ((minLength == null || (input.length() >= minLength))
        && (maxLength == null || (input.length() <= maxLength))) {
      if (shouldBeNumeric) {
        if (input.replaceAll("[^0-9]", "").length() == input.length()) {
          result.setDoesConform(true);
        }
      } else {
        result.setDoesConform(true);
      }
    }

    // if the input conforms, then return the success result
    // otherwise set the error message and return
    if (result.doesConform()) {
      return result;
    } else {
      result.setErrorMessage(errorMsg);
      result.setDoesConform(false);
      return result;
    }
  }

  /**
   * The error message to return if the user did not enter in the right data
   * 
   * @param errorMsg The error message
   */
  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  /**
   * Forces the input to be a certain length; otherwise an error occurs and the user must reinput
   * their value
   * 
   * @param exactLen The exact length of the text
   */
  public void setExactLength(int exactLen) {
    this.maxLength = exactLen;
    this.minLength = exactLen;
  }

  /**
   * The maximum length of the text
   * 
   * @param maxLength The max length of the text (in characters)
   */
  void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * The minimum length of the text
   * 
   * @param minLength The minimum length of the text (in characters)
   */
  void setMinLength(int minLength) {
    this.minLength = minLength;
  }

  /**
   * @param shouldBeNumeric Whether or not the input should be numeric
   */
  void setShouldBeNumeric(boolean shouldBeNumeric) {
    this.shouldBeNumeric = shouldBeNumeric;
  }

  /**
   * Only allows the user to enter in a certain option
   * 
   * @param options The list of options the user can choose from.
   */
  public void setOptions(ArrayList<String> options) {
    if (options.size() > 1) {
      this.options = options;
    } else {
      System.out.println("Options not set. Min length is two.");
    }
  }

  /**
   * Removes all options
   */
  public void clearOptions() {
    this.options.clear();
  }

  private boolean shouldIgnoreWhitespace() {
    return ignoreWhitespace;
  }

  public void setShouldIgnoreWhitespace(boolean ignoreWhitespace) {
    this.ignoreWhitespace = ignoreWhitespace;
  }

  public class InputRestrictionResult {
    private boolean doesConform = false;
    private boolean shouldDisplayErrorMessage = true;

    private String errorMessage;

    public String getErrorMessage() {
      if (errorMessage != null) {
        return errorMessage;
      } else {
        return "The input does not meet the specified requirements.";
      }
    }

    /*
     * Whether or not to display the error message
     */
    public boolean isShouldDisplayErrorMessage() {
      return shouldDisplayErrorMessage;
    }

    public void setDoesConform(boolean doesConform) {
      this.doesConform = doesConform;
    }

    public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
    }

    public void setShouldDisplayErrorMessage(boolean shouldDisplayErrorMessage) {
      this.shouldDisplayErrorMessage = shouldDisplayErrorMessage;
    }

    public boolean doesConform() {
      return doesConform;
    }
  }

}


/*
 * This class provides common restrictions for keyboard input. For example, the credit card
 * restriction only allows 16 numbers. The pin restriction only allows four numbers.
 */
abstract class Restrictions extends InputRestriction {
  /*
   * The input restriction for asking the user for their card number (has to be exactly 16 digits)
   */
  static public InputRestriction CCNumber() {
    InputRestriction cardNumberRestriction = new InputRestriction();
    cardNumberRestriction.setShouldBeNumeric(true);
    cardNumberRestriction.setMaxLength(16);
    cardNumberRestriction.setMinLength(16);
    return cardNumberRestriction;
  }

  /*
   * Input restriction for asking the user for their pin (has to be exactly four digits)
   */
  static public InputRestriction pin() {
    InputRestriction pinRestriction = new InputRestriction();
    pinRestriction.setShouldBeNumeric(true);
    pinRestriction.setMaxLength(4);
    pinRestriction.setMinLength(4);
    return pinRestriction;
  }
}

