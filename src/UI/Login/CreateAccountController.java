//Create account controller
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CreateAccountController {

    @FXML
    private Button loginButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label titleLabel;

    
    private CreateAccountModel model = new CreateAccountModel(); //Make CreateAccountModel object

    //Event = user clicks the loginButton to go back to login screen
    @FXML
    void loginButtonPressed(ActionEvent event) {
        model.goToLogin(event, loginButton);

    }

    //Event = user clicks next button to continue to the security question screen
    @FXML
    void nextButtonPressed(ActionEvent event) {
        //If password & confirm password match, go to security page
        model.goToSecurity(event, nextButton);
        //Else open PasswordPopup.fxml

    }

}
