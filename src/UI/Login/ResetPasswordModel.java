//Model for the MVC structure for reset password screen
package UI.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ResetPasswordModel {
    public ResetPasswordModel() {

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

    /*Gotta make a popup that says "Password changed successfully. Please login to verify"
    public void goToSubmit(ActionEvent event, Button button) {
        
    */
}
