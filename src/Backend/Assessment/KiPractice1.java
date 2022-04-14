package Backend.Assessment;

import java.util.concurrent.ThreadLocalRandom;

public class KiPractice1 extends Assessment {

    @Override
    /**
     * Generates a question of either type multiple choice, true/false, or user input.
     * 0 = multiple choice
     * 1 = true/false
     * 2 = user input
     */
    public String[][][] generateQuestion() { 
        int i = ThreadLocalRandom.current().nextInt(3);
        String[][][] typeAndQuestion = new String[2][1][1];
        switch (0) {
            case 0:
                typeAndQuestion[0][0] = new String[]{"0"};
                typeAndQuestion[1] = generateMultipleChoiceQuestion();

                break;
            case 1:
                typeAndQuestion[0][0] = new String[]{"1"};
                typeAndQuestion[1] = generateTrueFalseQuestion();

                break;
            case 2:
                typeAndQuestion[0][0] = new String[]{"2"};
                typeAndQuestion[1] = generateUserInputQuestion();

                break;
        }
        return typeAndQuestion;
    }

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
        // TODO Auto-generated method stub
        return null;
    }
    
    //TODO: MAKE IT SO IT'S NOT FRUIT IDIOT
    private String[] generateQuestionOne() { //0 is question, 1 is the answer, 3-4 are the wrong answers.
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

    private String[] generateQuestionTwo() {

        int randomNumber = ThreadLocalRandom.current().nextInt(9) + 1;
        String[] question = new String[6];

        question[0] = ("What number comes after " + Integer.toString(randomNumber) + "?");
        question[1] = Integer.toString(randomNumber + 1);
        question[2] = Integer.toString(randomNumber + -1);
        question[3] = Integer.toString(randomNumber + 3);
        question[4] = Integer.toString(randomNumber + 2);

        return question;

    }


    // There are “ “ anchors, swords, compasses, coconuts 
    private  String[] generateQuestionThree() { //generate the question
        String[] nameOfItems ={"anchors", "compasses", "coconuts"}; //array of what are supposed to be the images
        String nameOfItem = nameOfItems[ThreadLocalRandom.current().nextInt(3)];
        int item = ThreadLocalRandom.current().nextInt(10) + 1; //call generateRandomItems to generate a random num of items aka images
        int randomNumber = ThreadLocalRandom.current().nextInt(10) + 1; //the random number generated in the question below
        String[] question = new String[6]; //question1 array
        question[0] = "Are there " + randomNumber + " " + nameOfItem + "?"; //actual question itself
        String answerKey[] = checkAnswer(randomNumber, item); //calls trueOrFalse to randomly generate whether its gonna be T/F
        question[1] = answerKey[0];
        question[2] = answerKey[1];
        question[3] = Integer.toString(item); //number of random items
        question[4] = nameOfItem;
        return question; //return statement bc there will be error w/0 it

    }


    private String[] checkAnswer(int number, int item) { 
            //boolean answer;
        if (number == item) {  //depending on if the number is equal to the number of items
            return new String[]{"Yes", "No"};
        }
        else {
            return new String[]{"No", "Yes"};
        }

    }
}
