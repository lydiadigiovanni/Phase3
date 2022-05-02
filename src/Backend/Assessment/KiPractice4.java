//Purpose: Second round of practice questions for Operation Isle
package Backend.Assessment;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KiPractice4 extends Assessment {

    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(4);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[]{"0"};
                multipleChoice[1] = generateQuestionOne();
                break;
            case 1: 
                multipleChoice[0] = new String[]{"1"};
                multipleChoice[1] = generateQuestionTwo();
                break;
        }
        return multipleChoice;
    }

    @Override
    public String[][] generateTrueFalseQuestion() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[][] generateUserInputQuestion() {
        // TODO Auto-generated method stub
        return null;
    }

    //Question One: What is " " - " "?
    private String[] generateQuestionOne() {
        String questionOne[] = new String[6]; //Array wild hold questions and possible answers
        Random random = new Random(); //Random object will be used to generate two random numbers
        int firstRandomNum = random.nextInt((10 - 1) + 1) + 1; //First random number between 1 and 10
        int secondRandomNum = random.nextInt((10 - 1) + 1); //Second random number between 1 and 10
        questionOne[0] = "What is " + firstRandomNum + "- " + secondRandomNum + "?"; //0th index: actual question
        int answer = firstRandomNum - secondRandomNum; //Answer is just basic addition
        questionOne[1] = Integer.toString(answer); //1st index: the answer
        questionOne[2] = Integer.toString(answer-1); //Wrong answer 1
        questionOne[3] = Integer.toString(answer+1); //Wrong answer 2
        questionOne[4] = Integer.toString(answer+2); //Wrong answer 3
        return questionOne;
    
    }

     //Question Two: What is the missing number in "_" + "1,2,3,4,etc" = "1,2,3,4,etc"?
     private String[] generateQuestionTwo() {
        String questionTwo[] = new String[6]; //Array will hold questions and possible answers
        Random random = new Random(); //Create Random object to generate the number after the + and the number after the =
        /*Generate the number after the +; It has to be between 1 and 9 instead of 1 and 10 
        because the # after the = cannot be > 10 */
        int plusWhatNumber = random.nextInt((9 - 1) + 1) + 1; 
        //Generate number between 1 and 10 bc the number after the = can be 10
        int numberItEquals = random.nextInt((10 - 1) + 1) + 1; //Generate number between 1 and 10 bc the number after the = can be 10
        questionTwo[0] = "What is the missing number in ____ + " + plusWhatNumber + "=" + numberItEquals; //Actual question
        int answer = numberItEquals - plusWhatNumber; //The answer is the number after = minus the number they're adding to
        questionTwo[1] = Integer.toString(answer); //Actual answer
        questionTwo[2] = Integer.toString(answer-1); //Wrong answer
        questionTwo[3] = Integer.toString(answer+1); //Wrong answer
        questionTwo[4] = Integer.toString(answer+2);  //Wrong answer
        return questionTwo;
    }
}
