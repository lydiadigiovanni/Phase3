import java.util.Random;

//Purpose: Generate the questions for the first practice on Operation Isle (KINDERGARDEN)

public class OperationPractice1 {
    public static void main(String[] args) {
        OperationPractice1 test = new OperationPractice1();
        String[] question = test.generateQuestionOne();
        System.out.println(question[0]);
        System.out.println(question[1]);
        System.out.println(question[3]);
        System.out.println(question[4]);
        question = test.generateQuestionTwo();
        System.out.println(question[0]);
        System.out.println(question[1]);
        System.out.println(question[2]);
        System.out.println(question[3]);
        System.out.println(question[4]);
        question = test.generateQuestionThree();
        System.out.println(question[0]);
        System.out.println(question[1]);
        System.out.println(question[2]);
        System.out.println(question[3]);
        System.out.println(question[4]);
        question = test.generateQuestionFour();
        System.out.println(question[0]);
        System.out.println(question[1]);
        System.out.println(question[2]);
        System.out.println(question[3]);
        System.out.println(question[4]);
    }

    //Question One: What is " " + " "?
    private String[] generateQuestionOne() {
        String questionOne[] = new String[6]; //Array wild hold questions and possible answers
        Random random = new Random(); //Random object will be used to generate two random numbers
        int firstRandomNum = random.nextInt((10 - 1) + 1) + 1; //First random number between 1 and 10
        int secondRandomNum = random.nextInt((10 - 1) + 1); //Second random number between 1 and 10
        questionOne[0] = "What is " + firstRandomNum + " + " + secondRandomNum + "?"; //0th index: actual question
        int answer = firstRandomNum + secondRandomNum; //Answer is just basic addition
        questionOne[1] = Integer.toString(answer); //1st index: the answer
        questionOne[2] = Integer.toString(answer-1); //Wrong answer 1
        questionOne[3] = Integer.toString(answer+1); //Wrong answer 2
        questionOne[4] = Integer.toString(answer+2); //Wrong answer 3
        return questionOne;
    }

    //Question Two: What is " " - " "?
    private String[] generateQuestionTwo() {
        String questionTwo[] = new String[6]; //Array wild hold questions and possible answers
        Random random = new Random(); //Random object will be used to generate two random numbers
        int firstRandomNum = random.nextInt((10 - 1) + 1) + 1; //First random number between 1 and 10
        int secondRandomNum = random.nextInt((10 - 1) + 1); //Second random number between 1 and 10
        questionTwo[0] = "What is " + firstRandomNum + " - " + secondRandomNum + "?"; //0th index: actual question
        int answer = firstRandomNum - secondRandomNum; //Answer is just basic addition
        questionTwo[1] = Integer.toString(answer); //1st index: the answer
        questionTwo[2] = Integer.toString(answer-1); //Wrong answer 1
        questionTwo[3] = Integer.toString(answer+1); //Wrong answer 2
        questionTwo[4] = Integer.toString(answer+2); //Wrong answer 3
        return questionTwo;
    }
    //Question Three: What is the missing number in "_" + "1,2,3,4,etc" = "1,2,3,4,etc"?
    private String[] generateQuestionThree() {
        String questionThree[] = new String[6]; //Array will hold questions and possible answers
        Random random = new Random(); //Create Random object to generate the number after the + and the number after the =
        /*Generate the number after the +; It has to be between 1 and 9 instead of 1 and 10 
        because the # after the = cannot be > 10 */
        int plusWhatNumber = random.nextInt((9 - 1) + 1) + 1; 
        //Generate number between 1 and 10 bc the number after the = can be 10
        int numberItEquals = random.nextInt((10 - 1) + 1) + 1; //Generate number between 1 and 10 bc the number after the = can be 10
        questionThree[0] = "What is the missing number in ____ + " + plusWhatNumber + " = " + numberItEquals; //Actual question
        int answer = numberItEquals - plusWhatNumber; //The answer is the number after = minus the number they're adding to
        questionThree[1] = Integer.toString(answer); //Actual answer
        questionThree[2] = Integer.toString(answer-1); //Wrong answer
        questionThree[3] = Integer.toString(answer+1); //Wrong answer
        questionThree[4] = Integer.toString(answer+2);  //Wrong answer
        return questionThree;
    }

    //Question Three: What is the missing number in "1,2,3,4,etc" - " " = "1,2,3,4,etc"?
    private String[] generateQuestionFour() {
        String questionFour[] = new String[6]; //Array will hold questions and possible answers
        Random random = new Random(); //Random object used to generate the # before the - and after the =
        int firstNumInEquation = random.nextInt((10 - 1) + 1) + 1; //Generate the number before the - sign
        int numberItEquals = random.nextInt((9 - 1) + 1) + 1;  //Generate number between 1 and 9 because the number it equals can't be 10
        if (firstNumInEquation > numberItEquals) { //The number we're subtracting from needs to be > than the difference
            questionFour[0] = "What is the missing number in " + firstNumInEquation + " - ____ = " + numberItEquals; //Actual question
            int answer = firstNumInEquation - numberItEquals; //Can get the answer by subtracting the number it equals from the 1st number
            questionFour[1] = Integer.toString(answer); //Actual answer
            questionFour[2] = Integer.toString(answer-1); //Wrong answer
            questionFour[3] = Integer.toString(answer+1); //Wrong answer
            questionFour[4] = Integer.toString(answer+2);  //Wrong answer
        }
        else if (firstNumInEquation < numberItEquals) { //The number we're subtracting from cannot be < the difference, so we must switch around the question
            questionFour[0] = "What is the missing number in " + numberItEquals + " - ____ = " + firstNumInEquation; //Because numberItEquals was greater than firstNumInEquation
            int answer = numberItEquals - firstNumInEquation; //Can get the answer by subtracting the smaller number from the larger number
            questionFour[1] = Integer.toString(answer); //Actual answer
            questionFour[2] = Integer.toString(answer-1); //Wrong answer
            questionFour[3] = Integer.toString(answer+1); //Wrong answer
            questionFour[4] = Integer.toString(answer+2);  //Wrong answer
        }
        else if (firstNumInEquation == numberItEquals){ //The two numbers cannot be the same
           generateQuestionFour(); //Recursion until they don't equal eachother
        }
        return questionFour;
    }

}