package UI.Map.Map2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Map2Controller {

    @FXML
    private Button homeButton;

    @FXML
    private ImageView practice3Check;

    @FXML
    private ImageView practice4Check;

    @FXML
    private Button practiceButton3;

    @FXML
    private Button practiceButton4;

    @FXML
    private Button testButton;

    @FXML
    private ImageView testCheck;

    @FXML
    private ImageView tutorial3Check;

    @FXML
    private ImageView tutorial4Check;

    @FXML
    private Button tutorialButton3;

    @FXML
    private Button tutorialButton4;

    private Map2Model model = new Map2Model();

    @FXML
    void practiceButton3Clicked(ActionEvent event) {

    }

    @FXML
    void practiceButton4Clicked(ActionEvent event) {

    }

    @FXML
    void returnHome(ActionEvent event) {
        model.toHomePage(event);
    }

    @FXML
    void testButtonClicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton3Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton3, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

    @FXML
    void tutorialButton4Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton4, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

}
