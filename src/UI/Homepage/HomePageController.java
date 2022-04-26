//Purpose: Controller in the MVC structure for the homepage
package UI.Homepage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private Media sound;

    private MediaPlayer mediaPlayer;

    private HomePageModel model = new HomePageModel();

    @FXML
    void Island2ButtonPressed(ActionEvent event) {
        model.goToIsland(event, Island2Button, "/UI/Map/Map2/Map2View.fxml");
    }

    @FXML
    void island1ButtonPressed(ActionEvent event){
        /*Call goToIsland() from HomePageModel;
        When Island1Button is pressed, the software takes you back to the map!*/
        model.goToIsland(event, Island1Button, "/UI/Map/Map1/MapView.fxml");
    }

    @FXML
    void island3ButtonPressed(ActionEvent event) {
        model.goToIsland(event, Island2Button, "/UI/Map/Map3/Map3View.fxml");

        mediaPlayer.stop();
    }

    @FXML
    void logOutButtonPressed(ActionEvent event) {

    }

    @FXML
    void profileButtonPressed(ActionEvent event) {
        model.goToProfile(event, ProfileButton);
    }

    @FXML
    public void initialize() {
        sound = new Media(getClass().getResource("/Sounds/ocean-waves-1.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

}
