//Purpose: Second round of practice questions for Operation Beach
package Backend.Assessment;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FSPractice2 extends Assessment {

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
        FSPractice2 test1 = new FSPractice2();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]); 
        System.out.println(question1[2]); 
        System.out.println(question1[3]); 
        System.out.println(question1[4]); 
        //Test question two
        FSPractice2 test2 = new FSPractice2();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]); 
        System.out.println(question2[2]); 
        System.out.println(question2[3]); 
        System.out.println(question2[4]); 
        //Test question three
        FSPractice2 test3 = new FSPractice2();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]); 
        System.out.println(question3[2]); 
        System.out.println(question3[3]); 
        System.out.println(question3[4]); 
    }
    
    //Question One: What is " " - " "?
    private String[] generateQuestionOne() {
        String[] questionOne = new String[6]; //Array will contain question and possible answers
        Random randomGenerator = new Random(); //Create random number generator
        int firstNumber = randomGenerator.nextInt(100) + 1; //Generate random number between 1 and 100
        int secondNumber = randomGenerator.nextInt(100) + 1;  //Generate random number between 1 and 100
        int answer = firstNumber - secondNumber;

        if (firstNumber > secondNumber) { //The first number needs to be the greater one
            questionOne[0] = "What is " + firstNumber + " - " + secondNumber + "?"; //The actual question
            questionOne[1] = Integer.toString(answer); //The answer;
            questionOne[2] = Integer.toString(answer + 3); //First wrong answer
            questionOne[3] = Integer.toString(answer - 1); //Second wrong answer
            questionOne[4] = Integer.toString(answer + 1); //Third wrong answer
        }
        else { //Second number is greater than the first. Switch them!
            //Switch the places of firstNumber and secondNumber in EVERYTHING
            answer = secondNumber - firstNumber; //The answer is the second minus the first number now
            questionOne[0] = "What is " + secondNumber + " - " + firstNumber + "?"; //The actual question
            questionOne[1] = Integer.toString(answer); //The answer;
            questionOne[2] = Integer.toString(answer + 3); //First wrong answer
            questionOne[3] = Integer.toString(answer - 1); //Second wrong answer
            questionOne[4] = Integer.toString(answer + 1); //Third wrong answer
            

        }

        return questionOne;

    }

    //Question Two: What is "random number" + ? = "random number"?
    private String[] generateQuestionTwo() {
        String[] questionTwo = new String[6]; //Array will contain question and possible answers
        Random randomGenerator = new Random(); //Create random number generator
        //Create random number between 1 and 99 since the sum can't be > 100
        int firstNumber = randomGenerator.nextInt(99) + 1; 
        int sum = randomGenerator.nextInt(100) + 1; //Create random number between 1 and 100
        int answer = sum - firstNumber; //Answer is sum - firstNumber in most cases

        if (sum > firstNumber) { //The sum is supposed to be the higher number
            questionTwo[0] = "What is " + firstNumber + " + ? = " + sum + "?"; //The actual question
            questionTwo[1] = Integer.toString(answer); //The answer
            questionTwo[2] = Integer.toString(answer + 3); //First wrong answer
            questionTwo[3] = Integer.toString(answer - 1); //Second wrong answer
            questionTwo[4] = Integer.toString(answer + 1); //Third wrong answer
        }
        else { //The first number was greater than the sum. Switch them!
            //Switch the first number and sum in EVERYTHING
            answer = firstNumber - sum; //The answer is now the first number - the sum
            questionTwo[0] = "What is " + sum + " + ? = " + firstNumber+ "?"; //Actual question switched around
            questionTwo[1] = Integer.toString(answer); //The answer
            questionTwo[2] = Integer.toString(answer + 3); //First wrong answer
            questionTwo[3] = Integer.toString(answer - 1); //Second wrong answer
            questionTwo[4] = Integer.toString(answer + 1); //Third wrong answer

        }

        return questionTwo;
        
    }

    //Question Three: You had " " apples and you give your friend " ". How many apples do you after left?
    private String[] generateQuestionThree() {
        String[] questionThree = new String[6]; //Array will contain question and possible answers
        String[] fruits = {"apples", "bananas", "oranges", "pineapples"}; //Array of fruits
        String randomFruit = fruits[ThreadLocalRandom.current().nextInt(4)]; //Fruit to use in the question/answer
        Random randomGenerator = new Random(); //Create random number generator
        int firstNumber = randomGenerator.nextInt(100) + 1; //Generate random number between 1 and 100
        int secondNumber = randomGenerator.nextInt(100) + 1;  //Generate random number between 1 and 100
        int answer = firstNumber - secondNumber; //Answer is basic subtraction

        if (firstNumber > secondNumber) { //The first number needs to be the greater one
            questionThree[0] = "You had " + firstNumber + " " + randomFruit + " and you give your friend " + secondNumber
            + ". How many " + randomFruit + " do you have left?"; //The question
            questionThree[1] = Integer.toString(answer) + " " + randomFruit; //The answer;
            questionThree[2] = Integer.toString(answer + 2) + " " + randomFruit; //First wrong answer
            questionThree[3] = Integer.toString(answer - 1) + " " + randomFruit; //Second wrong answer
            questionThree[4] = Integer.toString(answer + 1) + " " + randomFruit; //Third wrong answer
        }
        else { //Second number is greater than the first. Switch them!
            //Switch the places of firstNumber and secondNumber in EVERYTHING
            answer = secondNumber - firstNumber; //The answer is the second minus the first number now
            questionThree[0] = "You had " + secondNumber + " " + randomFruit + " and you give your friend " + firstNumber
            + ". How many " + randomFruit + " do you have left?"; //The question switched around
            questionThree[1] = Integer.toString(answer) + " " + randomFruit; //The answer;
            questionThree[2] = Integer.toString(answer + 2) + " " + randomFruit; //First wrong answer
            questionThree[3] = Integer.toString(answer - 1) + " " + randomFruit; //Second wrong answer
            questionThree[4] = Integer.toString(answer + 1) + " " + randomFruit; //Third wrong answer
            

        }

        return questionThree;
        
    }
}

