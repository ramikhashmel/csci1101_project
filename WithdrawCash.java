import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaException;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WithdrawCash implements EventHandler<ActionEvent> {

  private final Account acc;
  private Controller controller = ATM.getController();

  WithdrawCash(Account acc) {
    this.acc = acc;
  }

  /**
   * Checks if the withdraw amount is possible or not, by checking the user's account and how much
   * money is left in the ATM, and what denominations are available.
   *
   * @param acc The user's account
   * @param withdrawAmt The withdraw amount
   * @return Whether or not the transaction can be completed
   */
  public WithdrawResult checkIfPossibleToWithdraw(Account acc, float withdrawAmt, Label withdraw) {
    WithdrawResult result = new WithdrawResult();
    if (withdrawAmt != (int) withdrawAmt) {
      result.setErrorMessage(String
          .format("You cannot withdraw coins. However, you can withdraw %d instead.", withdrawAmt));
      return result;
    } else if (controller.getVault().getTotal() < withdrawAmt) {
      result.setErrorMessage("The ATM does not have enough money to service your request.");
      return result;
    } else if (withdrawAmt > acc.getRemainingDailyWithdrawLimit()) {
      result.setErrorMessage("This withdraw would exceed your daily withdraw limit.");
      return result;
    } else
      return uncheckedWithdraw(withdrawAmt);
  }

  /**
   * Checks if it is possible to withdraw, but does not check the status of the vault, the user's
   * cash limit, or if the amount is valid
   *
   * @param withdrawAmt The amount to withdraw
   * @return Whether or not the value can be withdrawn, and if it can, returns the bills that need
   *         to be withdrawn from the vault
   */
  private WithdrawResult uncheckedWithdraw(float withdrawAmt) {
    WithdrawResult result = new WithdrawResult();

    // get the data from the vault and see how many of each denomination
    // we have
    Map<Integer, Integer> denominationsAvailable = new HashMap<>();
    denominationsAvailable.put(50, controller.getVault().getNumOfFifties());
    denominationsAvailable.put(20, controller.getVault().getNumOfTwenties());
    denominationsAvailable.put(10, controller.getVault().getNumOfTens());
    denominationsAvailable.put(5, controller.getVault().getNumOfFives());

    int runningWithdraw = (int) withdrawAmt;

    Map<Integer, Integer> withdrawDenominations = new HashMap<>();

    /*
     * Iterate through all of the bills, and subtract the largest possible bill as many times as
     * possible from the user's withdraw amount.
     */
    for (int i = 0; i < Utilities.stdDenominations.size(); i++) {
      int currBillVal = Utilities.stdDenominations.get(i);
      int numOfNeededBills = runningWithdraw / currBillVal;

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
      result.setWithdrawAmount(withdrawDenominations);
      System.out.println("$50 x " + withdrawDenominations.get(50));
      System.out.println("$20 x " + withdrawDenominations.get(20));
      System.out.println("$10 x " + withdrawDenominations.get(10));
      System.out.println("$5 x " + withdrawDenominations.get(5));
      result.setDidSucceed(true);
      return result;
    } else if (runningWithdraw > 0) {
      /*
       * There was a remainder left from calculating the bills, so the remainder cannot be
       * withdrawn. Subtract the remainder from the user's withdraw amount and ask if they'd like to
       * have that out instead.
       */
      result.setErrorMessage("You can't withdraw that amount. Would you like to withdraw $"
          + (withdrawAmt - runningWithdraw) + " instead?");
      return result;
    } else {
      // there's no money left in the ATM, or a fatal calculation
      // error occurred
      result.setErrorMessage("An unknown error occurred.");
      return result;
    }
  }

  @Override
  public void handle(ActionEvent e) {
    Stage primaryStage = View.primaryStage;

    primaryStage.setTitle(Utilities.ATMName + " - Withdrawal");

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Scene scene = new Scene(grid, 600, 400);

    Text scenetitle = new Text("How much would you like to withdraw?");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 2, 1);

    Label withdrawAmount = new Label("Amount in dollars");
    grid.add(withdrawAmount, 0, 1);

    final TextField withdrawAmountField = new TextField();
    grid.add(withdrawAmountField, 1, 1);

    Button withdrawButton = new Button("Go");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(withdrawButton);
    grid.add(hbBtn, 1, 4);

    Button returnCard = new Button("Return Card");
    grid.add(returnCard, 2, 0);

    final Text actiontarget = new Text();
    grid.add(actiontarget, 1, 6);

    returnCard.setOnAction(new ExitScreen());

    if (withdrawAmountField.getLength() != 0) {
    }

    withdrawButton.setOnAction(f -> {
      try {
        withdrawFunds(Float.valueOf(withdrawAmountField.getText()), acc, withdrawAmount);
      } catch (NumberFormatException e1) {
        System.out.println("The number was formatted incorrectly.");
        e1.printStackTrace();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    });
    returnCard.setOnAction(h -> System.exit(0));
    primaryStage.setScene(scene);
    primaryStage.show();
  }


  private EventHandler<ActionEvent> withdrawFunds(float withdrawAmt, Account acc,
      Label withdrawAmount) throws IOException {
    if (acc != null) {
      WithdrawResult result = checkIfPossibleToWithdraw(acc, withdrawAmt, withdrawAmount);
      if (result.didSucceed())
        dispenseCash(withdrawAmt, result);
      else
        withdrawAmount.setText(result.getErrorMessage());
    }
    return null;
  }

  private void dispenseCash(float withdrawAmt, WithdrawResult result) {
    this.acc.setBalance(this.acc.getBalance() - withdrawAmt);
    // http://stackoverflow.com/questions/24097059/

    for (int i : result.getWithdrawAmount().keySet()) {
      for (Iterator<Bill> billsIter = controller.getVault().getDenominationValue(i); billsIter.hasNext(); ) {
        Bill item = billsIter.next();
        System.out.println(item.toString() + " bill being dispensed...");
        billsIter.remove();
      }
    }
    playAudioFromURL("https://www.freesound.org/data/previews/41/41195_266274-lq.mp3");

    System.out.println("Money dispensed.");
    View.primaryStage.setScene(MainMenu.mainMenu);
  }

  private void playAudioFromURL(String clipURL) {
    try {
      AudioClip audio = new AudioClip(clipURL);
      audio.play();
    } catch (MediaException e) {
      System.out.println("The audio could not be played because " + e.getMessage());
    }
  }
}
