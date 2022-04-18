//This is all in KiPractice1 an KiPractice2; Can I delete ??
package Backend;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ***extremely*** basic just for this
 */
public class QuestionGenerator {
    
    //0 is the question, 1 is always the right answer, 2-4 are the wrong answers, 5 is color
    public static String[] generateQuestionAndAnswers() {
        String[] questionAnswer = new String[6];
        String fruit = generateFruit(ThreadLocalRandom.current().nextInt(4), questionAnswer);
        questionAnswer[0] = "How many " + fruit + " are there?";
        int answer = ThreadLocalRandom.current().nextInt(1,10);
        questionAnswer[1] = Integer.toString(answer);
        questionAnswer[2] = Integer.toString(answer-1);
        questionAnswer[3] = Integer.toString(answer+1);
        questionAnswer[4] = Integer.toString(answer+2);
        return questionAnswer;
    } 

    private static String generateFruit(int randomNumber, String[] questionAnswer) {
        String returnedFruit = "";
        switch (randomNumber) {
            case 1:
                returnedFruit = "Apples";
                questionAnswer[5] = "Red";
                break;
            case 2:
                returnedFruit = "Pears";
                questionAnswer[5] = "Green";
                break;
            case 3: 
                returnedFruit = "Oranges";
                questionAnswer[5] = "Orange";
            default:
                returnedFruit = "Grapes";
                questionAnswer[5] = "Purple";
                break;
        }
        return returnedFruit;
    }
}
