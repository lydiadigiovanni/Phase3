package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginPopupController {

    @FXML
    private Button okButton;

    //Literally just close the popup on "OK"
    @FXML
    void okPressed(ActionEvent event) {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();   

    }

}
