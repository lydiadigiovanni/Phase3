//Purpose: First round of practice questions for Time & Money Shore (MONEY RELATED QUESTIONS)
package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FSPractice3 extends Assessment {

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
        FSPractice3 test1 = new FSPractice3();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]);
        System.out.println(question1[2]);
        System.out.println(question1[3]);
        System.out.println(question1[4]);
        // Test question two
        FSPractice3 test2 = new FSPractice3();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]);
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);
        // test question three
        FSPractice3 test3 = new FSPractice3();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);

    }

    // Question One: How many "pennys, nickels, dimes, quarters" make up a dollar?
    private String[] generateQuestionOne() {
        String[] nameOfCoin = { "pennies", "nickels", "dimes", "quarters" }; // Array of types of coins
        String randomCoin = nameOfCoin[ThreadLocalRandom.current().nextInt(4)]; // Randomly generate one of the coins
                                                                                // from the nameOfCoin array
        String[] questionOne = new String[6]; // Array will contain question and possible answers
        int answer; // Will be used to store the number of coins
        questionOne[0] = "How many " + randomCoin + " make up a dollar?"; // Actual question

        // Check which coin they got
        if (randomCoin == nameOfCoin[0]) { // If it is pennies
            answer = 100; // Takes 100 pennies to make a dollar
            questionOne[1] = Integer.toString(answer); // Actual answer
            questionOne[2] = Integer.toString(answer + 2); // First wrong answer
            questionOne[3] = Integer.toString(answer + 1); // Second wrong answer
            questionOne[4] = Integer.toString(answer - 1); // 3rd wrong answer
        }

        if (randomCoin == nameOfCoin[1]) { // If it is nickels
            answer = 20; // Takes 20 nickels to make a dollar
            questionOne[1] = Integer.toString(answer); // Actual answer
            questionOne[2] = Integer.toString(answer + 2); // First wrong answer
            questionOne[3] = Integer.toString(answer + 1); // Second wrong answer
            questionOne[4] = Integer.toString(answer - 1); // 3rd wrong answer
        }

        if (randomCoin == nameOfCoin[2]) { // If it is dimes
            answer = 10; // Takes 10 dimes to make a dollar
            questionOne[1] = Integer.toString(answer); // Actual answer
            questionOne[2] = Integer.toString(answer + 2); // First wrong answer
            questionOne[3] = Integer.toString(answer + 1); // Second wrong answer
            questionOne[4] = Integer.toString(answer - 1); // 3rd wrong answer
        }

        if (randomCoin == nameOfCoin[3]) { // If it is quarters
            answer = 4; // Takes 4 quarters to make a dollar
            questionOne[1] = Integer.toString(answer); // Actual answer
            questionOne[2] = Integer.toString(answer - 2); // First wrong answer
            questionOne[3] = Integer.toString(answer + 1); // Second wrong answer
            questionOne[4] = Integer.toString(answer - 1); // 3rd wrong answer
        }

        return questionOne;
    }

    // Question One: How many cents is a "penny, nickel, dime, quarter"?
    private String[] generateQuestionTwo() {
        String[] nameOfCoin = { "penny", "nickel", "dime", "quarter" }; // Array holds name of coins for the question;
        String randomCoin = nameOfCoin[ThreadLocalRandom.current().nextInt(4)]; // Randomly generate one of the coins
                                                                                // from the nameOfCoin array
        String[] questionTwo = new String[6]; // Array will contain question and possible answers
        int answer; // Will be used to store the number of coins
        questionTwo[0] = "How many cents is a " + randomCoin + "?";
        if (randomCoin == nameOfCoin[0]) { // If the coin at question is a penny
            answer = 1;
            questionTwo[1] = Integer.toString(answer); // The actual answer
            questionTwo[2] = Integer.toString(answer + 1); // Wrong answer 1
            questionTwo[3] = Integer.toString(answer + 2); // Wrong answer 2
            questionTwo[4] = Integer.toString(answer + 3); // Wrong answer 3
        }
        if (randomCoin == nameOfCoin[1]) { // If the coin at question is a nickel
            answer = 5;
            questionTwo[1] = Integer.toString(answer); // The actual answer
            questionTwo[2] = Integer.toString(answer - 1); // Wrong answer 1
            questionTwo[3] = Integer.toString(answer + 2); // Wrong answer 2
            questionTwo[4] = Integer.toString(answer + 1); // Wrong answer 3
        }
        if (randomCoin == nameOfCoin[2]) { // If the coin at question is a dime
            answer = 10;
            questionTwo[1] = Integer.toString(answer); // The actual answer
            questionTwo[2] = Integer.toString(answer - 1); // Wrong answer 1
            questionTwo[3] = Integer.toString(answer - 2); // Wrong answer 2
            questionTwo[4] = Integer.toString(answer + 1); // Wrong answer 3
        }
        if (randomCoin == nameOfCoin[3]) { // If the coin at question is a quarter
            answer = 25;
            questionTwo[1] = Integer.toString(answer); // The actual answer
            questionTwo[2] = Integer.toString(answer - 1); // Wrong answer 1
            questionTwo[3] = Integer.toString(answer - 3); // Wrong answer 2
            questionTwo[4] = Integer.toString(answer - 2); // Wrong answer 3
        }
        return questionTwo;

    }

    // Question Three:
    private String[] generateQuestionThree() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(5) + 6; // The number in the question is between 1 and 100
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
        questionThree[0] = "School starts at " + num + " o'clock in the morning and" +
                " ends after " + num2 + " hours. What time does school end?"; // Actual question

        if ((num + num2) > 12) {
            num = (num + num2) - 12;
        }
        if (num + num2 <= 12) {
            num = (num + num2);
        }
        questionThree[1] = num + ""; // Answer
        questionThree[2] = num2 + ""; // Wrong answer
        questionThree[3] = num3 + ""; // Wrong answer
        questionThree[4] = num4 + ""; // Wrong answer

        return questionThree;

    }
}