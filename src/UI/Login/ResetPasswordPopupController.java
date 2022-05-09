package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ResetPasswordPopupController {

    @FXML
    private Button okButton;

    //Close popup on "OK"
    @FXML
    void okPressed(ActionEvent event) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();   

    }

}
