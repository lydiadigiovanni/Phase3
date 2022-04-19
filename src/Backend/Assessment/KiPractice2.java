/*Purpose: generate actual questions and there answers
for the second round of practice*/
package Backend.Assessment;

import java.util.concurrent.ThreadLocalRandom;

public class KiPractice2 extends Assessment{

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
            case 2:
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
            case 3:
                multipleChoice[0] = new String[]{"3"};
                multipleChoice[1] = generateQuestionFour();
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
        int random = ThreadLocalRandom.current().nextInt(2);
        String userInput[][] = new String[2][1];
        switch (random) {
            case 0:
                userInput[0] = new String[]{"0"};
                userInput[1] = generateQuestionOne();
                break;
            case 1: 
                userInput[0] = new String[]{"1"};
                userInput[1] = generateQuestionTwo();
                break;
            case 2:
                userInput[0] = new String[]{"2"};
                userInput[1] = generateQuestionThree();
                break;
            case 3:
                userInput[0] = new String[]{"3"};
                userInput[1] = generateQuestionFour();
                break;
        }
        return userInput;
    }
    
    //Question One: What comes after numbers "randomly generated sequence"?
    private String[] generateQuestionOne() { 
        int randomNumber; //Will be used to store the answer
        int rng = ThreadLocalRandom.current().nextInt(50-1)/2 * 2;
        int[] list = new int[4];
        //list[0], list[1], list[2] are the first three numbers in the sequence
        list[0] = rng; 
        list[1] = rng + 2; //+2 because we're counting by 2s
        list[2] = rng + 4; //+4 because thats 2 numbers higher than list[1]
        randomNumber = rng + 6; //Answer is always +6 because thats 2 numbers higher than list[2]
        String[] question = new String[6]; //Array will hold question and answers
        //0th index: actual question
        question[0] = list[0] + ", " + list[1] + ", " + list[2] + ", ____"; //list[0], list[1], list[2] = the numbers in the sequence
        question[1] = Integer.toString(randomNumber); //Answ:er
        question[2] = Integer.toString(randomNumber-1); //Wrong answer
        question[3] = Integer.toString(randomNumber+1); //Wrong answer
        question[4] = Integer.toString(randomNumber+3); //Wrong answer
        return question; 
    }

    //QuestionTwo: Same as question one but it counts by 3s!
    private String[] generateQuestionTwo() {
        int randomNumber = ThreadLocalRandom.current().nextInt(50-1)/2 * 2; //First number in sequence
        String[] question = new String[6]; //Array will hold questions and answers
        /*0th index: actual question; we add 3 to the first number to get the second number; 
        and we add 6 to the second number to get the 3rd number*/
        question[0] = randomNumber + ", " + (randomNumber + 3) + ", " + (randomNumber + 6) + ", ____";
        //1st index: correct answer; we add 9 to the first number to get the next number in the sequence
        question[1] = Integer.toString(randomNumber + 9);
        question[2] = Integer.toString(randomNumber-1); //Wrong answer
        question[3] = Integer.toString(randomNumber+1); //Wrong answer
        question[4] = Integer.toString(randomNumber+3); //Wrong answer
        return question; 
    }

    //Question three: Find the missing number in the sequence (sequence counts by 3s)
    private String[] generateQuestionThree() {
        int randomNumber = ThreadLocalRandom.current().nextInt(50-1)/2 * 2; //First number in sequence between 1 and 50
        String[] question = new String[6]; //Array will hold question and answers
        /*0th index: actual question; they will be filling in the second number which is
        why we add 6 rather than adding 3 to randomNumber*/
        question[0] = randomNumber + ", " + "____" + ", " + (randomNumber + 6) + ", " + (randomNumber + 9);
        question[1] = Integer.toString(randomNumber + 3); //Second number in sequence is answer; so we add 3!
        question[2] = Integer.toString(randomNumber-1); //Wrong answer
        question[3] = Integer.toString(randomNumber+1); //Wrong answer
        question[4] = Integer.toString(randomNumber+4); //Wrong answer
        return question; 
    }

    //Question four: Same as question three but counts by 2s instead of 3s
    private String[] generateQuestionFour() {
        int randomNumber = ThreadLocalRandom.current().nextInt(50-1)/2 * 2; //First number in sequence between 1 and 50
        String[] question = new String[6]; //Array will hold question and answers
        /*0th index: actual question; they will be filling in the third number which is
        why we add 6 to randomNumber rather than 4 after the blank*/
        question[0] =  randomNumber + ", " + (randomNumber + 2) + ", " + "____" + ", " + (randomNumber + 6);
        question[1] = Integer.toString(randomNumber + 4); //Correct answer is 4 greater than randomNumber
        question[2] = Integer.toString(randomNumber-1); //Wrong answer
        question[3] = Integer.toString(randomNumber+1); //Wrong answer
        question[4] = Integer.toString(randomNumber+3); //Wrong answer
        return question; 
    }
}
