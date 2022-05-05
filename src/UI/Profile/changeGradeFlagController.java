package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class changeGradeFlagController {

    @FXML
    private RadioButton FS;

    @FXML
    private RadioButton K;

    @FXML
    private RadioButton TF;

    @FXML
    private ToggleGroup changeGrade;

    @FXML
    private Button returnHomeButton;

    @FXML
    private Button saveGradeChange;
    
    private ProfilePageModel model = new ProfilePageModel();

    @FXML
    void returnHomeButtonClicked(ActionEvent event) {
        model.toHomePage(event);
    }

    @FXML
    void saveGradeChangeButtonClicked(ActionEvent event) {

    }

}
