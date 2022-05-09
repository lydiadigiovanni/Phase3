//Create account controller
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CreateAccountController {

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private ToggleGroup gradeToggle;

    @FXML
    private Button loginButton;

    @FXML
    private Button nextButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField usernameTextField;


    private CreateAccountModel model = new CreateAccountModel(); //Make CreateAccountModel object

    //Event = user clicks the loginButton to go back to login screen
    @FXML
    void loginButtonPressed(ActionEvent event) {
        model.goToLogin(event, loginButton);

    }

    //Event = user clicks next button to continue to the security question screen
    @FXML
    void nextButtonPressed(ActionEvent event) {
        if (passwordTextField.getText().equalsIgnoreCase(confirmPasswordTextField.getText())) {
            model.goToSecurity(event, nextButton, usernameTextField.getText(), passwordTextField.getText(), ((RadioButton) gradeToggle.getSelectedToggle()).getId());
        }
    }
}