package UI.Map.Map3;

import UI.Map.MapControllerParent;
import UI.Map.MapModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;

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
    private Button testButton5;

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

    //SOUNDS TOO BUGGY RIGHT NOW, FIX LATER?
    //private Media sound;

    //private MediaPlayer mediaPlayer;

    private String path = "/UI/TutoPracTest/TutoPracTestView.fxml";

    private String mapName = "Map3";

    private MapModel model = new MapModel();

    @FXML
    void practiceButton5Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, practiceButton5, path, getGrade(), mapName);
        //mediaPlayer.stop();

    }

    @FXML
    void practiceButton6Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, practiceButton6, path, getGrade(), mapName);
       // mediaPlayer.stop();

    }

    @FXML
    void returnHome(ActionEvent event) {
        model.toHomePage(event);

        //mediaPlayer.stop();
    }

    @FXML
    void testButtonClicked(ActionEvent event) {
        model.switchToTutoPracTest(event, testButton5, path, getGrade(), mapName);
        //mediaPlayer.stop();

    }

    @FXML
    void tutorialButton5Clicked(ActionEvent event) {

        model.switchToTutoPracTest(event, tutorialButton5, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade(), "Map3");

        //mediaPlayer.stop();
    }

    @FXML
    void tutorialButton6Clicked(ActionEvent event) {

        model.switchToTutoPracTest(event, tutorialButton6, "/UI/TutoPracTest/TutoPracTestView.fxml", getGrade(), "Map3");

        //mediaPlayer.stop();
    }

    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex("Map3");
        tutorial5Check.setVisible(checkmarkIndex[0]);
        practice5Check.setVisible(checkmarkIndex[1]);
        tutorial6Check.setVisible(checkmarkIndex[2]);
        practice6Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);

        //sound = new Media(getClass().getResource("/Sounds/campfire-1.mp3").toExternalForm());
        //mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.play();
        
    }

    @Override
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex, "map3");
    }

}
