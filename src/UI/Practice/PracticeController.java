package UI.Practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class PracticeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup multipleChoiceQuestion;
    
    @FXML
    private Button backButton;

    @FXML
    private RadioButton choiceButtonOne;
    
    @FXML
    private RadioButton choiceButtonTwo;

    @FXML
    private RadioButton choiceButtonThree;

    @FXML
    private RadioButton choiceButtonFour;

    @FXML
    private Button confirmButton;

    @FXML
    private Label questionLabel;

    @FXML
    private Label correctAnswerLabel;

    @FXML
    private ImageView incorrectCorrect;

    @FXML
    private Button doneButton;

    @FXML
    private Label numberCorrectLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Button nextButton;

    @FXML
    private HBox pictureBox;
    
    @FXML
    private WebView youtubeVideo;

    @FXML
    private AnchorPane practiceAnchorPane;
    

    private PracticeModel model = new PracticeModel();

    private Image correctmark;
    private Image incorrectMark;

    public PracticeController() {
        super();
        try {
            correctmark = new Image(new FileInputStream("Pictures/Map/checkmark.png"));
            incorrectMark = new Image(new FileInputStream("Pictures/Practice/incorrectMark.png"));
        } 
        catch (FileNotFoundException e) {   
            e.printStackTrace();
        }
    }
    
    @FXML
    public void completeAssignment(ActionEvent event) {
        //TODO: ADD CODE HERE OF LIKE SAVING ASSIGNMENT OR WHATEVER
        try {
            Parent MapParent = FXMLLoader.load(getClass().getResource("/UI/Map/MapView.fxml"));
            Scene MapScene = new Scene(MapParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(MapScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    public void checkAnswer(ActionEvent event) throws FileNotFoundException { //Confirm button's method
        boolean correctBoolean = model.checkAnswer(((RadioButton) multipleChoiceQuestion.getSelectedToggle()).getText());
        correctAnswerLabel.setText(model.getAnswer());
        if (correctBoolean) {
            incorrectCorrect.setImage(correctmark);
        } else {
            incorrectCorrect.setImage(incorrectMark);
        }
    }

    @FXML
    public void nextQuestion(ActionEvent event) { //Next button's method
        if(incorrectCorrect.getImage() == null) {
            return;
        }
        if(incorrectCorrect.getImage().equals(correctmark)) { //If the user got the question correct
            numberCorrectLabel.setText((Character.getNumericValue(numberCorrectLabel.getText().charAt(0)) + 1) + "/5");
        }
        correctAnswerLabel.setText("");
        incorrectCorrect.setImage(null);
        multipleChoiceQuestion.selectToggle(null);
        model.generateQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour);
        
    }

    @FXML
    public void initialize() {
        if(model.getFirstLetters() != null) {
            switch (model.getFirstLetters()) {
                case "prac":
                    practiceAnchorPane.visibleProperty().set(true);
                    practiceAnchorPane.disableProperty().set(false);
                    youtubeVideo.visibleProperty().set(false);
                    youtubeVideo.disableProperty().set(true);
                    titleLabel.setText("PRACTICE");
                    model.generateQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour); 
                    break;
                case "test":
                System.out.println("I AM TEST");
                    practiceAnchorPane.visibleProperty().set(true);
                    practiceAnchorPane.disableProperty().set(false);
                    youtubeVideo.visibleProperty().set(false);
                    youtubeVideo.disableProperty().set(true);
                    titleLabel.setText("TEST");
                    model.generateQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour); 
                    break;
                case "tuto":
                    practiceAnchorPane.visibleProperty().set(false);
                    practiceAnchorPane.disableProperty().set(true);
                    youtubeVideo.visibleProperty().set(true);
                    youtubeVideo.disableProperty().set(false);
                    titleLabel.setText("TUTORIAL");
                    youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                default:
                    break;
            }      
        }  
    }

    @FXML
    public void returnToMap(ActionEvent event) {
        try {
            Parent MapParent = FXMLLoader.load(getClass().getResource("/UI/Map/MapView.fxml"));
            Scene MapScene = new Scene(MapParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(MapScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void setFirstLetter(String firstFourLetters) {
        model.setFirstLetter(firstFourLetters);
    }

    public void setLastLetter(String lastLetter) {
        model.setLastLetter(lastLetter);
    }

}
