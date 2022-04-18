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

    public void goToIsland(ActionEvent event, Button button, String path) {
        try {
            Parent islandMapParent = FXMLLoader.load(getClass().getResource(path));
            Scene islandMapScene = new Scene(islandMapParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(islandMapScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
