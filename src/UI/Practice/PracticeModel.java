package UI.Practice;
import java.util.concurrent.ThreadLocalRandom;

import Backend.QuestionGenerator;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PracticeModel {
    
    private int randomizePlacement;

    private String answer;

    public PracticeModel() {
        // TODO Auto-generated constructor stub
    }

    public String checkAnswer(String multipleChoiceQuestion) {
        if (multipleChoiceQuestion.equalsIgnoreCase(answer)) {
            return "CORRECT!";
        }
        else {
            return "INCORRECT";
        }
    }

    public void generateQuestion(Label questionLabel, HBox pictureBox, RadioButton choiceButtonOne, RadioButton choiceButtonTwo, RadioButton choiceButtonThree, RadioButton choiceButtonFour) {
        String[] question = QuestionGenerator.generateQuestionAndAnswers();
        questionLabel.setText(question[0]);
        answer = question[1];
        int numAnswer = Integer.parseInt(question[1]);
        pictureBox.getChildren().clear();
        for (int i = 0; i < numAnswer; i++) {
            pictureBox.getChildren().addAll(new Circle(20.0, Paint.valueOf(question[5])));
        }
        randomizePlacement = ThreadLocalRandom.current().nextInt(1,5);
        choiceButtonOne.setText(question[randomizePlacement]);
        incrementPlacement();
        choiceButtonTwo.setText(question[randomizePlacement]);
        incrementPlacement();
        choiceButtonThree.setText(question[randomizePlacement]);
        incrementPlacement();
        choiceButtonFour.setText(question[randomizePlacement]);
    }

    private void incrementPlacement() {
        randomizePlacement++;
        if (randomizePlacement == 5) {
            randomizePlacement = 1;
        }
    }
    
}
