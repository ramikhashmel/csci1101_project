import java.util.Map;

/**
 * Returns whether the result succeeded, and if so, what denominations
 * to withdraw from the vault
 */
public class WithdrawResult {
  private boolean didSucceed = false;
  private Map<Integer,Integer> withdrawAmount;
  private String errorMessage = null;

  public WithdrawResult() {

  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setDidSucceed(boolean didSucceed) {
    this.didSucceed = didSucceed;
  }

  public boolean didSucceed() {
    return didSucceed;
  }

  public Map<Integer, Integer> getWithdrawAmount() {
    return this.withdrawAmount;
  }

  public void setWithdrawAmount(Map<Integer,Integer> withdrawAmount) {
    this.withdrawAmount = withdrawAmount;
  }
}
