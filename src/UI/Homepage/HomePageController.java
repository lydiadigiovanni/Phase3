package UI.Homepage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Button Island1Button;

    @FXML
    private Button Island2Button;

    @FXML
    private Button Island3Button;

    @FXML
    private Button LogOutButton;

    @FXML
    private Button ProfileButton;

    @FXML
    void Island2ButtonPressed(ActionEvent event) {

    }

    @FXML
    void island1ButtonPressed(ActionEvent event){
        try {
        Parent islandOneMapParent = FXMLLoader.load(getClass().getResource("/UI/Map/MapView.fxml"));
        Scene islandOneMapScene = new Scene(islandOneMapParent);

        Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(islandOneMapScene);
        window.show();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    @FXML
    void island3ButtonPressed(ActionEvent event) {

    }

    @FXML
    void logOutButtonPressed(ActionEvent event) {

    }

    @FXML
    void profileButtonPressed(ActionEvent event) {

    }

}
