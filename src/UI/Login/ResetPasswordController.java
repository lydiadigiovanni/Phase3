//Controller for the reset password scene
package UI.Login;

import Backend.Database.Database;
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

    @FXML
    private TextField securityAnswerOne;

    @FXML
    private TextField securityAnswerTwo;

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
        if(Database.getUsername(usernameText.getText()) != null) {
            if((Database.getSecurityAnswerOne(usernameText.getText())).equalsIgnoreCase(securityAnswerOne.getText()) && (Database.getSecurityAnswerTwo(usernameText.getText())).equalsIgnoreCase(securityAnswerTwo.getText())) {
                if(passwordText.getText().equals(confirmPasswordText.getText())) {
                    Database.setPassword(usernameText.getText(), passwordText.getText());
            }
            model.openPopup(event, submitButton); //Go back to login & open popup telling them it worked
            }
            else {
                model.passwordsDontMatch(event, submitButton);
            }
        }
       
    }

}
