package UI.TutoPracTest;
import java.util.concurrent.ThreadLocalRandom;
import Backend.Assessment.Assessment;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class TutoPracTestModel {
    
    private int randomizePlacement;

    private String answer;

    private String firstFourLetters;

    private String lastLetter;

    public TutoPracTestModel() {
        // TODO Auto-generated constructor stub
    }

    public boolean checkAnswer(String multipleChoiceQuestion) {
        if (multipleChoiceQuestion.equalsIgnoreCase(answer)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void generateMultipleChoiceQuestion(Label questionLabel, HBox pictureBox, RadioButton choiceButtonOne, RadioButton choiceButtonTwo, RadioButton choiceButtonThree, RadioButton choiceButtonFour) {
        try {
            String s = "";
            Class<?> assessmentClass = Class.forName("Backend.Assessment.KiPractice1");
            switch (getFirstLetters()) {
                case "prac":
                    s = "Practice";
                    assessmentClass = Class.forName("Backend.Assessment.Ki" + s + getLastLetter());
                    break;
                case "test":
                    int random = ThreadLocalRandom.current().nextInt(2);
                    setLastLetter(Integer.toString(random+1));
                    assessmentClass = Class.forName("Backend.Assessment.KiPractice" + (random + 1));
            }
  
            Assessment assessment = (Assessment) assessmentClass.getDeclaredConstructor().newInstance();
            String questionTypeAndWhatQuestionAndQuestion[][][] = assessment.generateQuestion();
            String questionType = questionTypeAndWhatQuestionAndQuestion[0][0][0];
            String[][] whatQuestionAndQuestion = questionTypeAndWhatQuestionAndQuestion[1];
            String whatQuestion = whatQuestionAndQuestion[0][0];
            String[] question = whatQuestionAndQuestion[1];
            questionLabel.setText(question[0]);
            answer = question[1];
            int numAnswer = Integer.parseInt(question[1]);
            pictureBox.getChildren().clear();
            if(whatQuestion.equalsIgnoreCase("0") && lastLetter.equalsIgnoreCase("1")) {
                for (int i = 0; i < numAnswer; i++) {
                    pictureBox.getChildren().addAll(new Circle(20.0, Paint.valueOf(question[5])));
                }
            }
            
            randomizePlacement = ThreadLocalRandom.current().nextInt(1,5);
            choiceButtonOne.setText(question[randomizePlacement]);
            incrementPlacement();
            choiceButtonTwo.setText(question[randomizePlacement]);
            incrementPlacement();
            choiceButtonThree.setText(question[randomizePlacement]);
            incrementPlacement();
            choiceButtonFour.setText(question[randomizePlacement]);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("huge fuck up");
        }
        
    }

    private void incrementPlacement() {
        randomizePlacement++;
        if (randomizePlacement == 5) {
            randomizePlacement = 1;
        }
    }

    public void setFirstLetter(String firstFourLetters) {
        this.firstFourLetters = firstFourLetters;
    }

    public void setLastLetter(String lastLetter) {
        this.lastLetter = lastLetter;
    }

    public String getFirstLetters() {
        return firstFourLetters;
    }

    public String getLastLetter() {
        return lastLetter;
    }
    
    public String getAnswer() {
        return answer;
    }
}
