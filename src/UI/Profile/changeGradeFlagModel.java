package UI.Profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class changeGradeFlagModel {
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

    public void saveGradeChange(ActionEvent event) {
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
}