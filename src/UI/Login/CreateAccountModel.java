//Model for the MVC structure for create account
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CreateAccountModel {
    public CreateAccountModel() {

    }
   
    //When the user clicks the "login" button
    public void goToLogin(ActionEvent event, Button button) {
        try {
            Parent loginParent = FXMLLoader.load(getClass().getResource("/UI/Login/LoginView.fxml")); //Parent = path to login screen
            Scene loginScene = new Scene(loginParent); //Make scene with that path 
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(loginScene); //Set the scene
            window.show(); //Make it visible

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    //Go to the security screen when the user clicks "next"
    public void goToSecurity(ActionEvent event, Button button) {
        try {
            Parent securityParent = FXMLLoader.load(getClass().getResource("/UI/Login/SecurityView.fxml")); //Parent = path to security screen
            Scene securityScene = new Scene(securityParent); //Make scene with that path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(securityScene); //Set the scene
            window.show(); //Make it visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
