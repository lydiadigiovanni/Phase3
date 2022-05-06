//Purpose: First round of practice questions for Fraction Lagoon
package Backend.Assessment;
import java.util.ArrayList;
import java.util.Random;
public class TFPractice3 extends Assessment {
 
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
        questionOne[0] = "Find the missing denominator in " + num + "/" + num4 + " + " + num2 + "/" + num4 + " + "
        + num3 + "/" + "______" + "?"; // Actual question
        questionOne[1] = Integer.toString(num4); // Answer
        questionOne[2] = Integer.toString(num4 - 1); // Wrong answer
        questionOne[3] = Integer.toString(num4 + 2); // Wrong answer
        questionOne[4] = Integer.toString(num4 + 3); // Wrong answer
 
        return questionOne;
    }
 
    // Question Two: Which is an equivalent fraction to " "/ " "?
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
        questionTwo[4] = num2 + "/" + num; // Wrong answer
 
        return questionTwo;
 
    }
 
}

