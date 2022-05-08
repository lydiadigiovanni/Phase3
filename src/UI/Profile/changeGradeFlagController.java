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
    private RadioButton Ki;

    @FXML
    private RadioButton TF;

    @FXML
    private ToggleGroup changeGrade;

    @FXML
    private Button returnHomeButton;

    @FXML
    private Button saveGradeChange;
    
    private changeGradeFlagModel model = new changeGradeFlagModel();

    @FXML
    void returnHomeButtonClicked(ActionEvent event) {
        model.toProfilePage(event);
    }

    @FXML
    void saveGradeChangeButtonClicked(ActionEvent event) {
        model.saveGradeChange(event);
    }

}
