import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

final class AuthenticationScreen implements EventHandler<ActionEvent> {
	private final TextField cardNumberField;
	private final PasswordField pinField;
	private final Text actiontarget;

	AuthenticationScreen(TextField cardNumberField, PasswordField pinField, Text actiontarget) {
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
		ViewEventResult event = View.controller.verifyCCNumber(cardNumberField.getText(), pinField.getText());
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