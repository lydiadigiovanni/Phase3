//Purpose: Class with soul purpose of launching the homepage and getting the FXML to load on the primaryStage
package UI.Homepage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageMain extends Application {
    
    public static void main(String[] args) {
        launch(args); //Pass command line arguements javafx.application.Application.launch
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Retrieve the fxml for the homepage and assign it to the parent node
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        //primaryStage creates a window to display the content
        primaryStage.setTitle("Math Islands"); //The title at the very top of the window will always be the name of the software
        primaryStage.setScene(new Scene(root)); //Set the scene on the primary stage to Homepage.fxml 
        primaryStage.show(); //Make the window visible
    }   
}