//Purpose: Class with soul purpose of launching the map and getting the FXML to load on the primaryStage
package UI.Map;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
 
public class MapMain extends Application {
    @Override
    public void start(Stage primaryStage) {
     
 
           
        
  
  
  

  try {
    //Retrieve the fxml for the map 
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MapView.fxml"));
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