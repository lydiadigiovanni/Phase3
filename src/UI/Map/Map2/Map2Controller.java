package UI.Map.Map2;

import Backend.Grade.Grade;
import UI.Map.MapControllerParent;
import UI.Map.MapModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Map2Controller extends MapControllerParent{

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

    private MapModel model = new MapModel();

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
        model.switchToTutoPracTest(event, tutorialButton3, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());
    }

    @FXML
    void tutorialButton4Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton4, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());
    }

    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex();
        tutorial3Check.setVisible(checkmarkIndex[0]);
        practice3Check.setVisible(checkmarkIndex[1]);
        tutorial4Check.setVisible(checkmarkIndex[2]);
        practice4Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);
        
    }

    @Override
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex);
    }

}
