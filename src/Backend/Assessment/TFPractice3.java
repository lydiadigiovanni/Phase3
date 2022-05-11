//Purpose: First round of practice questions for Fraction Lagoon
package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Random;
public class TFPractice3 extends Assessment {
 
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
        int i = ThreadLocalRandom.current().nextInt(2);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[]{"0"};
                multipleChoice[1] = generateQuestionOne();
                break;
            case 1: 
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
        }
        return multipleChoice;
    }
 
    public static void main(String[] args) {
        TFPractice3 test1 = new TFPractice3();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]);
        System.out.println(question1[2]);
        System.out.println(question1[3]);
        System.out.println(question1[4]);
        // Test question two
        TFPractice3 test2 = new TFPractice3();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]);
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);
        //test question three
        TFPractice3 test3 = new TFPractice3();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);
 
    }
 
    // Question One: Find the missing denominator in " " = " " / __
    private String[] generateQuestionOne() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(50) + 1; // The number in the question is between 1 and 100
        int num2 = random.nextInt(50) + 1;
        int num3 = random.nextInt(50) + 1;
        int num4 = random.nextInt(50) + 1;
        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // inserting random int values in arrayList
 
        intArray.add(num);
        intArray.add(num2);
        intArray.add(num3);
        intArray.add(num4);
 
        String[] questionOne = new String[6]; // Array will hold question & possible answers
        questionOne[0] = "Find the missing denominator: \n" + num + "/" + num4 + " + " + num2 + "/" + num4 + " + "
        + num3 + "/" + "______ = " + (num + num2 + num3) + "/" + num4; // Actual question
        questionOne[1] = Integer.toString(num4); // Answer
        questionOne[2] = Integer.toString(num4 - 1); // Wrong answer
        questionOne[3] = Integer.toString(num4 + 2); // Wrong answer
        questionOne[4] = Integer.toString(num4 + 3); // Wrong answer
 
        return questionOne;
    }
 
    // Question Two: Which is an equivalent fraction to " "/ " "?
    //TODO: answer's were all whole numbers
    private String[] generateQuestionTwo() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(40) + 1; // The number in the question is between 1 and 100
        if (num % 2 != 0) {
            num = num + 1;
 
        }
        if (num == 0) {
            num = num + 2;
        }
        int num2 = random.nextInt(40) + 1;
        if (num2 % 2 != 0) {
            num2 = num2 + 1;
        }
        if (num2 == 0) {
            num2 = num2 + 2;
 
        }
        int num3 = random.nextInt(20) + 1;
        int num4 = random.nextInt(20) + 1;
        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // inserting random int values in arrayList
 
        intArray.add(num);
        intArray.add(num2);
        intArray.add(num3);
        intArray.add(num4);
 
        String[] questionTwo = new String[6]; // Array will hold question & possible answers
        questionTwo[0] = "Which is an equivalent fraction to " + num + "/" + num2 + " " + "?"; // Actual question
        // answer multiple by to , then this goes in to answer array
 
        questionTwo[1] = num / 2 + "/" + num2 / 2; // Answer
        questionTwo[2] = num3 + "/" + num4; // Wrong answer
        questionTwo[3] = num4 + "/" + num3; // Wrong answer
        questionTwo[4] = num2 + "/" + (num + 1); // Wrong answer
 
        return questionTwo;
 
    }

    
        // Question Three: fraction word problem, see question 3 string array?
        public String[] generateQuestionThree() {
            Random random = new Random(); // Will be used to generate the random numbers
            int ranNum = random.nextInt(100) + 1; // random number for first integer
            int ranNum2 = random.nextInt(100) + 1; //random number for second integer
            // while loop to check if int 1is less then num 2, or else give another random to int 1
            while (ranNum <= ranNum2){
                ranNum = random.nextInt(100) + 1;

            }
                       
            String[] questionThree = new String[6]; // Array will hold question & possible answers
            questionThree[0] =  "The library had "+ ranNum +" books and Gilly borrowed " + ranNum2 + ". "+
            "What fraction of the books did she borrow?";

            questionThree[1] = ranNum2+"/"+ranNum; // Actual answer
            questionThree[2] = (ranNum2+2)+"/"+(ranNum+6); // Wrong answer
            questionThree[3] = (ranNum+2)+"/"+(ranNum2+6); // Wrong answer
            questionThree[4] = (ranNum2+4)+"/"+(ranNum+4); // Wrong answer
    
            return questionThree;
    
        }
 
}

