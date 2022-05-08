//Controller for the reset password scene
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ResetPasswordController {

    @FXML
    private PasswordField confirmPasswordText;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button submitButton;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField usernameText;

    private ResetPasswordModel model = new ResetPasswordModel(); //Make ResetPasswordModel object
    
    //Event = user presses login button
    @FXML
    void loginButtonPressed(ActionEvent event) {
        model.goToLogin(event, loginButton);

    }

    //Event = user presses submit button
    //Take user back to login page so they can login again
    @FXML
    void submitButtonPressed(ActionEvent event) {
        //if passwords match & security questions are correct
        model.goToLogin(event, loginButton);
        //else
        //model.openPopup(event, loginButton)

    }

}
