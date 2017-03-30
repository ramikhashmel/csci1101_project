import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import  sun.audio.*;    //import the sun.audio package
import  java.io.*;

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
		
		if (withdrawAmountField.getLength() != 0) {
		}
		
		withdrawButton.setOnAction(f -> {
			try {
				withdrawFunds(Float.valueOf(withdrawAmountField.getText()), acc, withdrawAmount);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		returnCard.setOnAction(h -> System.exit(0));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	private EventHandler<ActionEvent> withdrawFunds(float withdrawAmt, Account acc, Label withdrawAmount) throws IOException {
		if (acc != null) {
			if (Model.checkIfPossibleToWithdraw(acc, withdrawAmt, withdrawAmount)) {
				// TODO: change to float
				this.acc.setBalance((int)(this.acc.getBalance() - withdrawAmt));
				//http://stackoverflow.com/questions/24097059/
				for (Iterator<Bill> i = Vault.getTwenties((int)(withdrawAmt/20)); i.hasNext(); ) {
					Bill item = i.next();
					System.out.println(item.toString() + " bill being dispensed...");
					i.remove();
				}
				
				// Open an input stream  to the audio file.
				String clipURL = "https://www.freesound.org/data/previews/41/41195_266274-lq.mp3";

				AudioClip audio = new AudioClip(clipURL);
				audio.play();
				System.out.println("Money dispensed.");
				View.primaryStage.setScene(MainMenu.mainMenu);
				}
			} else {
				withdrawAmount.setText("Withdraw failed.");
			}
		return null;
	}
}
