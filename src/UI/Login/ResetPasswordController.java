//Controller for the reset password scene
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ResetPasswordController {

    @FXML
    private Button loginButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label titleLabel;

    private ResetPasswordModel model = new ResetPasswordModel(); //Make ResetPasswordModel object

    //Event = user presses login button
    @FXML
    void loginButtonPressed(ActionEvent event) {
        model.goToLogin(event, loginButton);

    }

    //Event = user presses submit button
    @FXML
    void submitButtonPressed(ActionEvent event) {
        

    }

}
