//Purpose: Model for the MVC structure for the
package UI.Homepage;

import Backend.Grade.Grade;
import UI.Map.MapControllerParent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageModel {
    public HomePageModel() {

    }
    /*goToIsland recieves the arguements for the event, button, and path;
    Event = user clicked, button = what they clicked, path = where it takes you*/
    public void goToIsland(ActionEvent event, Button button, String path, Grade grade) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
                Parent parent = loader.load();
                Scene scene = new Scene(parent);
                MapControllerParent controller = loader.getController();
                Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
                window.setScene(scene);
                window.show();
                controller.setGrade(grade);
                controller.initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void goToProfile(ActionEvent event, Button button) {
        try {
            Parent profileParent = FXMLLoader.load(getClass().getResource("/UI/Profile/profilePage.fxml")); //Parent will be the path 
            Scene profileScene = new Scene(profileParent); //Make scene with said path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(profileScene); //Ensure scene has been set
            window.show(); //Make content visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void logOut(ActionEvent event) {
        try {
            Parent loginParent = FXMLLoader.load(getClass().getResource("/UI/Login/LoginView.fxml")); //Parent will be the path 
            Scene loginScene = new Scene(loginParent); //Make scene with said path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(loginScene); //Ensure scene has been set
            window.show(); //Make content visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
