package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Purpose: First round of practice questions for Algebra Atoll
public class TFPractice6 extends Assessment{

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

        //test question three
        TFPractice6 test3 = new TFPractice6();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);
    

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
         // Question Three:Solve x/### = ###
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
            questionThree[0] = "Solve x/"+num+ " = "+num2; // Actual question
            questionThree[1] = (num*num2)+""; // Answer
            questionThree[2] = (num*num)+""; // Wrong answer
            questionThree[3] = (num4*num2)+""; // Wrong answer
            questionThree[4] = (num*num3)+""; // Wrong answer
     
            return questionThree;
     
        }
    
}
