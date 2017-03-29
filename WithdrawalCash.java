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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WithdrawalCash implements EventHandler<ActionEvent> {
	private final Account acc;
	
	WithdrawalCash(Account acc) {
		this.acc = acc;
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
		
		float withdrawAmountValue = (float) 0.00;
		
		if (withdrawAmountField.getLength() != 0) {
			withdrawAmountValue = Float.valueOf(withdrawAmountField.getText());
		}
		
		final float withdrawAmountValueFinal = withdrawAmountValue;
		withdrawButton.setOnAction(f -> withdrawFunds(withdrawAmountValueFinal, acc));
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private EventHandler<ActionEvent> withdrawFunds(float withdrawAmt, Account acc) {
		if (acc != null) {
			if (Model.checkIfPossibleToWithdraw(acc, withdrawAmt)) {
				// TODO: change to float
				this.acc.setBalance((int)(this.acc.getBalance() - withdrawAmt));
				while (Vault.getFifties(1) != null) {
					System.out.println("Dispensing...");
				}
			} else {
				System.out.println("Withdraw failed.");
			}
		}
		return null;
	}
}