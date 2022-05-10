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
    public void goToSecurity(ActionEvent event, Button button, String userName, String password, String grade) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Login/SecurityView.fxml"));
            Parent securityParent = loader.load();
            SecurityController controller = loader.getController();
            Scene securityScene = new Scene(securityParent); //Make scene with that path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(securityScene); //Set the scene
            controller.setData(userName, password, grade); //Set the data
            window.show(); //Make it visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    /*Remain on create account page & pull up popup warning that
    /Confirm password and password don't match */
    public void openPopup(ActionEvent event, Button button) {
        //First, ensure the main screen stays on create account
        try {
            Parent loginParent = FXMLLoader.load(getClass().getResource("/UI/Login/CreateAccountView.fxml")); //Parent = path to create account screen
            Scene loginScene = new Scene(loginParent); //Make scene with that path
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow()); //Assign nodes to the window
            window.setScene(loginScene); //Set the scene
            window.show(); //Make it visible
        //Second, make a new stage for the popup!
            Stage newStage = new Stage(); //Stage for popup
            Parent popupParent = FXMLLoader.load(getClass().getResource("/UI/Login/PasswordsDontMatch.fxml")); //Parent = path to popup
            Scene popupScene = new Scene(popupParent); //Make scene with that path
            newStage.setScene(popupScene); //Set the popup scene
            newStage.show(); //Make visible
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
