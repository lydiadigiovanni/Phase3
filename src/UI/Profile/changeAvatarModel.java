package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class changeAvatarModel {
    public void toProfilePage(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("profilePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }

    public void saveNewAvatar(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("profilePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }
}
