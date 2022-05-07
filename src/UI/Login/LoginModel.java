//Model for the MVC structure for the login
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginModel {
    public LoginModel() {

    }
   
    //When the user clicks the "enter" button
    public void goToHomePage(ActionEvent event, Button button) {
        try {
            Parent homePageParent = FXMLLoader.load(getClass().getResource("/UI/Homepage/Homepage.fxml")); //Parent = path to homepage
            Scene homePageScene = new Scene(homePageParent); //Make scene with that path 
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(homePageScene); //Set the scene
            window.show(); //Make it visible

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void goToCreateAccount(ActionEvent event, Button button) {
        try {
            Parent accountParent = FXMLLoader.load(getClass().getResource("/UI/Login/CreateAccountView.fxml")); //Parent = path to create account 
            Scene accountScene = new Scene(accountParent); //Make scene with that path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(accountScene); //Set the scene
            window.show(); //Make it visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    //When the user clicks the "forgot password" button
    public void goToForgotPassword(ActionEvent event, Button button) {
        try {
            Parent passwordParent = FXMLLoader.load(getClass().getResource("/UI/Login/ResetPasswordView.fxml")); //Parent = path to reset password 
            Scene passwordScene = new Scene(passwordParent); //Make scene with that path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(passwordScene); //Set the scene
            window.show(); //Make it visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
