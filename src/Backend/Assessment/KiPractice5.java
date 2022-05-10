//Purpose: First round of practice questions for Geometry Coast
package Backend.Assessment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KiPractice5 extends Assessment {
    
    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(1);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[] { "3" };
                multipleChoice[1] = generateQuestionFour();
                break;
        }
        return multipleChoice;
    }

    @Override
    public String[][] generateTrueFalseQuestion() {
        return null;
    }

    @Override
    public String[][] generateUserInputQuestion() {//question 1 and 2 has pictures
        String[][] userInput = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(3);
        switch (i) {
            case 0:
                userInput[0] = new String[] { "0" };
                userInput[1] = generateQuestionOne();
                break;
            case 1:
                userInput[0] = new String[] { "1" };
                userInput[1] = generateQuestionTwo();
                break;
           case 2:
                userInput[0] = new String[] { "2" };
                userInput[1] = generateQuestionThree();
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

    //Question Three: How many sides does a " " have? (show pic of shape in the question)
    private String[] generateQuestionThree() {
        String[] shapes = {"square", "circle", "rectangle", "triangle", "diamond", "pentagon",
        "hexagon", "oval", "octagon", "star", "trapezoid", "parallelogram"}; //Array of shapes for the question
        String randomShape = shapes[ThreadLocalRandom.current().nextInt(13)]; //Get random shape for the question
        String[] questionThree = new String[6]; //Array will hold questions and possible answers
        questionThree[0] = "How many sides does a " + randomShape + " have?"; //Actual question
        if (randomShape == shapes[0]) { //If randomShape is a square
            questionThree[1] = "4"; //Correct answer 
            questionThree[2] = "3"; //Wrong answer
            questionThree[3] = "2"; //Wrong answer
            questionThree[4] = "5"; //Wrong answer

        }
        if (randomShape == shapes[1])  { //If randomShape is a circle
            questionThree[1] = "0"; //Correct answer 
            questionThree[2] = "1"; //Wrong answer
            questionThree[3] = "2"; //Wrong answer
            questionThree[4] = "3"; //Wrong answer

        }
        if (randomShape == shapes[2])  { //If randomShape is a rectangle
            questionThree[1] = "4"; //Correct answer 
            questionThree[2] = "3"; //Wrong answer
            questionThree[3] = "5"; //Wrong answer
            questionThree[4] = "6"; //Wrong answer

        }
        if (randomShape == shapes[3])  { //If randomShape is a triangle
            questionThree[1] = "3"; //Correct answer 
            questionThree[2] = "4"; //Wrong answer
            questionThree[3] = "5"; //Wrong answer
            questionThree[4] = "2"; //Wrong answer

        }
        if (randomShape == shapes[4])  { //If randomShape is a diamond
            questionThree[1] = "4"; //Correct answer 
            questionThree[2] = "3"; //Wrong answer
            questionThree[3] = "2"; //Wrong answer
            questionThree[4] = "5"; //Wrong answer

        }
        if (randomShape == shapes[5])  { //If randomShape is a pentagon
            questionThree[1] = "4"; //Correct answer 
            questionThree[2] = "5"; //Wrong answer
            questionThree[3] = "2"; //Wrong answer
            questionThree[4] = "6"; //Wrong answer

        }
        if (randomShape == shapes[6])  { //If randomShape is a hexagon
            questionThree[1] = "6"; //Correct answer 
            questionThree[2] = "7"; //Wrong answer
            questionThree[3] = "8"; //Wrong answer
            questionThree[4] = "5"; //Wrong answer

        }
        if (randomShape == shapes[7])  { //If randomShape is an oval
            questionThree[1] = "0"; //Correct answer 
            questionThree[2] = "1"; //Wrong answer
            questionThree[3] = "2"; //Wrong answer
            questionThree[4] = "4"; //Wrong answer

        }
        if (randomShape == shapes[8])  { //If randomShape is an octagon
            questionThree[1] = "8"; //Correct answer 
            questionThree[2] = "7"; //Wrong answer
            questionThree[3] = "6"; //Wrong answer
            questionThree[4] = "10"; //Wrong answer

        }
        if (randomShape == shapes[9])  { //If randomShape is a star
            questionThree[1] = "5"; //Correct answer 
            questionThree[2] = "4"; //Wrong answer
            questionThree[3] = "8"; //Wrong answer
            questionThree[4] = "9"; //Wrong answer

        }
        if (randomShape == shapes[10])  { //If randomShape is a trapezoid
            questionThree[1] = "4"; //Correct answer 
            questionThree[2] = "5"; //Wrong answer
            questionThree[3] = "3"; //Wrong answer
            questionThree[4] = "6"; //Wrong answer
            

        }
        if (randomShape == shapes[11])  { //If randomShape is a parallelogram
            questionThree[1] = "4"; //Correct answer 
            questionThree[2] = "2"; //Wrong answer
            questionThree[3] = "3"; //Wrong answer
            questionThree[4] = "5"; //Wrong answer

        }

        return questionThree;

    }
    
     //Question Four: How many corners does a " " have? *no picture*
     private String[] generateQuestionFour() {
        String[] shapes = {"square", "circle", "rectangle", "triangle", "diamond", "pentagon",
        "hexagon", "oval", "octagon", "star", "trapezoid", "parallelogram"}; //Array of shapes for the question
        String randomShape = shapes[ThreadLocalRandom.current().nextInt(13)]; //Get random shape for the question
        String[] questionFour = new String[6]; //Array will hold questions and possible answers
        questionFour[0] = "How many corners does a " + randomShape + " have?"; //Actual question
        if (randomShape == shapes[0]) { //If randomShape is a square
            questionFour[1] = "4"; //Correct answer 
            questionFour[2] = "3"; //Wrong answer
            questionFour[3] = "2"; //Wrong answer
            questionFour[4] = "6"; //Wrong answer

        }
        if (randomShape == shapes[1])  { //If randomShape is a circle
            questionFour[1] = "0"; //Correct answer 
            questionFour[2] = "1"; //Wrong answer
            questionFour[3] = "2"; //Wrong answer
            questionFour[4] = "4"; //Wrong answer

        }
        if (randomShape == shapes[2])  { //If randomShape is a rectangle
            questionFour[1] = "4"; //Correct answer 
            questionFour[2] = "3"; //Wrong answer
            questionFour[3] = "5"; //Wrong answer
            questionFour[4] = "6"; //Wrong answer

        }
        if (randomShape == shapes[3])  { //If randomShape is a triangle
            questionFour[1] = "3"; //Correct answer 
            questionFour[2] = "4"; //Wrong answer
            questionFour[3] = "5"; //Wrong answer
            questionFour[4] = "2"; //Wrong answer

        }
        if (randomShape == shapes[4])  { //If randomShape is a diamond
            questionFour[1] = "4"; //Correct answer 
            questionFour[2] = "3"; //Wrong answer
            questionFour[3] = "6"; //Wrong answer
            questionFour[4] = "5"; //Wrong answer

        }
        if (randomShape == shapes[5])  { //If randomShape is a pentagon
            questionFour[1] = "5"; //Correct answer 
            questionFour[2] = "4"; //Wrong answer
            questionFour[3] = "3"; //Wrong answer
            questionFour[4] = "6"; //Wrong answer

        }
        if (randomShape == shapes[6])  { //If randomShape is a hexagon
            questionFour[1] = "6"; //Correct answer 
            questionFour[2] = "7"; //Wrong answer
            questionFour[3] = "9"; //Wrong answer
            questionFour[4] = "5"; //Wrong answer

        }
        if (randomShape == shapes[7])  { //If randomShape is an oval
            questionFour[1] = "0"; //Correct answer 
            questionFour[2] = "1"; //Wrong answer
            questionFour[3] = "2"; //Wrong answer
            questionFour[4] = "3"; //Wrong answer

        }
        if (randomShape == shapes[8])  { //If randomShape is an octagon
            questionFour[1] = "8"; //Correct answer 
            questionFour[2] = "7"; //Wrong answer
            questionFour[3] = "5"; //Wrong answer
            questionFour[4] = "10"; //Wrong answer

        }
        if (randomShape == shapes[9])  { //If randomShape is a star
            questionFour[1] = "5"; //Correct answer 
            questionFour[2] = "4"; //Wrong answer
            questionFour[3] = "7"; //Wrong answer
            questionFour[4] = "9"; //Wrong answer

        }
        if (randomShape == shapes[10])  { //If randomShape is a trapezoid
            questionFour[1] = "4"; //Correct answer 
            questionFour[2] = "2"; //Wrong answer
            questionFour[3] = "3"; //Wrong answer
            questionFour[4] = "6"; //Wrong answer
            

        }
        if (randomShape == shapes[11])  { //If randomShape is a parallelogram
            questionFour[1] = "4"; //Correct answer 
            questionFour[2] = "2"; //Wrong answer
            questionFour[3] = "3"; //Wrong answer
            questionFour[4] = "6"; //Wrong answer

        }

        return questionFour;

    }
}
