//Purpose: First round of practice questions for Operation Beach
package Backend.Assessment;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class FSPractice1 extends Assessment {
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

    @Override
    public String[][] generateUserInputQuestion() {
        // TODO Auto-generated method stub
        return null;
    }
    public static void main(String[] args) {
          //Test question one
          FSPractice1 test1 = new FSPractice1();
          String[] question1 = test1.generateQuestionOne();
          System.out.println(question1[0]);
          System.out.println(question1[1]); 
          System.out.println(question1[2]); 
          System.out.println(question1[3]); 
          System.out.println(question1[4]); 
          //Test question two
          FSPractice1 test2 = new FSPractice1();
          String[] question2 = test2.generateQuestionTwo();
          System.out.println(question2[0]);
          System.out.println(question2[1]); 
          System.out.println(question2[2]); 
          System.out.println(question2[3]); 
          System.out.println(question2[4]);

    }
    
    //Question One: What is " " + " "?
    private String[] generateQuestionOne() {
        String[] questionOne = new String[6]; //Array will contain question and possible answers
        Random randomGenerator = new Random(); //Create random number generator
        int firstNumber = randomGenerator.nextInt(50) + 1; //Generate random number between 1 and 50 since sum cannot be > 100
        int secondNumber = randomGenerator.nextInt(50) + 1; //Generate random number between 1 and 50 since sum cannot be > 100
        int answer = firstNumber + secondNumber; //The answer is the first plus the second number
        questionOne[0] = "What is " + firstNumber + " + " + secondNumber + "?"; //Actual question
        
        if (answer <= 97) { //Because they can't work with numbers > 100
            questionOne[1] = Integer.toString(answer); //The correct answer
            questionOne[2] = Integer.toString(answer + 1); //First wrong answer
            questionOne[3] = Integer.toString(answer - 1); //Second wrong answer
            questionOne[4] = Integer.toString(answer + 3); //Third wrong answer
        }
        else { //answer was too high
            generateQuestionOne(); //Recursion until an appropriate question is generated
        }

        return questionOne;

    }

    //Question Two: What is "random number" - ? = "random number"?
    private String[] generateQuestionTwo() {
        String[] questionTwo = new String[6]; //Array will contain question and possible answers
        Random randomGenerator = new Random(); //Create random number generator
        int firstNumber = randomGenerator.nextInt(100) + 1; //Generate random number between 1 and 100 as the number we're subtracting from
        int sum = randomGenerator.nextInt(99) + 1; //Generate random number between 1 and 99 as the sum of the question
        int answer = firstNumber - sum; //The answer is the first number - the sum
        questionTwo[0] = "What is " + firstNumber + " - ? = " + sum + "?"; //The actual question
       
        if (firstNumber > sum) { //The number we're subtracting from has to be greater than the sum
            questionTwo[1] = Integer.toString(answer); //The actual answer
            questionTwo[2] = Integer.toString(answer + 3); //First wrong answer
            questionTwo[3] = Integer.toString(answer - 1); //Second wrong answer
            questionTwo[4] = Integer.toString(answer + 1); //Third wrong answer
        }
        else { //Invalid question. Sum is greater than first number
            //Switch sum and first number in EVERYTHING
            answer = sum - firstNumber;  //The answer is the sum - the first number now
            questionTwo[0] = "What is " + sum + " - ? = " + firstNumber + "?"; //The question switched around
            questionTwo[1] = Integer.toString(answer); //The actual answer
            questionTwo[2] = Integer.toString(answer + 3); //First wrong answer
            questionTwo[3] = Integer.toString(answer - 1); //Second wrong answer
            questionTwo[4] = Integer.toString(answer + 1); //Third wrong answer

        }

        return questionTwo;
        
    }
}