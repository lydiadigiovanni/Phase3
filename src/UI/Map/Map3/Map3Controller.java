package UI.Map.Map3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Map3Controller {

    @FXML
    private Button homeButton;

    @FXML
    private ImageView practice5Check;

    @FXML
    private ImageView practice6Check;

    @FXML
    private Button practiceButton5;

    @FXML
    private Button practiceButton6;

    @FXML
    private Button testButton;

    @FXML
    private ImageView testCheck;

    @FXML
    private ImageView tutorial5Check;

    @FXML
    private ImageView tutorial6Check;

    @FXML
    private Button tutorialButton5;

    @FXML
    private Button tutorialButton6;

    private Map3Model model = new Map3Model();

    @FXML
    void practiceButton5Clicked(ActionEvent event) {

    }

    @FXML
    void practiceButton6Clicked(ActionEvent event) {

    }

    @FXML
    void returnHome(ActionEvent event) {
        model.toHomePage(event);
    }

    @FXML
    void testButtonClicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton5Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton5, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

    @FXML
    void tutorialButton6Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton6, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

}
