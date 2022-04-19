package UI.Map.Map1;

import UI.Map.MapControllerParent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MapController implements MapControllerParent{

    @FXML
    private Button homeButton;

    @FXML
    private ImageView practice1Check;

    @FXML
    private ImageView practice2Check;

    @FXML
    private Button practiceButton1;

    @FXML
    private Button practiceButton2;

    @FXML
    private Button testButton;

    @FXML
    private ImageView testCheck;

    @FXML
    private ImageView tutorial1Check;

    @FXML
    private ImageView tutorial2Check;

    @FXML
    private Button tutorialButton1;

    @FXML
    private Button tutorialButton2;

    private MapModel model = new MapModel();

    public MapController() {
        super();
        
    }

    @FXML
    void practiceButton1Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, practiceButton1, "/UI/TutoPracTest/TutoPracTestView.fxml");

    }

    @FXML
    void practiceButton2Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, practiceButton2, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

    @FXML
    void returnHome(ActionEvent event) {
        model.toHomePage(event);
    }

    @FXML
    void testButtonClicked(ActionEvent event) {
        model.switchToTutoPracTest(event, testButton, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

    @FXML
    void tutorialButton1Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton1, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }

    @FXML
    void tutorialButton2Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton2, "/UI/TutoPracTest/TutoPracTestView.fxml");
    }
    
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex);
    }

    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex();
        tutorial1Check.setVisible(checkmarkIndex[0]);
        practice1Check.setVisible(checkmarkIndex[1]);
        tutorial2Check.setVisible(checkmarkIndex[2]);
        practice2Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);
    }
}
