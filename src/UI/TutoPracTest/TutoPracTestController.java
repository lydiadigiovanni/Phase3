package UI.TutoPracTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import Backend.Database.Database;
import Backend.Grade.Grade;
import Backend.Grade.GradeKi;
import UI.Map.MapControllerParent;
import UI.Map.Map1.MapController;
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
import javafx.scene.control.TextField;
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
    private AnchorPane multipleChoiceAnchor;

    @FXML
    private Button multipleChoiceConfirmButton;

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
    private Button multipleChoiceNextButton;

    @FXML
    private HBox pictureBox;
    
    @FXML
    private WebView youtubeVideo;

    @FXML
    private AnchorPane practiceAnchorPane;

    @FXML
    private Label progressQuestionsLabel;

    @FXML
    private AnchorPane userInputAnchor;

    @FXML
    private Button userInputConfirmButton;

    @FXML
    private Button userInputNextButton;

    @FXML
    private TextField userInputTextField;

    @FXML
    private ImageView userInputImageView;
    

    private TutoPracTestModel model = new TutoPracTestModel();

    private Image correctmark;
    private Image incorrectMark;

    private int numbercorrect = 0; //The number of questions gotten correct in practice
    private int totalNumberOfQuestions; //The total number of questions for both practice and test to display the done button
    private int questionNumber = 1; //This is the number of the question that it is currently on.
    private Grade grade;

    public TutoPracTestController() {
        super();
        grade = new GradeKi(); //TODO: REMOVE LATER
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
        if (youtubeVideo != null) {
            youtubeVideo.getEngine().load("");
        }
        if (model.getFirstLetters().equalsIgnoreCase("Test")) {
            try {
                FXMLLoader rewardLoader = new FXMLLoader(getClass().getResource("/UI/Reward/RewardEarnedScreen.fxml"));
                Parent rewardParent = rewardLoader.load();
                Scene rewardScene = new Scene(rewardParent);
                RewardController controller = rewardLoader.getController();
                int testGrade = numbercorrect*100/totalNumberOfQuestions;
                controller.setRewardGrade((testGrade));
                if (Database.getAssignmentGrades() == null || Database.getAssignmentGrade(model.getFirstLetters(), model.getLastLetter()) < testGrade) {
                    Database.setAssigmentGrade(model.getFirstLetters(), model.getLastLetter(), (testGrade));
                }
                controller.initialize();
                Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
                
                window.setScene(rewardScene);
                window.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else
            try {
                FXMLLoader loader = new FXMLLoader();
                MapControllerParent controller = new MapController();
                Parent parent = new Parent(){};
                switch (model.getMapName()) {
                    case "MapM"://Map 1
                        loader = new FXMLLoader(getClass().getResource("/UI/Map/Map1/MapView.fxml"));
                        parent = loader.load();
                        controller = loader.getController();
                        break;
                    case "Map2":
                        loader = new FXMLLoader(getClass().getResource("/UI/Map/Map2/Map2View.fxml"));
                        parent = loader.load();
                        controller = loader.getController();
                        break;
                    case "Map3":
                        loader = new FXMLLoader(getClass().getResource("/UI/Map/Map3/Map3View.fxml"));
                        parent = loader.load();
                        controller = loader.getController();
                        break;
                }
                Scene scene = new Scene(parent);
                Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
                window.setScene(scene);
                window.show();
                int checkmarkindex = 0;
                if (model.getFirstLetters().equalsIgnoreCase("Tuto")) {
                    if(model.getLastLetter().equalsIgnoreCase("1") || model.getLastLetter().equalsIgnoreCase("3") || model.getLastLetter().equalsIgnoreCase("5")) {
                        checkmarkindex = 0;
                    }
                    else if (model.getLastLetter().equalsIgnoreCase("2") || model.getLastLetter().equalsIgnoreCase("4") || model.getLastLetter().equalsIgnoreCase("6")) {
                        checkmarkindex = 2;
                    }
                }
                else if (model.getFirstLetters().equalsIgnoreCase("Prac")) {
                    if(model.getLastLetter().equalsIgnoreCase("1") || model.getLastLetter().equalsIgnoreCase("3") || model.getLastLetter().equalsIgnoreCase("5")) {
                        checkmarkindex = 1;
                    }
                    else if (model.getLastLetter().equalsIgnoreCase("2") || model.getLastLetter().equalsIgnoreCase("4") || model.getLastLetter().equalsIgnoreCase("6")) {
                        checkmarkindex = 3;
                    }
                }
                else if (model.getFirstLetters().equalsIgnoreCase("Test")) {
                    if(model.getLastLetter().equalsIgnoreCase("1") || model.getLastLetter().equalsIgnoreCase("3") || model.getLastLetter().equalsIgnoreCase("5")) {
                        checkmarkindex = 4;
                }
                }
                controller.setCheckmarkBoolean(checkmarkindex);
                controller.initialize();

                } catch (Exception e) {
                    e.printStackTrace();
                }

    }

    @FXML
    public void mutlipleChoiceCheckAnswer(ActionEvent event) throws FileNotFoundException { //Confirm button's method
        if(multipleChoiceQuestion.getSelectedToggle() != null) {
            disableRadioButtons(true);
            multipleChoiceNextButton.setDisable(false);
            multipleChoiceNextButton.setVisible(true);
            boolean correctBoolean = model.checkAnswer(((RadioButton) multipleChoiceQuestion.getSelectedToggle()).getText());
            correctAnswerLabel.setText(model.getAnswer());
            answerChecker(correctBoolean, multipleChoiceNextButton);
            multipleChoiceConfirmButton.setDisable(true);
        }
    }

    private void answerChecker(Boolean correctBoolean, Button nextButton) {
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

    @FXML
    void userInputCheckAnswer(ActionEvent event) {
        if(!userInputTextField.getText().isEmpty()) {
            userInputTextField.setDisable(true);
            userInputNextButton.setDisable(false);
            userInputNextButton.setVisible(true);
            boolean correctBoolean = model.checkAnswer(userInputTextField.getText());
            correctAnswerLabel.setText(model.getAnswer());
            answerChecker(correctBoolean, userInputNextButton);
            userInputConfirmButton.setDisable(true);
        }
    }

    @FXML
    void userInputNextQuestion(ActionEvent event) {
        userInputTextField.setDisable(false);
        userInputConfirmButton.setDisable(false);
        userInputTextField.setText("");
        correctAnswerLabel.setText("");
        incorrectCorrect.setImage(null);
        userInputNextButton.setDisable(true);
        userInputNextButton.setVisible(false);
        generateQuestion();
        if (model.getFirstLetters().equalsIgnoreCase("test")) {
            questionNumber++;
            numberCorrectLabel.setText(Integer.toString(questionNumber));
        }
    }

    @FXML
    public void multipleChoiceNextQuestion(ActionEvent event) { //Next button's method
        disableRadioButtons(false);
        multipleChoiceConfirmButton.setDisable(false);
        correctAnswerLabel.setText("");
        incorrectCorrect.setImage(null);
        multipleChoiceQuestion.selectToggle(null);
        generateQuestion();
        multipleChoiceNextButton.setVisible(false);
        multipleChoiceNextButton.setDisable(true);
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
                    /**
                     * check grade
                     * make grade object then do get youtubeVideo
                     */
                    switch (model.getLastLetter()) {
                        case "1":
                            youtubeVideo.getEngine().load(grade.getYoutubeVideo1()); 
                            break;
                        case "2":
                            youtubeVideo.getEngine().load(grade.getYoutubeVideo2());
                            break;
                        case "3":
                            youtubeVideo.getEngine().load(grade.getYoutubeVideo3());
                            break;
                        case "4":
                            youtubeVideo.getEngine().load(grade.getYoutubeVideo4());
                            break;
                        case "5":
                            youtubeVideo.getEngine().load(grade.getYoutubeVideo5());
                            break;
                        case "6":
                            youtubeVideo.getEngine().load(grade.getYoutubeVideo6());
                            break;
                    }
                    doneButton.setVisible(true);
                    doneButton.setDisable(false);
                    break;
                case "prac":
                    practiceAnchorPane.visibleProperty().set(true);
                    practiceAnchorPane.disableProperty().set(false);
                    youtubeVideo.visibleProperty().set(false);
                    youtubeVideo.disableProperty().set(true);
                    titleLabel.setText("PRACTICE");
                    //multipleChoiceAnchor.visibleProperty().set(true);
                    //userInputAnchor.visibleProperty().set(false);
                    generateQuestion();
                    //userInputAnchor.setVisible(true);
                    totalNumberOfQuestions = 5;
                    numberCorrectLabel.setText("0/" + totalNumberOfQuestions);
                    break;
                case "test":
                    practiceAnchorPane.visibleProperty().set(true);
                    practiceAnchorPane.disableProperty().set(false);
                    youtubeVideo.visibleProperty().set(false);
                    youtubeVideo.disableProperty().set(true);
                    titleLabel.setText("TEST");
                    //multipleChoiceAnchor.visibleProperty().set(true);
                    generateQuestion(); 
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
        if (youtubeVideo != null) {
            youtubeVideo.getEngine().load("");
        }
        try {
            Parent MapParent = new Parent(){};
            switch (model.getMapName()) {
                case "MapM"://Map 1
                    MapParent = FXMLLoader.load(getClass().getResource("/UI/Map/Map1/MapView.fxml"));
                    break;
                case "Map2":
                    MapParent = FXMLLoader.load(getClass().getResource("/UI/Map/Map2/Map2View.fxml"));
                    break;
                case "Map3":
                    MapParent = FXMLLoader.load(getClass().getResource("/UI/Map/Map3/Map3View.fxml"));
                    break;
            }
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

    private void generateQuestion() {
        model.generateQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour, userInputAnchor, multipleChoiceAnchor, userInputImageView);
    }

    /**
     * This an indicator of what island it is, 1, 2, 3.
     * @param substring
     */
    public void setMapName(String substring) {
        model.setMapName(substring);
    }

    public void setGrade(Grade grade) {
        model.setGrade(grade);
    }

}
