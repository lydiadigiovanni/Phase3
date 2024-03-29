package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfilePageModel {
    public void toHomePage(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("/UI/Homepage/HomePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }

    public void toChangeGradeFlag(ActionEvent event) {
        try {
            Parent changeGradeFlagParent = FXMLLoader.load(getClass().getResource("changeGradeFlag.fxml"));
            Scene changeGradeFlagScene = new Scene(changeGradeFlagParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(changeGradeFlagScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }

    public void toChangeAvatar(ActionEvent event) {
        try {
            Parent changeAvatarParent = FXMLLoader.load(getClass().getResource("changeAvatar.fxml"));
            Scene changeAvatarScene = new Scene(changeAvatarParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(changeAvatarScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }

    public void toProfilePage(ActionEvent event) {
    }
}
