package UI.Reward;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class RewardController {

    @FXML
    private Button claimPrize;

    @FXML
    private Label gradeNum;

    @FXML
    private ImageView prizePhoto;

    @FXML
    private ImageView treasureChest;

    @FXML
    void prizeClaim(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("/UI/Homepage/HomePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
    }

}
