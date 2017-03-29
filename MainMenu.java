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

	MainMenu(TextField cardNumberField, PasswordField pinField, Text actiontarget) {
		this.cardNumberField = cardNumberField;
		this.pinField = pinField;
		this.actiontarget = actiontarget;
	}

	@Override
	public void handle(ActionEvent e) {
		verifyCard(cardNumberField, pinField, actiontarget);
	
		if (Model.isAuthenticated()) {
			Stage primaryStage = View.primaryStage;
			primaryStage.setTitle(Utilities.ATMName + " - Menu");

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 600, 400);

			BorderPane border = new BorderPane();
			border.setPadding(new Insets(20, 0, 20, 20));

			Button btnAdd = new Button("Withdraw");
			Button btnDelete = new Button("Check Balance");
			Button btnMoveUp = new Button("Fast Cash");
			Button btnMoveDown = new Button("Transfer");

			btnAdd.setMaxWidth(Double.MAX_VALUE);
			btnDelete.setMaxWidth(Double.MAX_VALUE);
			btnMoveUp.setMaxWidth(Double.MAX_VALUE);
			btnMoveDown.setMaxWidth(Double.MAX_VALUE);

			VBox vbButtons = new VBox();
			vbButtons.setSpacing(10);
			vbButtons.setPadding(new Insets(0, 20, 10, 20)); 
			vbButtons.getChildren().addAll(btnAdd, btnDelete, btnMoveUp, btnMoveDown);
			
			
			Button btnAdd2 = new Button("Func 1");
			Button btnDelete2 = new Button("Func 2");
			Button btnMoveUp2 = new Button("Func 3");
			Button btnMoveDown2 = new Button("Return Card");

			btnAdd2.setMaxWidth(Double.MAX_VALUE);
			btnDelete2.setMaxWidth(Double.MAX_VALUE);
			btnMoveUp2.setMaxWidth(Double.MAX_VALUE);
			btnMoveDown2.setMaxWidth(Double.MAX_VALUE);
			
			
			VBox vbButtons2 = new VBox();
			vbButtons2.setSpacing(10);
			vbButtons2.setPadding(new Insets(0, 20, 10, 0)); 
			vbButtons2.getChildren().addAll(btnAdd2, btnDelete2, btnMoveUp2, btnMoveDown2);
			Text txt = new Text("What would you like to do today?");
			grid.add(txt, 1, 0);
			grid.add(vbButtons, 0, 0);
			grid.add(vbButtons2, 2, 0);
			primaryStage.setScene(scene);
			primaryStage.show();
		} else {
			System.out.println("Not authenticated.");
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
			if (event.getMessage() != null) {
				actiontarget.setText(event.getMessage());
			}
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


