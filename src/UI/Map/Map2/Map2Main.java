package UI.Map.Map2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
 
public class Map2Main extends Application {
    @Override
    public void start(Stage primaryStage) {
  try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map2View.fxml"));
    Parent root = (Parent) fxmlLoader.load();
     Scene scene = new Scene(root);
     primaryStage.setTitle("Math Islands");
     primaryStage.setScene(scene);
     primaryStage.show();
  }
  
  catch (IOException e) {
     e.printStackTrace();

  }
}
 public static void main(String[] args) {
        launch(args);
    }
}