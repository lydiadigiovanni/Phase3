/*Purpose: generate actual questions and there answers
for the first round of practice*/
package Backend.Assessment;

import java.util.concurrent.ThreadLocalRandom;

public class KiPractice1 extends Assessment {

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
        int i = ThreadLocalRandom.current().nextInt(1);
        switch (i) {
            case 0: 
                multipleChoice[0] = new String[]{"0"};
                multipleChoice[1] = generateQuestionTwo();
                break;
        }
        return multipleChoice;
    }
    
    //Question One: How many "anchors, compasses, coconuts" are there?
    //Reminder: Replace fruit!
    private String[] generateQuestionOne() { 
        String[] questionAnswer = new String[6]; //Array contains possible answers
        /*String fruit contains a random number of items and the answer depending
        on that number by calling generateFruit()*/
        String fruit = generateFruit(ThreadLocalRandom.current().nextInt(4), questionAnswer);
        questionAnswer[0] = "How many " + fruit + " are there?"; //0th index - actual question
        int answer = ThreadLocalRandom.current().nextInt(1,10);
        questionAnswer[1] = Integer.toString(answer); //1st index - the answer
        questionAnswer[2] = Integer.toString(answer-1); //Wrong answer
        questionAnswer[3] = Integer.toString(answer+1); //Wrong answer
        questionAnswer[4] = Integer.toString(answer+2); //Wrong answer
        return questionAnswer; 
    }
    /*Generates whether it is a coconut, compasses, or anchor;
    Recieves a random number and a questionAnswer array as an arguement*/
    private static String generateFruit(int randomNumber, String[] questionAnswer) {
        String returnedFruit = "";
        switch (randomNumber) {
            case 1: //When the returnedFruit is apples
                returnedFruit = "Apples";
                questionAnswer[5] = "Red";
                break;
            case 2:
                returnedFruit = "Pears"; //When the returnedFruit is pears
                questionAnswer[5] = "Green";
                break;
            case 3: 
                returnedFruit = "Oranges"; //When the returnedFruit is oranges
                questionAnswer[5] = "Orange";
            default:
                returnedFruit = "Grapes"; //When the returnedFruit is oranges
                questionAnswer[5] = "Purple";
                break;
        }
        return returnedFruit;
    }

    //Question Two: What number comes after "1, 2, 3, etc..." ?
    private String[] generateQuestionTwo() {
        //randomNumber = The number to be generated for "What number comes after _"?
        int randomNumber = ThreadLocalRandom.current().nextInt(9) + 1;
        String[] question = new String[6]; //Array holds question and answers

        question[0] = ("What number comes after " + Integer.toString(randomNumber) + "?"); //0th index: actual question
        question[1] = Integer.toString(randomNumber + 1); //1st index: correct answer will always be 1 number after the randomNumber
        question[2] = Integer.toString(randomNumber + -1); //Wrong answer
        question[3] = Integer.toString(randomNumber + 3); //Wrong answer
        question[4] = Integer.toString(randomNumber + 2); //Wrong answer

        return question;   

    }

    // Question Three: There are “ “ anchors, swords, compasses, coconuts 
    private  String[] generateQuestionThree() { 
        String[] nameOfItems ={"anchors", "compasses", "coconuts"}; //Array of what are supposed to be the images
        //nameOfItem contains a random name of one of the items above
        String nameOfItem = nameOfItems[ThreadLocalRandom.current().nextInt(3)];
        int item = ThreadLocalRandom.current().nextInt(10) + 1; //?
        int randomNumber = ThreadLocalRandom.current().nextInt(10) + 1; 
        String[] question = new String[6]; //Array will contain the question and its answers
        question[0] = "Are there " + randomNumber + " " + nameOfItem + "?"; //0th index: actual question
        //Pass checkAnswer the randomNumber and item itself and store in answerkey array
        String answerKey[] = checkAnswer(randomNumber, item); 
        question[1] = answerKey[0]; //The correct answer is in answerkey[0] and stored in question[1]
        question[2] = answerKey[1]; //?
        question[3] = Integer.toString(item); //?
        question[4] = nameOfItem; //?
        return question; 

    }

    //?
    private String[] checkAnswer(int number, int item) { 
    
        if (number == item) {  
            return new String[]{"Yes", "No"};
        }
        else {
            return new String[]{"No", "Yes"};
        }

    }
}
