//Controller for login page
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private Button enterButton;

    @FXML
    private Button createAccount;

    @FXML
    private Button forgotPassword;

    @FXML
    private Label titleLabel;

    private LoginModel model = new LoginModel(); //Make Login Model object

    //Take them to the homepage when they click the enter button
    @FXML
    void enterClicked(ActionEvent event) {
        model.goToHomePage(event, enterButton);
    }

    //Take them to the create account form when they click create account
    @FXML
    void createAccountClicked(ActionEvent event) {
        model.goToCreateAccount(event, createAccount);

    }

    //Take them to the forgot password screen when they click forgot password
    @FXML
    void forgotPasswordClicked(ActionEvent event) {
        model.goToForgotPassword(event, forgotPassword);

    }

}
