import java.util.Objects;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// http://www.austintek.com/mvc/#austintek_mvc.view_2

public class View extends Application {
  static public Controller controller;
  public static Stage primaryStage;
  AudioClip audio;
  MediaPlayer mediaPlayer;
  private Button button;

  public static void initialize(String[] args) {
    launch(args);
  }

  private Card card;

  public View() {
    // initializes the GUI window; attaches buttons to methods
  }

  public void addController(Controller controller) {
    View.controller = controller;

  }

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

    Scene scene = new Scene(grid, 640, 480);
    primaryStage.setResizable(false);

    GridPane pinPad = new GridPane();
    for (int i = 0; i < 12; i++) {
      button = new Button(keys[i]);
      button.getStyleClass().add("num-button");
      pinPad.add(button, i % 3, (int) Math.ceil(i / 3));

    }
    pinPad.setPadding(new Insets(10,10,10,10));

    grid.add(pinPad, 0, 10);

    final TextField cardNumberField = new TextField();
    grid.add(cardNumberField, 1, 1);

    final PasswordField pinField = new PasswordField();
    grid.add(pinField, 0, 3);
    pinField.setId("pinField");

    Button signIn = new Button();
    signIn.setId("goButton");

    grid.add(signIn, 0, 4);

    final Text actiontarget = new Text();
    actiontarget.setText("");
    grid.add(actiontarget, 0, 3);

    signIn.setOnAction(new MainMenu(cardNumberField, pinField, actiontarget));
    for (Node n : pinPad.getChildren()) {
      n.setOnMouseClicked(f -> handleCard(cardNumberField, pinField, n, signIn));
    }
    button.setOnAction(new PinPadView());

    // restrict pin pad to four characters
    pinField.setOnKeyReleased(
        event -> {
          System.out.println(pinField.getText());
          if (pinField.getText().length() == 4) {
            signIn.setDisable(false);
          } else if (pinField.getText().length() > 4) {
            pinField.setText(pinField.getText().substring(0, 4));
          } else {
            signIn.setDisable(true);
          }
        }
    );
    signIn.setDisable(true);
    primaryStage.setScene(scene);
    scene.getStylesheets().add(View.class.getResource("style.css").toExternalForm());
    primaryStage.show();
  }


  private EventHandler<ActionEvent> handleCard(TextField cardNumberField, PasswordField pinField,
      Node n, Button signIn) {
    String pinButtonNumber = ((Button) n).getText();
      
<<<<<<< HEAD
      if(pinButtonNumber == "1") {
=======
      if(Objects.equals(pinButtonNumber, "1")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String one = "one.mp3";
          Media hit = new Media(new File(one).toURI().toString());
          mediaPlayer = new MediaPlayer(hit);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "2") {
=======
      else if (Objects.equals(pinButtonNumber, "2")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String two = "two.mp3";
          Media hit2 = new Media(new File(two).toURI().toString());
          mediaPlayer = new MediaPlayer(hit2);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "3") {
=======
      else if (Objects.equals(pinButtonNumber, "3")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String three = "three.mp3";
          Media hit3 = new Media(new File(three).toURI().toString());
          mediaPlayer = new MediaPlayer(hit3);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "4") {
=======
      else if (Objects.equals(pinButtonNumber, "4")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String four = "four.mp3";
          Media hit4 = new Media(new File(four).toURI().toString());
          mediaPlayer = new MediaPlayer(hit4);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "5") {
=======
      else if (Objects.equals(pinButtonNumber, "5")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String five = "five.mp3";
          Media hit5 = new Media(new File(five).toURI().toString());
          mediaPlayer = new MediaPlayer(hit5);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "6") {
=======
      else if (Objects.equals(pinButtonNumber, "6")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String six = "six.mp3";
          Media hit6 = new Media(new File(six).toURI().toString());
          mediaPlayer = new MediaPlayer(hit6);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "7") {
=======
      else if (Objects.equals(pinButtonNumber, "7")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String seven = "seven.mp3";
          Media hit7 = new Media(new File(seven).toURI().toString());
          mediaPlayer = new MediaPlayer(hit7);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "8") {
=======
      else if (Objects.equals(pinButtonNumber, "8")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String eight = "eight.mp3";
          Media hit8 = new Media(new File(eight).toURI().toString());
          mediaPlayer = new MediaPlayer(hit8);
          
          mediaPlayer.play();
      }
<<<<<<< HEAD
      else if (pinButtonNumber == "9") {
=======
      else if (Objects.equals(pinButtonNumber, "9")) {
>>>>>>> 62fd73181f903901d0fba52936cd97b23cf5d831
          String nine = "nine.mp3";
          Media hit9 = new Media(new File(nine).toURI().toString());
          mediaPlayer = new MediaPlayer(hit9);
          
          mediaPlayer.play();
      }


    // keep the sign in button disabled if the pin is not
    // long enough
    if (pinField.getLength() <= 3) {
      pinField.appendText(pinButtonNumber);
    } else {
      signIn.setDisable(false);
    }
    return null;

  }

  private void update(ViewState state) {

  }
}
