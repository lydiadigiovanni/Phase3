package UI.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MapController {

    @FXML
    private Button homeButton;

    @FXML
    private ImageView practice1Check;

    @FXML
    private ImageView practice2Check;

    @FXML
    private Button practiceButton1;

    @FXML
    private Button practiceButton2;

    @FXML
    private ImageView practiceImage1;

    @FXML
    private ImageView practiceImage2;

    @FXML
    private Button testButton;

    @FXML
    private ImageView testCheck;

    @FXML
    private ImageView testImage;

    @FXML
    private ImageView tutorial1Check;

    @FXML
    private ImageView tutorial2Check;


    @FXML
    private Button tutorialButton1;

    @FXML
    private Button tutorialButton2;

    @FXML
    private ImageView tutorialImage1;

    @FXML
    void practiceButton1Clicked(ActionEvent event) {
        
        String firstFourLetters = practiceButton1.getId().substring(0, 4);
        String lastLetter = practiceButton1.getId().substring((practiceButton1.getId().length()) - 1);        
        try {
            Parent practiceOneParent = FXMLLoader.load(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Scene practiceOneScene = new Scene(practiceOneParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(practiceOneScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void practiceButton2Clicked(ActionEvent event) {
        String firstFourLetters = practiceButton1.getId().substring(0, 4);
        String lastLetter = practiceButton1.getId().substring((practiceButton1.getId().length()) - 1);        
        try {
            Parent practiceOneParent = FXMLLoader.load(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Scene practiceOneScene = new Scene(practiceOneParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(practiceOneScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void returnHome(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("/UI/Homepage/HomePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }

    }

    @FXML
    void testButtonClicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton1Clicked(ActionEvent event) {

    }

    @FXML
    void tutorialButton2Clicked(ActionEvent event) {

    }

}
