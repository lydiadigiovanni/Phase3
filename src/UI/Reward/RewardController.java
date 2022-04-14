package UI.Reward;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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

    /**
     * Gold for 100 - 90%
     * Silver for 89 - 70%
     * Bronze for 69 - 50%
     * F for 49 - 0%
     */
    public void setGrade(int grade) {
        gradeNum.setText(grade + "%");
        try {
            if(grade <= 49) {
                treasureChest.setVisible((false));
                prizePhoto.setImage(new Image(new FileInputStream("Pictures/Rewards/failGrade.png")));
            }
            else if(grade <= 69) {
                prizePhoto.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Counting-Bronze-Medal.png")));
            }
            else if (grade <= 89) {
                prizePhoto.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Counting-Silver-Medal.png")));
            }
            else {
                prizePhoto.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Counting-Gold-Medal.png")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
    }

