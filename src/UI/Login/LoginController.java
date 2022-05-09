//Controller for login page
package UI.Login;

import java.io.IOException;
import java.sql.SQLException;

import Backend.Database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button enterButton;

    @FXML
    private Button createAccount;

    @FXML
    private Button forgotPassword;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField usernameTextField;

    private LoginModel model = new LoginModel(); //Make Login Model object
    

    //Take them to the homepage when they click the enter button
    @FXML
    void enterClicked(ActionEvent event) throws SQLException {
        if(Database.loginUser(usernameTextField.getText(), passwordTextField.getText())) {
            model.goToHomePage(event, enterButton);
        }
        else { //The username or password was incorrect
            model.openPopup(event, enterButton); //Open popup warning
        }
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
