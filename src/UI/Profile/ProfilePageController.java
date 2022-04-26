package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ProfilePageController {

    @FXML
    private Button backButton;

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

    private ProfilePageModel model = new ProfilePageModel();

    @FXML
    void backButtonPressed(ActionEvent event) {
        model.toHomePage(event);
    }

    @FXML
    void changeGradeButtonPressed(ActionEvent event) {

    }

}
