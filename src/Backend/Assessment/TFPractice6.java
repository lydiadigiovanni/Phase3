package Backend.Assessment;
import java.util.Random;

//Purpose: First round of practice questions for Algebra Atoll
public class TFPractice6 extends Assessment{

    @Override
    public String[][] generateMultipleChoiceQuestion() {
        // TODO Auto-generated method stub
        return null;
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
        TFPractice6 test1 = new TFPractice6();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]); 
        System.out.println(question1[2]); 
        System.out.println(question1[3]); 
        System.out.println(question1[4]);
        //Test question two
        TFPractice6 test2 = new TFPractice6();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]); 
        System.out.println(question2[2]); 
        System.out.println(question2[3]); 
        System.out.println(question2[4]);
    

    }

//Question One = Find the value of x if " "x + " " = " "
private String[] generateQuestionOne() {
    Random random = new Random(); //Will be used to generate random numbers
    int numBeforeX = random.nextInt(30) + 1; //The number before the x, as in 3x for example
    int numAfterPlus = random.nextInt(30) + 1; //Number after plus, like + 7 for example
    int temp = random.nextInt(30) + 1; //Temporary random integer
    int numItEquals = temp * numAfterPlus; //Use temp to ensure the number after = is > the other umbers
    //Subtract numAfterPlus from numItEquals and divide that by numBeforeX
    int answer = ((numItEquals - numAfterPlus) / numBeforeX);
    String[] questionOne = new String[6]; //Array will hold question and answers
    questionOne[0] = "Find the value of x if " + numBeforeX + "x + " + numAfterPlus + " = " + numItEquals;
    questionOne[1] = "x = " + Integer.toString(answer); //Correct answer
    questionOne[2] = "x = " + Integer.toString(answer + 2); //Wrong answer
    questionOne[3] = "x = " + Integer.toString(answer - 2); //Wrong answer
    questionOne[4] = "x = " + Integer.toString(answer - 1); //Wrong answer

    return questionOne;
}

   //Question Two = Find the value of y if " " = " " / y
    private String[] generateQuestionTwo() {
        Random random = new Random(); //Will be used to generate random numbers
        int temp = random.nextInt(100) + 1; //Temporary number will ensure correct question format
        int firstNum = random.nextInt(100) + 1; //Second number is between 1 and 100
        int secondNum = firstNum * temp; //To ensure that the second number can be divided by y to get the first
        String[] questionTwo = new String[6]; //String will hold question and possible answers
        int answer = secondNum / firstNum; //Answer is x = secondNum / firstNum
        questionTwo[0] = "Find the value of y if " + firstNum + " = " + secondNum + " / y"; //Actual question
        questionTwo[1] = Integer.toString(answer); //Correct answer
        questionTwo[2] = Integer.toString(answer + 1); //Wrong answer
        questionTwo[3] = Integer.toString(answer - 1); //Wrong answer
        questionTwo[4] = Integer.toString(answer - 2); //Wrong answer

        return questionTwo;
    }
    
}
