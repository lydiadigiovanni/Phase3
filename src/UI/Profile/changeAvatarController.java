package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class changeAvatarController {

    @FXML
    private RadioButton Avatar_1;

    @FXML
    private RadioButton Avatar_2;

    @FXML
    private RadioButton Avatar_3;

    @FXML
    private RadioButton Avatar_4;

    @FXML
    private RadioButton Avatar_5;

    @FXML
    private RadioButton Avatar_6;

    @FXML
    private Button backButton;

    @FXML
    private ToggleGroup changeAvatar;

    @FXML
    private Button saveNewAvatar;

    private changeAvatarModel model = new changeAvatarModel();

    @FXML
    void backButtonClicked(ActionEvent event) {
        model.toProfilePage(event);
    }

    @FXML
    void saveNewAvatarButtonClicked(ActionEvent event) {
        model.saveNewAvatar(event);
    }

}
