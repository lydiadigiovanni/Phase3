//Controller for security (screen after the create account screen
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecurityController {

    @FXML
    private Button loginButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label titleLabel;

    private SecurityModel model = new SecurityModel(); //Create SecurityModel object

    //Event = user clicked login button
    @FXML
    void loginButtonPressed(ActionEvent event) {
        model.goToLogin(event, loginButton);

    }

    //Event = user clicked submit button
    @FXML
    void submitButtonPressed(ActionEvent event) {

    }

}
