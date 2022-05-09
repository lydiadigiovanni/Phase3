package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//Purpose: Second round of practice questions for Fraction Lagoon
public class TFPractice4 extends Assessment {
 
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
                multipleChoice[0] = new String[]{"1"};
                multipleChoice[1] = generateQuestionTwo();
                break;
            case 1: 
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
        }
        return multipleChoice;
    }
 
    public static void main(String[] args) {
        TFPractice4 test1 = new TFPractice4();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]);
        System.out.println(question1[2]);
        System.out.println(question1[3]);
        System.out.println(question1[4]);
        // Test question two
        TFPractice4 test2 = new TFPractice4();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]);
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);

        //test question three
        TFPractice4 test3 = new TFPractice4();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);
 
    }
 
    // Question One: What is " " as a fraction?
    private String[] generateQuestionOne() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(50) + 1; // The number in the question is between 1 and 100
        int num2 = random.nextInt(1) + 1;
        int num3 = random.nextInt(50) + 1;
        int num4 = random.nextInt(50) + 1;
        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // inserting random int values in arrayList
 
        intArray.add(num);
        intArray.add(num2);
        intArray.add(num3);
        intArray.add(num4);
 
        String[] questionOne = new String[6]; // Array will hold question & possible answers
        questionOne[0] = "What is " + num + " as a fraction?"; // Actual question
        questionOne[1] = num + "/" + num2; // Answer
        questionOne[2] = num2 + "/" + num3; // Wrong answer
        questionOne[3] = num4 + "/" + num; // Wrong answer
        questionOne[4] = num3 + "/" + num; // Wrong answer
 
        return questionOne;
 
    }
 
    // Question Two: What is " "/ " " as a whole number?
    private String[] generateQuestionTwo() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(50) + 1; // The number in the question is between 1 and 100
        int num2 = random.nextInt(1) + 1;
        int num3 = random.nextInt(50) + 1;
        int num4 = random.nextInt(50) + 1;
        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // inserting random int values in arrayList
 
        intArray.add(num);
        intArray.add(num2);
        intArray.add(num3);
        intArray.add(num4);
 
        String[] questionTwo = new String[6]; // Array will hold question & possible answers
        questionTwo[0] = "What is " + num + "/" + num2 + " as a whole number" + "?"; // Actual question
        questionTwo[1] = Integer.toString(num); // Answer
        questionTwo[2] = Integer.toString(num4 - 1); // Wrong answer
        questionTwo[3] = Integer.toString(num4 + 2); // Wrong answer
        questionTwo[4] = Integer.toString(num4 + 3); // Wrong answer
 
        return questionTwo;
 
    }
        // Question Three:
        private String[] generateQuestionThree() {
            Random random = new Random(); // Will be used to generate the random numbers
            int num = random.nextInt(12) + 1; // The number in the question is between 1 and 100
            int num2 = random.nextInt(12) + 1;
            int num3 = random.nextInt(12) + 1;
            int num4 = random.nextInt(12) + 1;

            while (num<=num3){
                num = random.nextInt(12) + 1;
                if (num>num2){
                    num = random.nextInt(12) + 1;
                }
                if(num3>num2){
                    num3 = random.nextInt(12) + 1;
                }
            }
            ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
            // inserting random int values in arrayList
            intArray.add(num);
            intArray.add(num2);
            intArray.add(num3);
            intArray.add(num4);
     
            String[] questionThree = new String[6]; // Array will hold question & possible answers
            questionThree[0] = "Find the difference. " + num + "/" + num2 + " - " + num3 + "/" + num2 + "?"; // Actual question
            questionThree[1] = (num-num3+"/"+num2); // Answer
            questionThree[2] = (num+1)+"/"+(num2+2); // Wrong answer
            questionThree[3] = (num+2)+"/"+(num4+2); // Wrong answer
            questionThree[4] = (num4-1)+"/"+(num-2); // Wrong answer
     
            return questionThree;
     
        }
 
}

