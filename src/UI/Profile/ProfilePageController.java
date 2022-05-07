package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ProfilePageController {

    @FXML
    private Button backButton;

    @FXML
    private Button changeAvatarButton;

    @FXML
    private Button changeGradeButton;

    @FXML
    private ImageView fsReward1;

    @FXML
    private ImageView fsReward2;

    @FXML
    private ImageView fsReward3;

    @FXML
    private ImageView kiReward1;

    @FXML
    private ImageView kiReward2;

    @FXML
    private ImageView kiReward3;

    @FXML
    private ImageView tfReward1;

    @FXML
    private ImageView tfReward2;

    @FXML
    private ImageView tfReward3;

    @FXML
    private ImageView userAvatar;

    private Media sound;

    private MediaPlayer mediaPlayer;

    private ProfilePageModel model = new ProfilePageModel();

    @FXML
    void backButtonPressed(ActionEvent event) {
        model.toHomePage(event);

        mediaPlayer.stop();
    }

    @FXML
    void changeAvatarButtonClicked(ActionEvent event) {
        model.toChangeAvatar(event);

        mediaPlayer.stop();
    }

    @FXML
    void changeGradeButtonPressed(ActionEvent event) {
        model.toChangeGradeFlag(event);

        mediaPlayer.stop();

    }

    @FXML
    public void initialize() {
        sound = new Media(getClass().getResource("/Sounds/ship-creaking-1.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

}
