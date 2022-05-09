//Purpose: First round of practice questions for Geometry Coast
package Backend.Assessment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KiPractice5 extends Assessment {
    
    @Override
    public String[][] generateMultipleChoiceQuestion() {
        return null;
    }

    @Override
    public String[][] generateTrueFalseQuestion() {
        return null;
    }

    @Override
    public String[][] generateUserInputQuestion() {//question 1 and 2 has pictures
        String[][] userInput = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(2);
        switch (i) {
            case 0:
                userInput[0] = new String[] { "0" };
                userInput[1] = generateQuestionOne();
                break;
            case 1:
                userInput[0] = new String[] { "1" };
                userInput[1] = generateQuestionTwo();
                break;
           
        }
        return userInput;
    } 

    //Question one: What shape is this? Displays picture. Answers are words
    private String[] generateQuestionOne() {
        String[] nameOfItems = {"circle", "rectangle", "oval", "triangle", "diamond"}; //Array of what are supposed to be the images
        ArrayList<String> namesOfItems = new ArrayList<String>(); //Array list will be used to remove the answer from later
        //Add the contents to the ArrayList now
        namesOfItems.add(0, nameOfItems[0]);
        namesOfItems.add(1, nameOfItems[1]);
        namesOfItems.add(2, nameOfItems[2]);
        namesOfItems.add(3, nameOfItems[3]);
        namesOfItems.add(4, nameOfItems[4]);
        //randomItemName contains a random name of one of the items above
        String randomItemName = nameOfItems[ThreadLocalRandom.current().nextInt(5)];
        String answer = randomItemName; //Store the answer in a string
        namesOfItems.remove(answer); //Remove the answer from the ArrayList
        Random random = new Random(); //Create Random object
        //Get random element from the array that doesn't contain the right answer
        String[] questionOne = new String[6]; //Array will contain the question and its answers
        questionOne[0] = "What shape is this?"; //Actual question
        questionOne[1] = answer; //The answer to the question
        /*Store the wrong answer in 2-4 by getting a random element from nameOfitems
        since the correct answer was removed from namesOfItems*/
        questionOne[2] = namesOfItems.get(0);
        questionOne[3] = namesOfItems.get(1);
        questionOne[4] = namesOfItems.get(2);
        return questionOne;
    }

    //Question two: Which picture is a "circle, rectangle, oval, triangle, diamond?" Answers are pictures
    private String[] generateQuestionTwo() {
        String[] shapesInQuestions = {"circle", "rectangle", "oval", "triangle", "diamond"}; //Array contains the name of the shape
        String[] picsForItems = {"Soccer ball", "Television", "Watermelon", "Pizza slice", "Kite"}; //Array contains what picture that shape is
        String shapeInQuestion = shapesInQuestions[ThreadLocalRandom.current().nextInt(6)]; //Used to randomize the shape in the question
        String[] questionTwo = new String[6]; //Array will contain the question and its answers
        questionTwo[0] = "Which picture is a " + shapeInQuestion + "?";
       if (shapeInQuestion == shapesInQuestions[0]) { //If the shape is a circle
            questionTwo[1] = picsForItems[0]; //Correct answer is soccer ball
            questionTwo[2] = picsForItems[1]; //Wrong answer is television
            questionTwo[3] = picsForItems[2]; //Wrong answer is watermelon
            questionTwo[4] = picsForItems[3]; //Wrong answer is pizza slice
        }
        if (shapeInQuestion == shapesInQuestions[1]) { //If the shape in the question is a rectangle
            questionTwo[1] = picsForItems[1]; //Correct answer is television
            questionTwo[2] = picsForItems[0]; //Wrong answer is soccer ball
            questionTwo[3] = picsForItems[2]; //Wrong answer is watermelon
            questionTwo[4] = picsForItems[3]; //Wrong answer is pizza slice
          
        }
        if (shapeInQuestion == shapesInQuestions[2]) {  //If the shape in the question is an oval
            questionTwo[1] = picsForItems[2]; //Correct answer is watermelon
            questionTwo[2] = picsForItems[1]; //Wrong answer soccer ball
            questionTwo[3] = picsForItems[3]; //Wrong answer is pizza slice
            questionTwo[4] = picsForItems[4]; //Wrong answer is kite
          
        }
        if (shapeInQuestion == shapesInQuestions[3]) { //If the shape in the question is a triangle
            questionTwo[1] = picsForItems[3]; //Correct answer is pizza slice
            questionTwo[2] = picsForItems[1]; //Wrong answer is soccerball
            questionTwo[3] = picsForItems[2]; //Wrong answer is watermelon
            questionTwo[4] = picsForItems[4]; //Wrong answer is kite
           
        }
        if (shapeInQuestion == shapesInQuestions[4]) { //If the shape in the question is a diamond
            questionTwo[1] = picsForItems[4]; //Correct answer in kite
            questionTwo[2] = picsForItems[1]; //Wrong answer is television
            questionTwo[3] = picsForItems[2]; //Wrong answer is watermelon
            questionTwo[4] = picsForItems[3]; //Wrong answer is pizza slice
        } 
        return questionTwo;

    }  
}
