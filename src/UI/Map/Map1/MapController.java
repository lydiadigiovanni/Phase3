package UI.Map.Map1;

import Backend.Database.Database;
import Backend.Grade.Grade;
import UI.Map.MapControllerParent;
import UI.Map.MapModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MapController extends MapControllerParent{

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
    private Button testButton1;

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

    private Media sound;

    private MediaPlayer mediaPlayer;

    private MapModel model = new MapModel();

    public MapController() {
        super();
        
    }

    @FXML
    void practiceButton1Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, practiceButton1, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());

        mediaPlayer.stop();

    }

    @FXML
    void practiceButton2Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, practiceButton2, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());

        mediaPlayer.stop();
    }

    @FXML
    void returnHome(ActionEvent event) {
        model.toHomePage(event);

        mediaPlayer.stop();
    }

    @FXML
    void testButtonClicked(ActionEvent event) {
        model.switchToTutoPracTest(event, testButton1, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());

        mediaPlayer.stop();
    }

    @FXML
    void tutorialButton1Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton1, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());

        mediaPlayer.stop();
    }

    @FXML
    void tutorialButton2Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton2, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade());

        mediaPlayer.stop();
    }
    
    @Override
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex, "map1");
    }

    @Override
    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex("Map1");
        tutorial1Check.setVisible(checkmarkIndex[0]);
        practice1Check.setVisible(checkmarkIndex[1]);
        tutorial2Check.setVisible(checkmarkIndex[2]);
        practice2Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);

        sound = new Media(getClass().getResource("/Sounds/lake-waves-lapping-gently-on-the-beach-01.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.15);
    }
}
