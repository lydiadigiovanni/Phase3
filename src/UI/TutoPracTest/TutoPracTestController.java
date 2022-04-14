package UI.TutoPracTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import UI.Reward.RewardController;
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

public class TutoPracTestController {

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

    @FXML
    private Label progressQuestionsLabel;
    

    private TutoPracTestModel model = new TutoPracTestModel();

    private Image correctmark;
    private Image incorrectMark;

    private int numbercorrect = 0; //The number of questions gotten correct in practice
    private int totalNumberOfQuestions; //The total number of questions for both practice and test to display the done button
    private int questionNumber = 1; //This is the number of the question that it is currently on.

    public TutoPracTestController() {
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
    public void completeAssignment(ActionEvent event) { //Done button
        //TODO: ADD CODE HERE OF LIKE SAVING ASSIGNMENT OR WHATEVER
        try {
            FXMLLoader rewardLoader = new FXMLLoader(getClass().getResource("/UI/Reward/RewardEarnedScreen.fxml"));
            Parent rewardParent = rewardLoader.load();
            Scene rewardScene = new Scene(rewardParent);
            RewardController controller = rewardLoader.getController();
            controller.setRewardGrade((numbercorrect*100/totalNumberOfQuestions));
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            System.out.println(numbercorrect + " = number correct");
            System.out.println(totalNumberOfQuestions + " = total number of questions");
            System.out.println("answer is " + (numbercorrect*100/totalNumberOfQuestions));
            
            window.setScene(rewardScene);
            window.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @FXML
    public void checkAnswer(ActionEvent event) throws FileNotFoundException { //Confirm button's method
        if(multipleChoiceQuestion.getSelectedToggle() != null) {
            disableRadioButtons(true);
            nextButton.setDisable(false);
            nextButton.setVisible(true);
            boolean correctBoolean = model.checkAnswer(((RadioButton) multipleChoiceQuestion.getSelectedToggle()).getText());
            correctAnswerLabel.setText(model.getAnswer());
            if (correctBoolean) {
                incorrectCorrect.setImage(correctmark);
                numbercorrect++;
                if (model.getFirstLetters().equalsIgnoreCase("prac")) {
                    numberCorrectLabel.setText(numbercorrect + "/" + totalNumberOfQuestions);

                }
            } else {
                incorrectCorrect.setImage(incorrectMark);
            }
            if (questionNumber == totalNumberOfQuestions) {
                nextButton.setDisable(true);
                nextButton.setVisible(false);
                doneButton.setDisable(false);
                doneButton.setVisible(true);
            }
            if (numbercorrect == totalNumberOfQuestions) {
                doneButton.setVisible(true);
                doneButton.setDisable(false);
            }
        }
    }

    @FXML
    public void nextQuestion(ActionEvent event) { //Next button's method
        disableRadioButtons(false);
        correctAnswerLabel.setText("");
        incorrectCorrect.setImage(null);
        multipleChoiceQuestion.selectToggle(null);
        model.generateMultipleChoiceQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour);
        nextButton.setVisible(false);
        nextButton.setDisable(true);
        if (model.getFirstLetters().equalsIgnoreCase("test")) {
            questionNumber++;
            numberCorrectLabel.setText(Integer.toString(questionNumber));
        }
    }

    @FXML
    public void initialize() {
        if(model.getFirstLetters() != null) {
            switch (model.getFirstLetters()) {
                case "tuto":
                    practiceAnchorPane.visibleProperty().set(false);
                    practiceAnchorPane.disableProperty().set(true);
                    youtubeVideo.visibleProperty().set(true);
                    youtubeVideo.disableProperty().set(false);
                    titleLabel.setText("TUTORIAL");
                    youtubeVideo.getEngine().load("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
                    doneButton.setVisible(true);
                    doneButton.setDisable(false);
                    break;
                case "prac":
                    practiceAnchorPane.visibleProperty().set(true);
                    practiceAnchorPane.disableProperty().set(false);
                    youtubeVideo.visibleProperty().set(false);
                    youtubeVideo.disableProperty().set(true);
                    titleLabel.setText("PRACTICE");
                    model.generateMultipleChoiceQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour); 
                    totalNumberOfQuestions = 5;
                    numberCorrectLabel.setText("0/" + totalNumberOfQuestions);
                    break;
                case "test":
                    practiceAnchorPane.visibleProperty().set(true);
                    practiceAnchorPane.disableProperty().set(false);
                    youtubeVideo.visibleProperty().set(false);
                    youtubeVideo.disableProperty().set(true);
                    titleLabel.setText("TEST");
                    model.generateMultipleChoiceQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour); 
                    totalNumberOfQuestions = 10;
                    //numberCorrectLabel.setText("0/" + totalNumberOfQuestions);
                    progressQuestionsLabel.setText("Question");
                    numberCorrectLabel.setText("1");
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

    private void disableRadioButtons(Boolean trueFalse) {
        choiceButtonOne.setDisable(trueFalse);
        choiceButtonTwo.setDisable(trueFalse);
        choiceButtonThree.setDisable(trueFalse);
        choiceButtonFour.setDisable(trueFalse);
    }

}
