//Main program for 2nd page of create account AKA security questions
package UI.Login;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
 
public class CreateAccountMain2 extends Application {
    @Override
    public void start(Stage primaryStage) {
  try {
    //Retrieve the fxml for the 2nd create account scene
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateAccountView2.fxml"));
    Parent root = (Parent) fxmlLoader.load(); //Assign that fxml as the parent node
    Scene scene = new Scene(root); //Create a new scene containing root
     primaryStage.setTitle("Math Islands"); //Title will always be the name of the software
     primaryStage.setScene(scene); //Ensure the scene is set as the primaryStage
     primaryStage.show(); //Make visible
  }
  
  catch (IOException e) {
     e.printStackTrace();

  }
}
 public static void main(String[] args) {
        launch(args);
    }
}