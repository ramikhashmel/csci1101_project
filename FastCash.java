import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FastCash extends Application {
 private Text text;
 private Button a1, a2, a3, a4, a5, exit;
 GridPane pane = new GridPane();

 Font font1 = Font.font("Arial", FontWeight.BOLD, 14);

 @Override
 public void start(Stage primaryStage) {
   a1 = new Button("20$");
   a2 = new Button("40$");
   a3 = new Button("60$");
   a4 = new Button("80$");
   a5 = new Button("100$");
   exit = new Button("EXIT");

   //setting fonts for each
   text = new Text("Please select the amount you want to withdraw");
   Font font1 = Font.font("Arial", FontWeight.BOLD, 17);
   text.setFont(font1);
   a1.setStyle("-fx-font:20 Arial");
   a2.setStyle("-fx-font:20 Arial");
   a3.setStyle("-fx-font:20 Arial");
   a4.setStyle("-fx-font:20 Arial");
   a5.setStyle("-fx-font:20 Arial");
   exit.setStyle("-fx-font:20 Arial");

   //setting each textfield on action
   a1.setOnAction(this::processButtonPress);
   a2.setOnAction(this::processButtonPress);
   a3.setOnAction(this::processButtonPress);
   a4.setOnAction(this::processButtonPress);
   a5.setOnAction(this::processButtonPress);
   exit.setOnAction(this::processButtonPress);

   // padding
   pane.setPadding(new Insets(20, 20, 20, 20));
   pane.setHgap(20);
   pane.setVgap(20);
   pane.setStyle("-fx-background-color:LIGHTBLUE");

   // adding every node to the gridpane
   pane.add(text, 1, 0);
   pane.add(a1, 0, 1);
   pane.add(a2, 0, 5);
   pane.add(a3, 0, 10);
   pane.add(a4, 7, 1);
   pane.add(a5, 7, 5);
   pane.add(exit, 7, 10);
   Scene scene = new Scene(pane, 800, 500);
   primaryStage.setTitle("FAST CASH");
   primaryStage.setScene(scene);
   primaryStage.show();
  }

 //textfield on action
 public void processButtonPress(ActionEvent e) {
  
  //for each textfields
  if (e.getSource() == a1) {

  } else if (e.getSource() == a2) {

  } else if (e.getSource() == a3) {

  } else if (e.getSource() == a4) {

  } else if (e.getSource() == exit) {

  }

 }

 public static void main(String[] args) {
  Application.launch(args);
 }
}
