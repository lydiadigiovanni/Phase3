package UI.Map.Map3;

import UI.Map.MapControllerParent;
import UI.Map.MapModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Map3Controller extends MapControllerParent{

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

    private MapModel model = new MapModel();

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
        model.switchToTutoPracTest(event, tutorialButton5, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());
    }

    @FXML
    void tutorialButton6Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton6, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());
    }

    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex();
        tutorial5Check.setVisible(checkmarkIndex[0]);
        practice5Check.setVisible(checkmarkIndex[1]);
        tutorial6Check.setVisible(checkmarkIndex[2]);
        practice6Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);
        
    }

    @Override
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex);
    }

}
