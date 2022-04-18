//Purpose: Model for the MVC structure for the
package UI.Homepage;

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
    public void goToIsland(ActionEvent event, Button button, String path) {
        try {
            Parent islandOneMapParent = FXMLLoader.load(getClass().getResource(path)); //Parent will be the path 
            Scene islandOneMapScene = new Scene(islandOneMapParent); //Make scene with said path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(islandOneMapScene); //Ensure scene has been set
            window.show(); //Make content visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
