package UI.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MapController {

    @FXML
    private Button homeButton;

    @FXML
    private Button practiceButton1;

    @FXML
    private Button practiceButton2;

    @FXML
    private ImageView practiceImage1;

    @FXML
    private ImageView practiceImage2;

    @FXML
    private Button testButton;

    @FXML
    private ImageView testImage;

    @FXML
    private Button tutorialButton1;

    @FXML
    private Button tutorialButton2;

    @FXML
    private ImageView tutorialImage1;

    @FXML
    void practiceButton1Clicked(ActionEvent event) {

    }

    @FXML
    void practiceButton2Clicked(ActionEvent event) {

    }

    @FXML
    void returnHome(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("/UI/Homepage/HomePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }

    }

    @FXML
    void testButtonClicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton1Clicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton2Clicked(ActionEvent event) {

    }

}
