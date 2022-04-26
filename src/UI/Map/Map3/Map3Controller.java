package UI.Map.Map3;

import UI.Map.MapControllerParent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Map3Controller implements MapControllerParent{

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

    private Media sound;

    private MediaPlayer mediaPlayer;

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

        mediaPlayer.stop();
    }

    @FXML
    void testButtonClicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton5Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton5, "/UI/TutoPracTest/TutoPracTestView.fxml");

        mediaPlayer.stop();
    }

    @FXML
    void tutorialButton6Clicked(ActionEvent event) {
        model.switchToTutoPracTest(event, tutorialButton6, "/UI/TutoPracTest/TutoPracTestView.fxml");

        mediaPlayer.stop();
    }

    @FXML
    public void initialize() {
        Boolean[] checkmarkIndex = model.getCheckmarkIndex();
        tutorial5Check.setVisible(checkmarkIndex[0]);
        practice5Check.setVisible(checkmarkIndex[1]);
        tutorial6Check.setVisible(checkmarkIndex[2]);
        practice6Check.setVisible(checkmarkIndex[3]);
        testCheck.setVisible(checkmarkIndex[4]);

        sound = new Media(getClass().getResource("/Sounds/campfire-1.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        
    }

    @Override
    public void setCheckmarkBoolean(int checkmarkindex) {
        model.setCheckmarkBoolean(checkmarkindex);
    }

}
