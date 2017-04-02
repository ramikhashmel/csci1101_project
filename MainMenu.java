/*
 * The main menu that the user sees after authenticating
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

final class MainMenu implements EventHandler<ActionEvent> {
  private final TextField cardNumberField;
  private final PasswordField pinField;
  private final Text actiontarget;
  private final Controller controller = ATM.getController();

  public static Scene mainMenu;

  MainMenu(TextField cardNumberField, PasswordField pinField, Text actiontarget) {
    this.cardNumberField = cardNumberField;
    this.pinField = pinField;
    this.actiontarget = actiontarget;
  }

  @Override
  public void handle(ActionEvent e) {
    verifyCard(cardNumberField, pinField, actiontarget);

    if (controller.isAuthenticated()) {
      // create a new card from the user entered values
      Card card = new Card();
      card.setNumber(this.cardNumberField.getText());
      card.setPin(this.pinField.getText());

      // lookup the account associated with card
      Account acc = controller.findAccount(card);

      Stage primaryStage = View.primaryStage;
      primaryStage.setTitle(Utilities.ATMName + " - Menu");

      // initialize GUI
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));

      Scene scene = new Scene(grid, 600, 400);

      BorderPane border = new BorderPane();
      border.setPadding(new Insets(20, 0, 20, 20));

      Button accActivity = new Button("Account Activity; Balances");
      Button paymentsTrans = new Button("Payments & Transfers");
      Button moreTrans = new Button("More Transactions");
      Button funcFour = new Button("Func 4");

      accActivity.setMaxWidth(Double.MAX_VALUE);
      paymentsTrans.setMaxWidth(Double.MAX_VALUE);
      moreTrans.setMaxWidth(Double.MAX_VALUE);
      funcFour.setMaxWidth(Double.MAX_VALUE);

      VBox vbButtons = new VBox();
      vbButtons.setSpacing(10);
      vbButtons.setPadding(new Insets(0, 20, 10, 20));
      vbButtons.getChildren().addAll(accActivity, paymentsTrans, moreTrans, funcFour);


      Button cashWithdraw = new Button("Cash Withdrawal");
      Button fastCash = new Button("Fast Cash");
      Button funcThree = new Button("Func 3");
      Button returnCard = new Button("Return Card");

      cashWithdraw.setMaxWidth(Double.MAX_VALUE);
      fastCash.setMaxWidth(Double.MAX_VALUE);
      funcThree.setMaxWidth(Double.MAX_VALUE);
      returnCard.setMaxWidth(Double.MAX_VALUE);


      VBox vbButtons2 = new VBox();
      vbButtons2.setSpacing(10);
      vbButtons2.setPadding(new Insets(0, 20, 10, 0));
      vbButtons2.getChildren().addAll(cashWithdraw, fastCash, funcThree, returnCard);
      Text txt = new Text("What would you like to do today?");
      grid.add(txt, 1, 0);
      grid.add(vbButtons, 0, 0);
      grid.add(vbButtons2, 2, 0);
      cashWithdraw.setOnAction(new WithdrawCash(acc));
      primaryStage.setScene(scene);
      primaryStage.show();
      fastCash.setOnAction(j -> fastCashView());
      returnCard.setOnAction(h -> System.exit(0));


      accActivity.setOnAction(g -> funcFour.setText("" + (acc.getBalance())));
      MainMenu.setScene(scene);
    } else {
      System.out.println("Not authenticated.");
    }
  }

  private static void setScene(Scene scene) {
    MainMenu.mainMenu = scene;
  }

  private Object fastCashView() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Verifies if the card is valid or not
   *  @param cardNumberField The card number
   * @param pinField The pin
   * @param actiontarget What text field to update
   */
  private void verifyCard(final TextField cardNumberField, final PasswordField pinField,
      final Text actiontarget) {
    actiontarget.setFill(Color.BLACK);

    // get the text from the GUI, and see if the pin is valid or not
    ViewEventResult event =
        controller.verifyCCNumber(cardNumberField.getText(), pinField.getText(), View.controller);
    if (event == null || !event.didSucceed()) {
      // card is invalid; clear pin and card number fields
      cardNumberField.clear();
      pinField.clear();
      assert event != null;
      if (event.getMessage() != null) {
        actiontarget.setText(event.getMessage());
      }
      controller.setAuthenticated(false);
    } else {
      // card is valid
      actiontarget.setText(event.getMessage());
      controller.setAuthenticated(true);
    }
  }
}


