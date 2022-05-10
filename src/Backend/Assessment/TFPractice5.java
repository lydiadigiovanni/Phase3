package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Purpose: Second round of practice questions for Algebra Atoll
public class TFPractice5 extends Assessment{

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
                multipleChoice[0] = new String[]{"2"};
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
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
          
        }
        return multipleChoice;
    }
public static void main(String[] args) {
    //Test question one
    TFPractice5 test1 = new TFPractice5();
    String[] question1 = test1.generateQuestionOne();
    System.out.println(question1[0]);
    System.out.println(question1[1]); 
    System.out.println(question1[2]); 
    System.out.println(question1[3]); 
    System.out.println(question1[4]);
     //Test question two
     TFPractice5 test2 = new TFPractice5();
     String[] question2 = test2.generateQuestionTwo();
     System.out.println(question2[0]);
     System.out.println(question2[1]); 
     System.out.println(question2[2]); 
     System.out.println(question2[3]); 
     System.out.println(question2[4]);
       //test question three
    TFPractice5 test3 = new TFPractice5();
    String[] question3 = test3.generateQuestionThree();
    System.out.println(question3[0]);
    System.out.println(question3[1]);
    System.out.println(question3[2]);
    System.out.println(question3[3]);
    System.out.println(question3[4]);
}
 //Solve for y in " " = " " + " "y
 private String[] generateQuestionOne() {
    Random random = new Random(); //Will be used to generate random number
    int firstNum = random.nextInt(900) + 1; //firstNum is between 1 and 900
    int secondNum = random.nextInt(900) + 1; //secondNum is between 1 and 900
    int answer; //Will be used to store answer
    String[] questionOne = new String[6]; //String will hold question & possible answers
    if (firstNum > secondNum) { //The firstNum always needs to be greater. They don't work w/ negatives
        answer = firstNum - secondNum; //Answer is y = firstNum - secondNum
        questionOne[0] = "Solve for y in " + firstNum + " = " + secondNum + " + y"; //Actual question
        questionOne[1] = Integer.toString(answer); //Correct answer
        questionOne[2] = Integer.toString(answer + 1); //Wrong answer
        questionOne[3] = Integer.toString(answer - 1); //Wrong answer
        questionOne[4] = Integer.toString(answer+ 2); //Wrong answer
    }
    else { //Switch firstNum & secondNum to avoid negative answers
        answer = secondNum - firstNum; //Answer is now y = secondNum - firstNum
        questionOne[0] = "Solve for y in " + secondNum + " = " + firstNum + " + y"; //Actual question with firstNum & secondNum switched
        questionOne[1] = Integer.toString(answer); //Correct answer
        questionOne[2] = Integer.toString(answer + 1); //Wrong answer
        questionOne[3] = Integer.toString(answer - 1); //Wrong answer
        questionOne[4] = Integer.toString(answer+ 2); //Wrong answer

    }
    
    return questionOne;

    
}
    //TODO: FIX ROUNDING< ANSWER SO YOU DON'T NEED TO TYPE IN "x = "
//Find the value of y, if y - " " = " "
private String[] generateQuestionTwo() {
    Random random = new Random(); //Will be used to generate random numbers
    int subtractedNum = random.nextInt(100) + 1; //The number subtracted from y is between 1 & 100
    int numItEquals = random.nextInt(100) + 1; //The number after the = is between 1 & 100
    int answer = numItEquals + subtractedNum; //The answer is the number after = minus the subtratedNum
    String[] questionTwo = new String[6]; //Array will hold question & possible answers
    questionTwo[0] = "Find the value of y, if y - " + subtractedNum + " = " + numItEquals;
    questionTwo[1] = Integer.toString(answer); //Correct answer
    questionTwo[2] = Integer.toString(answer + 2); //Wrong answer
    questionTwo[3] = Integer.toString(answer - 2); //Wrong answer
    questionTwo[4] = Integer.toString(answer - 1); //Wrong answer

    return questionTwo;

}
     // Question Three:if x = ###, find the value of ##x-x##.
     private String[] generateQuestionThree() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(12) + 1; // The number in the question is between 1 and 100
        int num2 = random.nextInt(12) + 1;
        int num3 = random.nextInt(12) + 1;
        int num4 = random.nextInt(12) + 1;


        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // inserting random int values in arrayList
        intArray.add(num);
        intArray.add(num2);
        intArray.add(num3);
        intArray.add(num4);
 
        String[] questionThree = new String[6]; // Array will hold question & possible answers
        questionThree[0] = "if x = " + num + ", find the value of " + num2 + "x " +"- "+ num3 + "."; // Actual question
        questionThree[1] = (num*num2)-num3+""; // Answer
        questionThree[2] = (num*num3)-num2+""; // Wrong answer
        questionThree[3] = (num2*num)-num+""; // Wrong answer
        questionThree[4] = (num3*num2)-num2+""; // Wrong answer
 
        return questionThree;
 
    }
}

