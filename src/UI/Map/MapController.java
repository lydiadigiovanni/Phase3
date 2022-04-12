package UI.Map;

import java.lang.ModuleLayer.Controller;

import UI.Practice.PracticeController;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Parent practiceOneParent = loader.load();
            Scene practiceOneScene = new Scene(practiceOneParent);
            PracticeController controller = loader.getController();
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(practiceOneScene);
            window.show();
            controller.setFirstLetter(firstFourLetters);
            controller.setLastLetter(lastLetter);
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void practiceButton2Clicked(ActionEvent event) {
        String firstFourLetters = practiceButton2.getId().substring(0, 4);
        String lastLetter = practiceButton2.getId().substring((practiceButton2.getId().length()) - 1);        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Parent practiceTwoParent = loader.load();
            Scene practiceTwoScene = new Scene(practiceTwoParent);
            PracticeController controller = loader.getController();
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(practiceTwoScene);
            window.show();
            controller.setFirstLetter(firstFourLetters);
            controller.setLastLetter(lastLetter);
            controller.initialize();
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
        String firstFourLetters = testButton.getId().substring(0, 4);
        String lastLetter = testButton.getId().substring((testButton.getId().length()) - 1);        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Parent testParent = loader.load();
            Scene testScene = new Scene(testParent);
            PracticeController controller = loader.getController();
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(testScene);
            window.show();
            controller.setFirstLetter(firstFourLetters);
            controller.setLastLetter(lastLetter);
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void tutorialButton1Clicked(ActionEvent event) {
        String firstFourLetters = tutorialButton1.getId().substring(0, 4);
        String lastLetter = tutorialButton1.getId().substring((tutorialButton1.getId().length()) - 1);        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Parent tutorialOneParent = loader.load();
            Scene tutorialOneScene = new Scene(tutorialOneParent);
            PracticeController controller = loader.getController();
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(tutorialOneScene);
            window.show();
            controller.setFirstLetter(firstFourLetters);
            controller.setLastLetter(lastLetter);
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void tutorialButton2Clicked(ActionEvent event) {
        String firstFourLetters = tutorialButton2.getId().substring(0, 4);
        String lastLetter = tutorialButton2.getId().substring((tutorialButton2.getId().length()) - 1);        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Practice/PracticeView.fxml"));
            Parent tutorialTwoParent = loader.load();
            Scene tutorialTwoScene = new Scene(tutorialTwoParent);
            PracticeController controller = loader.getController();
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(tutorialTwoScene);
            window.show();
            controller.setFirstLetter(firstFourLetters);
            controller.setLastLetter(lastLetter);
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
