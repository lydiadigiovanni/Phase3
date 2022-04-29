package UI.TutoPracTest;
import java.util.concurrent.ThreadLocalRandom;
import Backend.Assessment.Assessment;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class TutoPracTestModel {
    
    private int randomizePlacement;

    private String answer;

    private String firstFourLetters;

    private String lastLetter;

    private String mapName;

    public TutoPracTestModel() {
        // TODO Auto-generated constructor stub
    }

    public boolean checkAnswer(String userAnswer) {
        if (userAnswer.equalsIgnoreCase(answer)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void generateMultipleChoiceQuestion(String[][][] questionTypeAndWhatQuestionAndQuestion, Label questionLabel, HBox pictureBox, RadioButton choiceButtonOne, RadioButton choiceButtonTwo, RadioButton choiceButtonThree, RadioButton choiceButtonFour) {
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
        
    }

    private Assessment getAssessmentClass() {
        try {
            String s = "";
            Class<?> assessmentClass = Class.forName("Backend.Assessment.KiPractice1");
            Assessment assessment;
            switch (getFirstLetters()) {
                case "prac":
                    s = "Practice";
                    assessmentClass = Class.forName("Backend.Assessment.Ki" + s + getLastLetter());
                    assessment = (Assessment) assessmentClass.getDeclaredConstructor().newInstance();
                    return assessment;
                case "test":
                    int random = ThreadLocalRandom.current().nextInt(2);
                    setLastLetter(Integer.toString(random+1));
                    assessmentClass = Class.forName("Backend.Assessment.KiPractice" + (random + 1));
                    assessment = (Assessment) assessmentClass.getDeclaredConstructor().newInstance();
                    return assessment;

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("huge fuck up");
        }
        return null; //If this returns null, there was a fuck up.
    }

    public void generateUserInputQuestion(String[][][] questionTypeAndWhatQuestionAndQuestion, Label questionLabel) {
        String questionType = questionTypeAndWhatQuestionAndQuestion[0][0][0];
        String[][] whatQuestionAndQuestion = questionTypeAndWhatQuestionAndQuestion[1];
        String whatQuestion = whatQuestionAndQuestion[0][0];
        String[] question = whatQuestionAndQuestion[1];
        questionLabel.setText(question[0]);
        answer = question[1];
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

    public void generateQuestion(Label questionLabel, HBox pictureBox, RadioButton choiceButtonOne, RadioButton choiceButtonTwo, RadioButton choiceButtonThree, RadioButton choiceButtonFour, AnchorPane userInputAnchor, AnchorPane multipleChoiceAnchor) {
        String questionTypeAndWhatQuestionAndQuestion[][][] = getAssessmentClass().generateQuestion();
        String questionType = questionTypeAndWhatQuestionAndQuestion[0][0][0];
        switch (questionType) {
            case "0":
                generateMultipleChoiceQuestion(questionTypeAndWhatQuestionAndQuestion, questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour);
                userInputAnchor.setVisible(false);
                //trueFalseAnchor.setVisible(false);
                multipleChoiceAnchor.setVisible(true);
                break;
            case "1":
                generateUserInputQuestion(questionTypeAndWhatQuestionAndQuestion, questionLabel);
                userInputAnchor.setVisible(true);
                //trueFalseAnchor.setVisible(false);
                multipleChoiceAnchor.setVisible(false);
                break;
            /*case "2":
                model.generateTrueFalseQuestion(questionLabel);
                userInputAnchor.setVisible(false);
                //trueFalseAnchor.setVisible(true);
                multipleChoiceAnchor.setVisible(false);
                break;*/
            default:
                break;
        }
    }

    public void setMapName(String substring) {
        mapName = substring;
    }

    public String getMapName() {
        return mapName;
    }

    
}
