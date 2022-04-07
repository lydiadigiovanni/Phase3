
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
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MapView.fxml"));
    Parent root = (Parent) fxmlLoader.load();
     Scene scene = new Scene(root);
     primaryStage.setTitle("Math Islands");
     primaryStage.setScene(scene);
     primaryStage.show();
  }
  
  catch (IOException e) {
     

  }
}
  
    
 
 public static void main(String[] args) {
        System.out.println("asjhafh");
        launch(args);
        System.out.println("hi");
    }
}