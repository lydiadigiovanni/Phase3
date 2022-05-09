//Purpose: First round of practice questions for Operation Isle
package Backend.Assessment;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KiPractice3 extends Assessment {

    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(2);
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
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(2);
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

        //Question One: What is " " + " "?
        private String[] generateQuestionOne() {
            String questionOne[] = new String[6]; //Array wild hold questions and possible answers
            Random random = new Random(); //Random object will be used to generate two random numbers
            int firstRandomNum = random.nextInt((10 - 1) + 1) + 1; //First random number between 1 and 10
            int secondRandomNum = random.nextInt((10 - 1) + 1); //Second random number between 1 and 10
            questionOne[0] = "What is " + firstRandomNum + "+ " + secondRandomNum + "?"; //0th index: actual question
            int answer = firstRandomNum + secondRandomNum; //Answer is just basic addition
            questionOne[1] = Integer.toString(answer); //1st index: the answer
            questionOne[2] = Integer.toString(answer-1); //Wrong answer 1
            questionOne[3] = Integer.toString(answer+1); //Wrong answer 2
            questionOne[4] = Integer.toString(answer+2); //Wrong answer 3
            return questionOne;
        }

    //Question Two: What is the missing number in "1,2,3,4,etc" - " " = "1,2,3,4,etc"?
    private String[] generateQuestionTwo() {
        String questionTwo[] = new String[6]; //Array will hold questions and possible answers
        Random random = new Random(); //Random object used to generate the # before the - and after the =
        int firstNumInEquation = random.nextInt((10 - 1) + 1) + 1; //Generate the number before the - sign
        int numberItEquals = random.nextInt((9 - 1) + 1) + 1;  //Generate number between 1 and 9 because the number it equals can't be 10
        if (firstNumInEquation > numberItEquals) { //The number we're subtracting from needs to be > than the difference
            questionTwo[0] = "What is the missing number in " + firstNumInEquation + "- ____ = " + numberItEquals; //Actual question
            int answer = firstNumInEquation - numberItEquals; //Can get the answer by subtracting the number it equals from the 1st number
            questionTwo[1] = Integer.toString(answer); //Actual answer
            questionTwo[2] = Integer.toString(answer-1); //Wrong answer
            questionTwo[3] = Integer.toString(answer+1); //Wrong answer
            questionTwo[4] = Integer.toString(answer+2);  //Wrong answer
        }
        else if (firstNumInEquation < numberItEquals) { //The number we're subtracting from cannot be < the difference, so we must switch around the question
            questionTwo[0] = "What is the missing number in " + numberItEquals + "- ____ = " + firstNumInEquation; //Because numberItEquals was greater than firstNumInEquation
            int answer = numberItEquals - firstNumInEquation; //Can get the answer by subtracting the smaller number from the larger number
            questionTwo[1] = Integer.toString(answer); //Actual answer
            questionTwo[2] = Integer.toString(answer-1); //Wrong answer
            questionTwo[3] = Integer.toString(answer+1); //Wrong answer
            questionTwo[4] = Integer.toString(answer+2);  //Wrong answer
           
        }
        else if (firstNumInEquation == numberItEquals){ //The two numbers cannot be the same
           generateQuestionTwo(); //Recursion until they don't equal eachother
        }

        return questionTwo;
    }

    
}