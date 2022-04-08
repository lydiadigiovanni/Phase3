package UI.Practice;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup multipleChoiceQuestion;
    
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
    private Label correctLabel;

    @FXML
    private Label numberCorrectLabel;

    @FXML
    private Button nextButton;

    @FXML
    private HBox pictureBox;
    

    private Model model = new Model();
    
    @FXML
    void checkAnswer(ActionEvent event) {
        String correctString = model.checkAnswer(((RadioButton) multipleChoiceQuestion.getSelectedToggle()).getText());
        correctLabel.setText(correctString);
    }

    @FXML
    void nextQuestion(ActionEvent event) {
        if(correctLabel.getText().equalsIgnoreCase("CORRECT!")) {
        correctLabel.setText("");
        multipleChoiceQuestion.selectToggle(null);
        model.generateQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour);
        numberCorrectLabel.setText((Character.getNumericValue(numberCorrectLabel.getText().charAt(0)) + 1) + "/5");
        }
    }

    @FXML
    void initialize() {
        model.generateQuestion(questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour);
    }

    

}
