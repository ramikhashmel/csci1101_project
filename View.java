import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// http://www.austintek.com/mvc/#austintek_mvc.view_2

public class View extends Application {
  static public Controller controller;
  public static Stage primaryStage;
  AudioClip audio;
  Button button;

  public static void initialize(String[] args) {
    launch(args);
  }

  Card card;

  public View() {
    // initializes the GUI window; attaches buttons to methods
  }

  public void addController(Controller controller) {
    View.controller = controller;

  }

  /**
   * @param model
   */
  public void askUserForCard() {
    card = new Card();

    update(ViewState.WELCOME_SCREEN_CARD_AUTH);
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  // http://docs.oracle.com/javafx/2/get_started/form.htm#BABDDGEE
  public void start(Stage primaryStage) {

    // String clipURL= "http://www.music.helsinki.fi//tmt/opetus/uusmedia/esim/a2002011001-e02.wav";
    // audio = new AudioClip(clipURL);
    String[] keys = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Enter", "Cancel", "Back"};

    View.primaryStage = primaryStage;
    // create the initial screen the user will see
    primaryStage.setTitle("Welcome to our ATM Demo");

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));

    Scene scene = new Scene(grid, 600, 400);

    for (int i = 0; i < 12; i++) {
      button = new Button(keys[i]);
      button.getStyleClass().add("num-button");
      grid.add(button, i % 3, (int) Math.ceil(i / 3));

    }

    Text scenetitle = new Text("Enter Account Information");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 4, 0, 1, 1);

    Label cardNumber = new Label("Card Number:");
    grid.add(cardNumber, 5, 0);

    final TextField cardNumberField = new TextField();
    grid.add(cardNumberField, 5, 1);

    Label pin = new Label("PIN:");
    grid.add(pin, 5, 2);

    final PasswordField pinField = new PasswordField();
    grid.add(pinField, 5, 3);

    Button signIn = new Button("Go");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(signIn);
    grid.add(hbBtn, 1, 4);

    final Text actiontarget = new Text();
    grid.add(actiontarget, 1, 6);

    signIn.setOnAction(new MainMenu(cardNumberField, pinField, actiontarget));
    for (Node n : grid.getChildren()) {
      n.setOnMouseClicked(f -> handleCard(cardNumberField, pinField, n, signIn));
    }
    button.setOnAction(new PinPadView());
    signIn.setVisible(false);
    primaryStage.setScene(scene);
    primaryStage.show();
  }


  public EventHandler<ActionEvent> handleCard(TextField cardNumberField, PasswordField pinField,
      Node n, Button signIn) {
    String pinButtonNumber = ((Button) n).getText();

    // enter in the credit card number, then automatically switch
    // to the pin pad if the credit card number field gets to the
    // desired length
    if (cardNumberField.getLength() < 16) {
      cardNumberField.appendText(pinButtonNumber);
    } else if (pinField.getLength() < 4) {
      pinField.appendText(pinButtonNumber);
    } else {
      signIn.setVisible(true);
    }
    return null;

  }

  public void update(ViewState state) {

  }
}
