package UI.TutoPracTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ThreadLocalRandom;
import Backend.Assessment.Assessment;
import Backend.Database.Database;
import Backend.Grade.Grade;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private Grade grade;

    private String island;

    /**
     * unfortunately, is not treated as an object, so only needs an empty constructor
     */
    public TutoPracTestModel() {
    }

    /**
     * Simple checking answer lmao
     * @param userAnswer
     */
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer.equalsIgnoreCase(answer)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method generates a multiple choice question
     * Using the questionLabel for the question, which is stored in question[0]
     * Picturebox is only used for KiPractice1 (and test1, only for user input), gets cleared all the time incase.
     * The radiobuttons get the answers assigned to them, index 1-4 is just that 
     * 
     * whatQuestion were created *way* before anything else, they're not used and would have to be completely rewritten to undo.
     * whatQuestions is for is it question 1, 2, 3, or 4. which can be used for making special cases.
     * By getting the grade, and map and question, we know exactly what standard they're on, and if let's say question 2 needed to display *two* pictures, we can then use that information to make a special case for it
     * Unfortunately, with the size of our project, being 800x600, we were very size limited, and we couldn't fit as much stuff, and with a crunch at the end, special cases had to be ignored, but we left the support for it.
     */
    public void generateMultipleChoiceQuestion(String[][][] questionTypeAndWhatQuestionAndQuestion, Label questionLabel, HBox pictureBox, RadioButton choiceButtonOne, RadioButton choiceButtonTwo, RadioButton choiceButtonThree, RadioButton choiceButtonFour) {
            String[][] whatQuestionAndQuestion = questionTypeAndWhatQuestionAndQuestion[1];
            String whatQuestion = whatQuestionAndQuestion[0][0];
            String[] question = whatQuestionAndQuestion[1];
            questionLabel.setText(question[0]);
            answer = question[1];
            pictureBox.getChildren().clear();
            pictureBox.setVisible(false);
            pictureBox.setDisable(true);
            randomizePlacement = ThreadLocalRandom.current().nextInt(1,5);
            choiceButtonOne.setText(question[randomizePlacement]);
            incrementPlacement();
            choiceButtonTwo.setText(question[randomizePlacement]);
            incrementPlacement();
            choiceButtonThree.setText(question[randomizePlacement]);
            incrementPlacement();
            choiceButtonFour.setText(question[randomizePlacement]);
        
    }

    /**
     * This gets the assessment class based on the grade and what island number. (1-3)
     * Since this can be either practice or test, if it's a test, then it's automatically the same last letter as the the first practice, so
     * there's a 50/50 chance it'll grab questions from practice 1 + 0 or practice 1 + 1 (2) 
     * Originally we were using line 88 for generating the class, but the child classes were *much* easier
     */
    private Assessment getAssessmentClass(Grade grade, String island) {
        try {
            //Class<?> assessmentClass = Class.forName("Backend.Assessment.KiPractice1");
            Assessment assessment;
            switch (getFirstLetters()) {
                case "prac":
                    assessment = grade.getPractice(lastLetter);
                    return assessment;
                case "test":
                    int random = ThreadLocalRandom.current().nextInt(2); //0 or 1
                    //setLastLetter(());
                    assessment = grade.getPractice(Integer.toString(Integer.parseInt(getLastLetter()) + random));
                    return assessment;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; 
    }

    /**
     * Method that generates user input questions, since this displays pictures, this is the more complicated question method
     * the first if statement is for the original question we made, which displayed *circles* instead of pictures, and converting it would take too much time
     * the second if statemnet is to display the picture, which the file name is stored on index 5. 
     * due to size restraights, only userinput can have pictures unfortunately.
     */
    public void generateUserInputQuestion(String[][][] questionTypeAndWhatQuestionAndQuestion, Label questionLabel, ImageView userInputImageView, HBox pictureBox) {
        String[][] whatQuestionAndQuestion = questionTypeAndWhatQuestionAndQuestion[1];
        String whatQuestion = whatQuestionAndQuestion[0][0];
        String[] question = whatQuestionAndQuestion[1];
        questionLabel.setText(question[0]);
        FileInputStream fIS;
        pictureBox.getChildren().clear();
        pictureBox.setVisible(true);
        pictureBox.setDisable(true);

        if(Database.getCurrentUserGrade().equalsIgnoreCase("Ki") && lastLetter.equalsIgnoreCase("1")) {
            int numAnswer = Integer.parseInt(question[1]);
            if(whatQuestion.equalsIgnoreCase("0")) {
                for (int i = 0; i < numAnswer; i++) {
                    pictureBox.getChildren().addAll(new Circle(20.0, Paint.valueOf(question[5])));
                }
            }
            answer = question[1];
            return;
        }
        else if (question.length == 6 && question[5] != null) {
            try {
                fIS = new FileInputStream("Pictures/Questions/" + question[5] + ".png");
                userInputImageView.setImage(new Image(fIS));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        

        answer = question[1];
        }
        
    /**
     * helper method to randomize the answers in the button
     */
    private void incrementPlacement() {
        randomizePlacement++;
        if (randomizePlacement == 5) {
            randomizePlacement = 1;
        }
    }

    /**
     * sets the first four letters (tuto, prac, test) in model for use in controller and model
     * @param firstFourLetters
     */
    public void setFirstLetter(String firstFourLetters) {
        this.firstFourLetters = firstFourLetters;
    }

    /**
     * set's the last letter (nunmber, 1,2,3 etc.) in model for use in controller and model
     * @param lastLetter
     */
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

    /**
     * Method that starts the generation question process, based on what questionType is (question type is 0 if it's multiple choice, 1 if user input, 2 is true/false (not implemented))
     */
    public void generateQuestion(Label questionLabel, HBox pictureBox, RadioButton choiceButtonOne, RadioButton choiceButtonTwo, RadioButton choiceButtonThree, RadioButton choiceButtonFour, AnchorPane userInputAnchor, AnchorPane multipleChoiceAnchor, ImageView userInputImageView) {
        String questionTypeAndWhatQuestionAndQuestion[][][] = getAssessmentClass(grade, island).generateQuestion();
        String questionType = questionTypeAndWhatQuestionAndQuestion[0][0][0];
        userInputImageView.setImage(null);
        switch (questionType) {
            case "0":
                generateMultipleChoiceQuestion(questionTypeAndWhatQuestionAndQuestion, questionLabel, pictureBox, choiceButtonOne, choiceButtonTwo, choiceButtonThree, choiceButtonFour);
                userInputAnchor.setVisible(false);
                //trueFalseAnchor.setVisible(false);
                multipleChoiceAnchor.setVisible(true);
                break;
            case "1":
                generateUserInputQuestion(questionTypeAndWhatQuestionAndQuestion, questionLabel, userInputImageView, pictureBox);
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

    /**
     * Used to get exactly what island the user is on, was made at an older time in the project, so that's why it's "MapM" instead of "Map1"
     */
    public void setMapName(String substring) {
        mapName = substring;
        switch (substring) {
            case "MapM":
                island = "1";
                break;
        
            case "Map2":
                island = "2";
                break;
            
            case "Map3":
                island = "3";
                break;
        }
    }

    public String getMapName() {
        return mapName;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    
}
