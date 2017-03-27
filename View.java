import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//http://www.austintek.com/mvc/#austintek_mvc.view_2

public class View extends Application {
	private final class AuthenticationScreen implements EventHandler<ActionEvent> {
		private final TextField cardNumberField;
		private final PasswordField pinField;
		private final Text actiontarget;

		private AuthenticationScreen(TextField cardNumberField, PasswordField pinField, Text actiontarget) {
			this.cardNumberField = cardNumberField;
			this.pinField = pinField;
			this.actiontarget = actiontarget;
		}

		@Override
		public void handle(ActionEvent e) {
			actiontarget.setText("Please wait while your credentials are verified...");

			Timeline timeline = new Timeline(
					new KeyFrame(Duration.millis(2500), ae -> verifyCard(cardNumberField, pinField, actiontarget)));
			timeline.play();

			if (Model.isAuthenticated()) {
				// card is valid
			} else {
				// card is invalid
			}
		}

		/**
		 * Verifies if the card is valid or not
		 * 
		 * @param cardNumberField
		 *            The card number
		 * @param pinField
		 *            The pin
		 * @param actiontarget
		 *            What text field to update
		 */
		private boolean verifyCard(final TextField cardNumberField, final PasswordField pinField,
				final Text actiontarget) {
			actiontarget.setFill(Color.BLACK);

			// get the text from the GUI, and see if the pin is valid or not
			ViewEventResult event = controller.verifyCCNumber(cardNumberField.getText(), pinField.getText());
			if (event == null || !event.didSucceed()) {
				// card is invalid
				cardNumberField.clear();
				pinField.clear();
				actiontarget.setText(event.getMessage());
				Model.setAuthenticated(false);
				return false;
			} else {
				// card is valid
				actiontarget.setText(event.getMessage());
				Model.setAuthenticated(true);
				return true;
			}
		}
	}

	static public Controller controller;

	public static void initialize(String[] args) {
		launch(args);
	}

	Card card;

	public View() {
		// initializes the GUI window; attaches buttons to methods
	}

	public void addController(Controller controller) {
		this.controller = controller;

	}

	/**
	 * @param model
	 */
	public void askUserForCard() {
		card = new Card();

		update(ViewState.WELCOME_SCREEN_CARD_AUTH);

		// create new account, and ask user for a card number
		String cardNumber = UserInput.getString("Card Number: ", Restrictions.CCNumber());

		card.setNumber(cardNumber);

		// get pin, and try to validate the card
		String pin = UserInput.getString("PIN: ", Restrictions.pin());
		card.setPin(pin);

		InputRestrictionResult result = null;

		// if it's valid, continue otherwise abort
		if (getCard() != null && controller.model.isValidCard(getCard())) {
			update(ViewState.CARD_VALID, result);
			update(ViewState.CARD_AUTHENTICATED);
		} else {
			update(ViewState.CARD_INVALID, result);
		}
	}

	public Card getCard() {
		return card;
	}

	private void handleWithdrawOrDepositScreen() {
		System.out.println("Hello, " + getCard().getName() + "!");
		InputRestriction depositOrWithdraw = new InputRestriction();

		ArrayList<String> options = new ArrayList<String>();
		options.add("withdraw");
		options.add("deposit");

		depositOrWithdraw.setOptions(options);
		String userInput = UserInput.getString("Deposit or withdraw?", depositOrWithdraw);
	}

	public void setCard(Card card) {
		this.card = card;
	}

	// http://docs.oracle.com/javafx/2/get_started/form.htm#BABDDGEE
	public void start(Stage primaryStage) {

		// create the initial screen the user will see
		primaryStage.setTitle("Welcome to our ATM Demo");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 600, 400);

		Text scenetitle = new Text("Enter Account Information");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label cardNumber = new Label("Card Number:");
		grid.add(cardNumber, 0, 1);

		final TextField cardNumberField = new TextField();
		grid.add(cardNumberField, 1, 1);

		Label pin = new Label("PIN:");
		grid.add(pin, 0, 2);

		final PasswordField pinField = new PasswordField();
		grid.add(pinField, 1, 2);

		Button signIn = new Button("Go");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(signIn);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		signIn.setOnAction(new AuthenticationScreen(cardNumberField, pinField, actiontarget));

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void update(ViewState state) {
		// this would fire when the input does not have to be restricted
		System.out.println("update() called with new view state " + state.name());

		switch (state) {
		case CARD_AUTHENTICATED:
			handleWithdrawOrDepositScreen();
			break;
		case CARD_INVALID:
			break;
		default:
			break;
		}
	}

	public void update(ViewState state, InputRestrictionResult result) {
		if (result != null) {
			// use the result to show the error, and the view state to update
			// the state
		} else {
			update(state);
		}
	}
}