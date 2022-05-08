//Purpose: Controller in the MVC structure for the homepage
package UI.Homepage;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import Backend.Database.Database;
import Backend.Grade.Grade;
import Backend.Grade.GradeKi; //TODO: REMOVE THISLATER
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Button Island1Button;

    @FXML
    private Button Island2Button;

    @FXML
    private Button Island3Button;

    @FXML
    private Button LogOutButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Label island1Name;

    @FXML
    private Label island2Name;

    @FXML
    private Label island3Name;

    @FXML
    private ImageView kFlag;

    @FXML
    private ImageView fsFlag;

    @FXML
    private ImageView tfFlag;

    private Media sound;

    private MediaPlayer mediaPlayer;

    private HomePageModel model = new HomePageModel();

    private Grade grade;

    public HomePageController() {
        super();
    }
    @FXML
    void Island2ButtonPressed(ActionEvent event) {
        model.goToIsland(event, Island2Button, "/UI/Map/Map2/Map2View.fxml", grade);
        
        mediaPlayer.stop();
    }

    @FXML
    void island1ButtonPressed(ActionEvent event){
        /*Call goToIsland() from HomePageModel;
        When Island1Button is pressed, the software takes you back to the map!*/
        model.goToIsland(event, Island1Button, "/UI/Map/Map1/MapView.fxml", grade);

        mediaPlayer.stop();
    }

    @FXML
    void island3ButtonPressed(ActionEvent event) {
        model.goToIsland(event, Island2Button, "/UI/Map/Map3/Map3View.fxml", grade);

        mediaPlayer.stop();
    }

    @FXML
    void logOutButtonPressed(ActionEvent event) {
        model.logOut(event);

        mediaPlayer.stop();

    }

    @FXML
    void profileButtonPressed(ActionEvent event) {
        model.goToProfile(event, ProfileButton);

        mediaPlayer.stop();
    }

    @FXML
    public void initialize() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> clazz = Class.forName("Backend.Grade.Grade" + Database.getCurrentUserGrade());
        grade = (Grade) clazz.getDeclaredConstructor().newInstance();
        switch (grade.getGrade()) {
            case "Ki":
                kFlag.setVisible(true);
                fsFlag.setVisible(false);
                tfFlag.setVisible(false);
                break;
            case "FS":
                kFlag.setVisible(false);
                fsFlag.setVisible(true);
                tfFlag.setVisible(false);
                break;
            case "TF":
                kFlag.setVisible(false);
                fsFlag.setVisible(false);
                tfFlag.setVisible(true);
                break;
            default:
                break;
        }
        island1Name.setText(grade.getIsland1Name());
        island2Name.setText(grade.getIsland2Name());
        island3Name.setText(grade.getIsland3Name());
        sound = new Media(getClass().getResource("/Sounds/ocean-waves-1.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.25);
    }

}
