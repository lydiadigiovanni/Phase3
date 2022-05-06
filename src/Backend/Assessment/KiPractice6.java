//Purpose: Second round of practice questions for Geometry Coast
package Backend.Assessment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KiPractice6 extends Assessment {
    
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
    }

    @Override
    public String[][] generateUserInputQuestion() {
        // TODO Auto-generated method stub
        return null;
    }

    //Question One: Which one is a " "? (Pics of shapes are the answers)
    private String[] generateQuestionOne() {
        String[] nameOfShapes = {"circle", "rectangle", "oval", "triangle", "diamond"}; //Array of the different names of shapes
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

    //Question Two: Which shape is a "soccer ball, television, watermelon, pizza slice, kite"? 
    //Pics of items are the answers
    private String[] generateQuestionTwo() {
        String[] itemsInQuestions = {"soccer ball", "television", "watermelon", "pizza slice", "kite"}; //Array contains the thing/item in question
        String[] shapeOfItem = {"Circle", "Rectangle", "Oval", "Triangle", "Diamond"}; //Array contains shape that thing is
        String itemInQuestion = itemsInQuestions[ThreadLocalRandom.current().nextInt(6)]; //Used to randomize thing/item in the question
        String[] questionTwo = new String[6]; //Array will contain the question and its answers
        questionTwo[0] = "Which shape is a " + itemInQuestion + "?";
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
   
    
}