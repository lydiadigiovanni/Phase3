//Purpose: First round of practice questions for Operation Beach
package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FSPractice1 extends Assessment {
    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(4);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[] { "0" };
                multipleChoice[1] = generateQuestionOne();
                break;
            case 1:
                multipleChoice[0] = new String[] { "1" };
                multipleChoice[1] = generateQuestionTwo();
                break;
            case 2:
                multipleChoice[0] = new String[] { "2" };
                multipleChoice[1] = generateQuestionThree();
                break;    
            case 3:
                multipleChoice[0] = new String[] { "3" };
                multipleChoice[1] = generateQuestionThree();
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
        // Test question one
        FSPractice1 test1 = new FSPractice1();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]);
        System.out.println(question1[2]);
        System.out.println(question1[3]);
        System.out.println(question1[4]);
        // Test question two
        FSPractice1 test2 = new FSPractice1();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]);
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);
        //Test question three
        FSPractice1 test3 = new FSPractice1();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);
        //Test question four
        FSPractice1 test4 = new FSPractice1();
        String[] question4 = test4.generateQuestionFour();
        System.out.println(question4[0]);
        System.out.println(question4[1]);
        System.out.println(question4[2]);
        System.out.println(question4[3]);
        System.out.println(question4[4]);

    }

    // Question One: What is " " + " "?
    private String[] generateQuestionOne() {
        String[] questionOne = new String[6]; // Array will contain question and possible answers
        Random randomGenerator = new Random(); // Create random number generator
        int firstNumber = randomGenerator.nextInt(50) + 1; // Generate random number between 1 and 50 since sum cannot
                                                           // be > 100
        int secondNumber = randomGenerator.nextInt(50) + 1; // Generate random number between 1 and 50 since sum cannot
                                                            // be > 100
        int answer = firstNumber + secondNumber; // The answer is the first plus the second number
        questionOne[0] = "What is " + firstNumber + " + " + secondNumber + "?"; // Actual question

        if (answer <= 97) { // Because they can't work with numbers > 100
            questionOne[1] = Integer.toString(answer); // The correct answer
            questionOne[2] = Integer.toString(answer + 1); // First wrong answer
            questionOne[3] = Integer.toString(answer - 1); // Second wrong answer
            questionOne[4] = Integer.toString(answer + 3); // Third wrong answer
        } else { // answer was too high
            generateQuestionOne(); // Recursion until an appropriate question is generated
        }

        return questionOne;

    }

    // Question Two: What is "random number" - ? = "random number"?
    private String[] generateQuestionTwo() {
        String[] questionTwo = new String[6]; // Array will contain question and possible answers
        Random randomGenerator = new Random(); // Create random number generator
        int firstNumber = randomGenerator.nextInt(100) + 1; // Generate random number between 1 and 100 as the number
                                                            // we're subtracting from
        int sum = randomGenerator.nextInt(99) + 1; // Generate random number between 1 and 99 as the sum of the question
        int answer = firstNumber - sum; // The answer is the first number - the sum
        questionTwo[0] = "What is " + firstNumber + " - ? = " + sum + "?"; // The actual question

        if (firstNumber > sum) { // The number we're subtracting from has to be greater than the sum
            questionTwo[1] = Integer.toString(answer); // The actual answer
            questionTwo[2] = Integer.toString(answer + 3); // First wrong answer
            questionTwo[3] = Integer.toString(answer - 1); // Second wrong answer
            questionTwo[4] = Integer.toString(answer + 1); // Third wrong answer
        } else { // Invalid question. Sum is greater than first number
                 // Switch sum and first number in EVERYTHING
            answer = sum - firstNumber; // The answer is the sum - the first number now
            questionTwo[0] = "What is " + sum + " - ? = " + firstNumber + " ?"; // The question switched around
            questionTwo[1] = Integer.toString(answer); // The actual answer
            questionTwo[2] = Integer.toString(answer + 3); // First wrong answer
            questionTwo[3] = Integer.toString(answer - 1); // Second wrong answer
            questionTwo[4] = Integer.toString(answer + 1); // Third wrong answer

        }

        return questionTwo;

    }

    // Question Three: What number comes after x, x, _______,x? pick answer on array

    private String[] generateQuestionThree() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(500) + 100; // random number 1 to 50

        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds random possible answers

        intArray.add(num);

        String[] questionThree = new String[6]; // Array will hold question & possible answers
        questionThree[0] = "Count by Four's, What number comes next?  " + num + ", " + (num + 4) + ", " + "________"
                + ", " + (num + 12); // Actual question
        questionThree[1] = Integer.toString(num + 8); // Answer
        questionThree[2] = Integer.toString(num + 10); // Wrong Answer
        questionThree[3] = Integer.toString(num + 15); // Wrong Answer
        questionThree[4] = Integer.toString(num + 12); // Wrong Answer

        return questionThree;

    }

    //Question Three: You have " " apples and your friend gives you " " more. How many apples do you have now?
    private String[] generateQuestionFour() {
        String[] questionFour = new String[6]; //Array will contain question and possible answers
        String[] fruits = {"apples", "bananas", "oranges", "pineapples"}; //Array of fruits
        String randomFruit = fruits[ThreadLocalRandom.current().nextInt(4)]; //Fruit to use in the question/answer
        Random randomGenerator = new Random(); //Create random number generator
        int firstNumber = randomGenerator.nextInt(100) + 1; //Generate random number between 1 and 100
        int secondNumber = randomGenerator.nextInt(100) + 1;  //Generate random number between 1 and 100
        int answer = firstNumber + secondNumber; //Answer is basic addition
        questionFour[0] = "You have " + firstNumber + " " + randomFruit + " and your friend gives you "
        + secondNumber + " more. How many " + randomFruit + " do you have now?"; //The question
        questionFour[1] = Integer.toString(answer) ; //The answer;
        questionFour[2] = Integer.toString(answer + 2) ; //First wrong answer
        questionFour[3] = Integer.toString(answer - 1) ; //Second wrong answer
        questionFour[4] = Integer.toString(answer + 1) ; //Third wrong answer

        return questionFour;
        
    }
}