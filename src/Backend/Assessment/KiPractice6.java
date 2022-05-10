//Purpose: Second round of practice questions for Geometry Coast
package Backend.Assessment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KiPractice6 extends Assessment {
    
    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(1);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[] { "1" };
                multipleChoice[1] = generateQuestionTwo();
                break;
        }
        return multipleChoice;
    }

    @Override
    public String[][] generateTrueFalseQuestion() {
        return null;
    }
    @Override
    public String[][] generateUserInputQuestion() {//question one and two have pictures
        String[][] userInput = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(2);
        switch (i) {
            case 0:
                userInput[0] = new String[] { "1" };
                userInput[1] = generateQuestionTwo();
                break;
            case 1:
                userInput[0] = new String[] { "3" };
                userInput[1] = generateQuestionFour();
                break;
        }
        return userInput;
    }
    public static void main(String[] args) {
         //Test question one
         KiPractice6 test1 = new KiPractice6();
         String[] question1 = test1.generateQuestionOne();
         System.out.println(question1[0]);
         System.out.println(question1[1]); 
         System.out.println(question1[2]); 
         System.out.println(question1[3]); 
         System.out.println(question1[4]);
         //Test question two
         KiPractice6 test2 = new KiPractice6();
         String[] question2 = test2.generateQuestionTwo();
         System.out.println(question2[0]);
         System.out.println(question2[1]); 
         System.out.println(question2[2]); 
         System.out.println(question2[3]); 
         System.out.println(question2[4]);
         //Test question three
         KiPractice6 test3 = new KiPractice6();
         String[] question3 = test3.generateQuestionThree();
         System.out.println(question3[0]);
         System.out.println(question3[1]); 
         System.out.println(question3[2]); 
         System.out.println(question3[3]); 
         System.out.println(question3[4]);
         //Test question four
         KiPractice6 test4 = new KiPractice6();
         String[] question4 = test3.generateQuestionFour();
         System.out.println(question4[0]);
         System.out.println(question4[1]); 
         System.out.println(question4[2]); 
         System.out.println(question4[3]); 
         System.out.println(question4[4]);
        
    }

    //Question One: Which one is a " "? (Pics of shapes are the answers)
    private String[] generateQuestionOne() {
        String[] nameOfShapes = {"circle", "rectangle", "oval", "triangle", "diamond"}; //Array of the different names of shapes pictures
        ArrayList<String> shapeNames = new ArrayList<String>(); //Array list will be used to remove the answer from later
        //Add the contents to the ArrayList now
        shapeNames.add(0, nameOfShapes[0]);
        shapeNames.add(1, nameOfShapes[1]);
        shapeNames.add(2, nameOfShapes[2]);
        shapeNames.add(3, nameOfShapes[3]);
        shapeNames.add(4, nameOfShapes[4]);
        //randomItemName contains a random name of one of the items above
        String randomItemName = nameOfShapes[ThreadLocalRandom.current().nextInt(5)];
        String answer = randomItemName; //Store the answer in a string
        shapeNames.remove(answer); //Remove the answer from the ArrayList
        Random random = new Random(); //Create Random object
        //Get random element from the array that doesn't contain the right answer
        String[] questionOne = new String[6]; //Array will contain the question and its answers
        questionOne[0] = "Which one is a " + randomItemName + "?"; //Actual question
        questionOne[1] = answer; //The answer to the question
        /*Store the wrong answer in 2-4 by getting a random element from nameOfitems
        since the correct answer was removed from namesOfItems*/
        questionOne[2] = shapeNames.get(0);
        questionOne[3] = shapeNames.get(1);
        questionOne[4] = shapeNames.get(2);
        return questionOne;
    } 

    //Question Two: What shape is a " "? *no pics*
    private String[] generateQuestionTwo() {
        String[] itemsInQuestions = {"coin", "television", "watermelon", "pizza slice", "basic kite"}; //Array contains the thing/item in question
        String[] shapeOfItem = {"Circle", "Rectangle", "Oval", "Triangle", "Diamond"}; //Array contains shape that thing is
        String itemInQuestion = itemsInQuestions[ThreadLocalRandom.current().nextInt(5)]; //Used to randomize thing/item in the question
        String[] questionTwo = new String[6]; //Array will contain the question and its answers
        questionTwo[0] = "What shape is a " + itemInQuestion + "?";
       if (itemInQuestion == itemsInQuestions[0]) { //If the item is a soccer ball
            questionTwo[1] = shapeOfItem[0]; //Correct answer is circle
            questionTwo[2] = shapeOfItem[1]; //Wrong answer rectangle
            questionTwo[3] = shapeOfItem[2]; //Wrong answer is oval
            questionTwo[4] = shapeOfItem[3]; //Wrong answer is triangle
        }
        if (itemInQuestion == itemsInQuestions[1]) { //If the item is a television
            questionTwo[1] = shapeOfItem[1]; //Correct answer is rectangle
            questionTwo[2] = shapeOfItem[0]; //Wrong answer is circle
            questionTwo[3] = shapeOfItem[2]; //Wrong answer is oval
            questionTwo[4] = shapeOfItem[3]; //Wrong answer is triangle
          
        }
        if (itemInQuestion == itemsInQuestions[2]) {  //If the item is a watermelon
            questionTwo[1] = shapeOfItem[2]; //Correct answer is oval
            questionTwo[2] = shapeOfItem[1]; //Wrong answer rectangle
            questionTwo[3] = shapeOfItem[3]; //Wrong answer is triangle
            questionTwo[4] = shapeOfItem[4]; //Wrong answer is diamond
          
        }
        if (itemInQuestion == itemsInQuestions[3]) { //If the item is a pizza slice
            questionTwo[1] = shapeOfItem[3]; //Correct answer is triangle
            questionTwo[2] = shapeOfItem[1]; //Wrong answer is rectangle
            questionTwo[3] = shapeOfItem[2]; //Wrong answer is oval
            questionTwo[4] = shapeOfItem[4]; //Wrong answer is diamond
           
        }
        if (itemInQuestion == itemsInQuestions[4]) { //If the item is a kite
            questionTwo[1] = shapeOfItem[4]; //Correct answer in diamond
            questionTwo[2] = shapeOfItem[1]; //Wrong answer is rectangle
            questionTwo[3] = shapeOfItem[2]; //Wrong answer is oval
            questionTwo[4] = shapeOfItem[3]; //Wrong answer is triangle
        } 
    
        return questionTwo;

    }  
    
    //Question Three: Which picture is a " "? (3D shapes) Multiple choice: Pictures in answers
    private String[] generateQuestionThree() {
        String[] shapes = {"cylinder", "sphere", "cone", "rectangular prism", "pyramid", "cube"}; //Array of shapes to use in question itself
        String shapeInQuestion = shapes[ThreadLocalRandom.current().nextInt(6)]; //Get random shape from shapes
        String[] answerPics = {"cylinder pic", "sphere pic", "cone pic", "rectangular prism pic", "pyramid pic", "cube pic"};
        String[] questionThree = new String[6]; //String will hold question & possible answers
        questionThree[0] = "Which picture is a " + shapeInQuestion + "?"; //Question
        if (shapeInQuestion == shapes[0]) { //If shape is a cylinder
            questionThree[1] = answerPics[0]; //Answer is cylinder pic
            questionThree[2] = answerPics[1]; //Wrong
            questionThree[3] = answerPics[2]; //Wrong
            questionThree[4] = answerPics[3]; //Wrong
        }
        if (shapeInQuestion == shapes[1]) { //If shape is a sphere
            questionThree[1] = answerPics[1]; //Answer is sphere pic
            questionThree[2] = answerPics[0]; //Wrong
            questionThree[3] = answerPics[4]; //Wrong
            questionThree[4] = answerPics[5]; //Wrong
        }
        if (shapeInQuestion == shapes[2]) { //If shape is a cone
            questionThree[1] = answerPics[2]; //Answer is cone pic
            questionThree[2] = answerPics[3]; //Wrong
            questionThree[3] = answerPics[4]; //Wrong
            questionThree[4] = answerPics[5]; //Wrong
        }
        if (shapeInQuestion == shapes[3]) { //If shape is a rectangular prism
            questionThree[1] = answerPics[3]; //Answer is rectangular prism pic
            questionThree[2] = answerPics[1]; //Wrong
            questionThree[3] = answerPics[2]; //Wrong
            questionThree[4] = answerPics[4]; //Wrong
        }
        if (shapeInQuestion == shapes[4]) { //If shape is a pyramid
            questionThree[1] = answerPics[4]; //Answer is pic
            questionThree[2] = answerPics[5]; //Wrong
            questionThree[3] = answerPics[0]; //Wrong
            questionThree[4] = answerPics[3]; //Wrong
        }
        if (shapeInQuestion == shapes[5]) { //If shape is a cube
            questionThree[1] = answerPics[5]; //Answer is cube pic
            questionThree[2] = answerPics[1]; //Wrong
            questionThree[3] = answerPics[2]; //Wrong
            questionThree[4] = answerPics[0]; //Wrong
        }
        return questionThree;
        
    }

     //Question Four: What is the name of this 3D shape? Show shape next to picture. Answers are the name of shapes
     private String[] generateQuestionFour() {
        String[] picsOfShapes = {"cylinder pic", "sphere pic", "cone pic", "rectangular prism pic", "pyramid pic", "cube pic"}; //Array of pictures to use next to question
        String randomPic = picsOfShapes[ThreadLocalRandom.current().nextInt(6)]; //Get random shape from shapes
        String[] answers = {"cylinder", "sphere", "cone", "rectangular prism", "pyramid", "cube"}; //Different answers
        String[] questionFour = new String[6]; //String will hold question & possible answers
        questionFour[0] = "What is the name of this shape? "; //Question
        if (randomPic == picsOfShapes[0]) { //If pic is a cylinder
            questionFour[1] = answers[0]; //Answer is cylinder
            questionFour[2] = answers[5]; //Wrong
            questionFour[3] = answers[2]; //Wrong
            questionFour[4] = answers[3]; //Wrong
            questionFour[5] = "cylinder";
        }
        if (randomPic == picsOfShapes[1]) { //If pic is sphere pic
            questionFour[1] = answers[1]; //Answer is sphere 
            questionFour[2] = answers[0]; //Wrong
            questionFour[3] = answers[2]; //Wrong
            questionFour[4] = answers[4]; //Wrong
            questionFour[5] = "sphere";
        }
        if (randomPic == picsOfShapes[2]) { //If pic is cone pic
            questionFour[1] = answers[2]; //Answer is cone 
            questionFour[2] = answers[0]; //Wrong
            questionFour[3] = answers[3]; //Wrong
            questionFour[4] = answers[1]; //Wrong
            questionFour[5] = "cone";
        }
        if (randomPic == picsOfShapes[3]) { //If pic is rectangular prism pic
            questionFour[1] = answers[3]; //Answer is rectangular prism 
            questionFour[2] = answers[1]; //Wrong
            questionFour[3] = answers[5]; //Wrong
            questionFour[4] = answers[2]; //Wrong
            questionFour[5] = "rectangularprism";
        }
        if (randomPic == picsOfShapes[4]) { //If pic is pyramid pic
            questionFour[1] = answers[4]; //Answer is pyramid
            questionFour[2] = answers[5]; //Wrong
            questionFour[3] = answers[1]; //Wrong
            questionFour[4] = answers[2]; //Wrong
            questionFour[5] = "pyramid";
        }
        if (randomPic == picsOfShapes[5]) { //If pic is cube pic
            questionFour[1] = answers[5]; //Answer is cube 
            questionFour[2] = answers[3]; //Wrong
            questionFour[3] = answers[4]; //Wrong
            questionFour[4] = answers[0]; //Wrong
            questionFour[5] = "cube";
        }
        return questionFour;
        
    }
}