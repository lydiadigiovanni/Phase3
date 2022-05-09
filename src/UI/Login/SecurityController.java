//Controller for security (screen after the create account screen
package UI.Login;

import java.sql.SQLException;

import Backend.Database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecurityController {

    @FXML
    private Button loginButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField securityAnswerOne;

    @FXML
    private TextField securityAnswerTwo;

    private SecurityModel model = new SecurityModel(); //Create SecurityModel object

    //Event = user clicked login button
    @FXML
    void loginButtonPressed(ActionEvent event) {
        model.goToLogin(event, loginButton);

    }

    //Event = user clicked submit button
    //Take user back to login page so they can login again
    @FXML
    void submitButtonPressed(ActionEvent event) throws SQLException {
        Database.createUser(model.getUsername(), model.getGrade(), model.getPassword(), securityAnswerOne.getText(), securityAnswerTwo.getText());
        model.goToLogin(event, submitButton);
    }

    public void setData(String userName, String password, String grade) {
        model.setData(userName, password, grade);
    }

}
