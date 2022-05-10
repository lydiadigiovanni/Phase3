//Purpose: Second round of practice questions for Measurement Reef
package Backend.Assessment;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


    //TODO: FIX ALL OF THE QUESTIONS
    //TODO: FIX ALL OF THE QUESTIONS
    //TODO: FIX ALL OF THE QUESTIONS
    //TODO: FIX ALL OF THE QUESTIONS
    //TODO: FIX ALL OF THE QUESTIONS


public class FSPractice6 extends Assessment{

    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(3);
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
                multipleChoice[0] = new String[] { "2" };
                multipleChoice[1] = generateQuestionThree();
                break;    
        }
        return multipleChoice;
    }

    @Override
    public String[][] generateTrueFalseQuestion() {
        return null;
    }

    @Override
    public String[][] generateUserInputQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(2);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[]{"1"};
                multipleChoice[1] = generateQuestionTwo();
                break;
            case 1: 
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
        }
        return multipleChoice;
    }

    public static void main (String[] args) {
        //Test question one
        FSPractice6 test1 = new FSPractice6();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]); 
        System.out.println(question1[2]); 
        System.out.println(question1[3]); 
        System.out.println(question1[4]); 
        //Test question two
        FSPractice6 test2 = new FSPractice6();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]); 
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);
        // Test question three
        FSPractice6 test3 = new FSPractice6();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        
    }

    /*Question one: Which tool would you use to measure "random object"?
    No picture*/
    private String[] generateQuestionOne() {
        //String array of objects used in the question
        String[] objectToMeasure = {"a beach ball", "a watermelon", "a soccerball", "a pumpkin", "a cup of salt", "2 cups of sugar", 
        "an ounce of milk", "3 ounces of water", "a pencil", "a shoe", "an eraser", "a paper clip", "a truck",
        "a couch", "a swimming pool", "the height of a wall", "a boat"};
        //Save a random object from objectToMeasure in randomObject to use in the question
        String randomObject = objectToMeasure[ThreadLocalRandom.current().nextInt(17)];
        String[] tools = {"Measuring tape", "Measuring cup", "Ruler", "Yardstick"}; //Array of possible answers
        String[] questionOne = new String[5]; //Array will hold question and possible answers
        questionOne[0] = "Which tool would use use to measure " + randomObject + "?"; //Actual question

        //If random object is a beach ball, watermelon, soccerball, or pumpkin
        if ((randomObject == objectToMeasure[0]) || (randomObject == objectToMeasure[1])
        || (randomObject == objectToMeasure[2]) || (randomObject == objectToMeasure[3])) {
            questionOne[1] = tools[0]; //The correct answer is measuring tape
            questionOne[2] = tools[1]; //Wrong answer
            questionOne[3] = tools[3]; //Wrong answer
            questionOne[4] = tools[2]; //Wrong answer

        }
        //if the object is salt, sugar, milk, or water
        if ((randomObject == objectToMeasure[4]) || (randomObject == objectToMeasure[5])
        || (randomObject == objectToMeasure[6]) || (randomObject == objectToMeasure[7])) {
            questionOne[1] = tools[1]; //The correct answer is measuring cup
            questionOne[2] = tools[3]; //Wrong answer
            questionOne[3] = tools[2]; //Wrong answer
            questionOne[4] = tools[0]; //Wrong answer

        }
        //if the object is a pencil, shoe, eraser, or paper clip
        if ((randomObject == objectToMeasure[8]) || (randomObject == objectToMeasure[9])
        || (randomObject == objectToMeasure[10]) || (randomObject == objectToMeasure[11])) {
            questionOne[1] = tools[2]; //The correct answer is ruler
            questionOne[2] = tools[0]; //Wrong answer
            questionOne[3] = tools[3]; //Wrong answer
            questionOne[4] = tools[1]; //Wrong answer

        }
        //If the object is a truck, couch, swimming pool, height of a wall, or a boat
        if ((randomObject == objectToMeasure[12]) || (randomObject == objectToMeasure[13])
        || (randomObject == objectToMeasure[14]) || (randomObject == objectToMeasure[15]) || (randomObject == objectToMeasure[16])) {
            questionOne[1] = tools[3]; //The correct answer is yard stick
            questionOne[2] = tools[1]; //Wrong answer
            questionOne[3] = tools[0]; //Wrong answer
            questionOne[4] = tools[2]; //Wrong answer

        }

        return questionOne;
        
    }

    /*Question two: Which would you use to measure a "randomObject"?
    No picture */
    private String[] generateQuestionTwo() {
        //String array of objects to measure
        String[] objectsToMeasure = {"a paper clip", "an eraser", "a compass", "a pencil", "a shoe", "an anchor", "a car", "a couch", "a person", 
        "a truck", "a swimming pool", "a boat"};
         //Save a random object from objectsToMeasure in randomObject to use in the question
        String randomObject = objectsToMeasure[ThreadLocalRandom.current().nextInt(12)];
        String[] units = {"Centimeters", "Inches", "Feet", "Yards"}; //Different units of measure used in the answers
        String[] questionTwo = new String[5]; //Array will hold question and possible answers
        questionTwo[0] = "Which would you use to measure " + randomObject + "?";

        //If it is a paper clip, erase, or compass
        if ((randomObject == objectsToMeasure[0]) || (randomObject == objectsToMeasure[1] 
        || (randomObject == objectsToMeasure[2]))) {
            questionTwo[1] = units[0]; //Answer = centimeters
            questionTwo[2] = units[1]; //Wrong answer
            questionTwo[3] = units[3]; //Wrong answer
            questionTwo[4] = units[2]; //Wrong answer

        }

        //If it is a pencil, shoe, or anchor
        if ((randomObject == objectsToMeasure[3]) || (randomObject == objectsToMeasure[4] 
        || (randomObject == objectsToMeasure[5]))) {
            questionTwo[1] = units[1]; //Answer = inches
            questionTwo[2] = units[3]; //Wrong answer
            questionTwo[3] = units[2]; //Wrong answer
            questionTwo[4] = units[0]; //Wrong answer

        }

        //If it is a car, couch, or person
        if ((randomObject == objectsToMeasure[6]) || (randomObject == objectsToMeasure[7] 
        || (randomObject == objectsToMeasure[8]))) {
            questionTwo[1] = units[2]; //Answer = feet
            questionTwo[2] = units[0]; //Wrong answer
            questionTwo[3] = units[3]; //Wrong answer
            questionTwo[4] = units[1]; //Wrong answer

        }

        //If it is a truck, swimming pool, or a boat
        if ((randomObject == objectsToMeasure[9]) || (randomObject == objectsToMeasure[10] 
        || (randomObject == objectsToMeasure[11]))) {
            questionTwo[1] = units[3]; //Answer = yards
            questionTwo[2] = units[1]; //Wrong answer
            questionTwo[3] = units[0]; //Wrong answer
            questionTwo[4] = units[2]; //Wrong answer

        }

        return questionTwo;
        
    }

    //Put picture next to question
    private String[] generateQuestionThree() {
        // String array of the objects used in the question
        String[] objectToGuess = { "A coffee cup", "A teapot", "A bathtub", "A tube of sunscreen", "A mug", "A yogurt cup", "Juice box", "truck", "milk carton" };
        // Get a random item from objectToGuess and assign it to randomObject
        String randomObject = objectToGuess[ThreadLocalRandom.current().nextInt(9)];
        String[] questionThree = new String[6]; // Array will be used to hold the question and possible answers
        questionThree[0] = "Does it hold more or less than 1 gallon? select the correct answer.\n"+
        "Hint: 1 gallon = 16 US cups\n"+randomObject; // The actual question

        if (randomObject == objectToGuess[0]) { // If the object is a coffeecup
            
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "cofeecup";

        }

        if (randomObject == objectToGuess[1]) { // If the object is a teapot
            
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "teapot";

        }

        if (randomObject == objectToGuess[2]) { // If the object is a bathtub
           
            
            questionThree[1] = "More than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "Less than"; // Wrong: too large
            questionThree[5] = "bathtub";

        }

        if (randomObject == objectToGuess[3]) { // If the object is a tube of sunscreen
           
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "sunscreen";
        }

        if (randomObject == objectToGuess[4]) { // If the object is a mug
            
            
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "mug";

        }

        if (randomObject == objectToGuess[5]) { // If the object is a yogurt cup
            
            
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "yogurt";


        }
        if (randomObject == objectToGuess[6]) { // If the object is a juicebox
            
            
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "juicebox";

        }
        if (randomObject == objectToGuess[7]) { // If the object is a dumptruck
            
            
            
            questionThree[1] = "More than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "Less than"; // Wrong: too large
            questionThree[5] = "truck";

        }
        if (randomObject == objectToGuess[8]) { // If the object is a milk carton
            
            
            
            questionThree[1] = "Less than"; // Correct: Average medium sized bird is 8 inches
            questionThree[2] = "More than"; // Wrong: too large
            questionThree[5] = "milk";

        }

        return questionThree;
       
    
}}
