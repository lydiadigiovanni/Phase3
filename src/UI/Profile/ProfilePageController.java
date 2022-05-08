package UI.Profile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import Backend.Database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ProfilePageController {

    @FXML
    private Button backButton;

    @FXML
    private Button changeAvatarButton;

    @FXML
    private Button changeGradeButton;

    @FXML
    private ImageView fsReward1;

    @FXML
    private ImageView fsReward2;

    @FXML
    private ImageView fsReward3;

    @FXML
    private ImageView kiReward1;

    @FXML
    private ImageView kiReward2;

    @FXML
    private ImageView kiReward3;

    @FXML
    private ImageView tfReward1;

    @FXML
    private ImageView tfReward2;

    @FXML
    private ImageView tfReward3;

    @FXML
    private ImageView userAvatar;

    @FXML
    private Label usernameLabel;

    private Media sound;

    private MediaPlayer mediaPlayer;

    private ProfilePageModel model = new ProfilePageModel();

    @FXML
    void backButtonPressed(ActionEvent event) {
        model.toHomePage(event);

        mediaPlayer.stop();
    }

    @FXML
    void changeAvatarButtonClicked(ActionEvent event) {
        model.toChangeAvatar(event);

        mediaPlayer.stop();
    }

    @FXML
    void changeGradeButtonPressed(ActionEvent event) {
        model.toChangeGradeFlag(event);
        mediaPlayer.stop();

    }

    @FXML
    public void initialize() throws SQLException, FileNotFoundException {
        usernameLabel.setText(Database.getCurrentUsername());
        String avatar = Database.getCurrentAvatar();
        if (avatar != null) {
            try {
                userAvatar.setImage(new Image(new FileInputStream("Pictures/Profile/" + avatar + ".png")));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            try {
                userAvatar.setImage(new Image(new FileInputStream("Pictures/Profile/Avatar_1.png")));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        int[] array = Database.getAssignmentGrades();

        for(int index = 0; index < array.length; index++) {
            switch (index){
                case(0):
                    if(array[index] >= 90) {
                        kiReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Counting-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        kiReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Counting-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        kiReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Counting-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        kiReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(1):
                    if(array[index] >= 90) {
                        kiReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Operation-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        kiReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Operation-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        kiReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Operation-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        kiReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(2):
                    if(array[index] >= 90) {
                        kiReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Geometry-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        kiReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Geometry-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        kiReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/K-Geometry-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        kiReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(3):
                    if(array[index] >= 90) {
                        fsReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Operation-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        fsReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Operation-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        fsReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Operation-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        fsReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(4):
                    if(array[index] >= 90) {
                        fsReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Time-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        fsReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Time-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        fsReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Time-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        fsReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(5):
                    if(array[index] >= 90) {
                        fsReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Measurement-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        fsReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Measurement-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        fsReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/FS-Measurement-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        fsReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(6):
                    if(array[index] >= 90) {
                        tfReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Operation-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        tfReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Operation-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        tfReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Operation-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        tfReward1.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(7):
                    if(array[index] >= 90) {
                        tfReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Fraction-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        tfReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Fraction-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        tfReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Fraction-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        tfReward2.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
                case(8):
                    if(array[index] >= 90) {
                        tfReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Algebra-Gold-Medal.png")));
                    }
                    else if(array[index] <= 89) {
                        tfReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Algebra-Silver-Medal.png")));
                    }
                    else if(array[index] <= 69) {
                        tfReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/TF-Algebra-Bronze-Medal.png")));
                    }
                    else if(array[index] <= 49) {
                        tfReward3.setImage(new Image(new FileInputStream("Pictures/Rewards/brownCircle.png")));
                    }
            }
        }


        sound = new Media(getClass().getResource("/Sounds/ship-creaking-1.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

}
