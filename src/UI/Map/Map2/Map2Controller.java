package UI.Map.Map2;

import Backend.Grade.Grade;
import UI.Map.MapControllerParent;
import UI.Map.MapModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

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
    private Button testButton3;

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

    //SOUNDS TOO BUGGY RIGHT NOW, FIX LATER?
    //private Media sound;

    //private MediaPlayer mediaPlayer;

    private MapModel model = new MapModel();

    @FXML
    void practiceButton3Clicked(ActionEvent event) {

        //mediaPlayer.stop();

    }

    @FXML
    void practiceButton4Clicked(ActionEvent event) {

        //mediaPlayer.stop();

    }

    @FXML
    void returnHome(ActionEvent event) {
        model.toHomePage(event);

        //mediaPlayer.stop();
    }

    @FXML
    void testButtonClicked(ActionEvent event) {

        //mediaPlayer.stop();

    }

    @FXML
    void tutorialButton3Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton3, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade(), "Map2");

        //mediaPlayer.stop();
    }

    @FXML
    void tutorialButton4Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton4, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade(), "Map2");

        //mediaPlayer.stop();
    }

    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex("Map2");
        tutorial3Check.setVisible(checkmarkIndex[0]);
        practice3Check.setVisible(checkmarkIndex[1]);
        tutorial4Check.setVisible(checkmarkIndex[2]);
        practice4Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);

        //sound = new Media(getClass().getResource("/Sounds/windy-forest-ambience-01.mp3").toExternalForm());
        //mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.play();
        //mediaPlayer.setVolume(0.25);
        
    }

    @Override
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex, "map2");
    }

}
