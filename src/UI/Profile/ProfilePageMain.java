package UI.Profile;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfilePageMain extends Application {
    
    public static void main(String[] args) {
        launch(args); //Pass command line arguements javafx.application.Application.launch
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Retrieve the fxml for the profile page and assign it to the parent node
        Parent root = FXMLLoader.load(getClass().getResource("profilePage.fxml"));
        //primaryStage creates a window to display the content
        primaryStage.setTitle("Math Islands"); //The title at the very top of the window will always be the name of the software
        primaryStage.setScene(new Scene(root)); //Set the scene on the primary stage to profilePage.fxml 
        primaryStage.show(); //Make the window visible
    }   
}