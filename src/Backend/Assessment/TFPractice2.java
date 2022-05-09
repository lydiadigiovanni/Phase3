package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.w3c.dom.ranges.Range;

//Purpose: Second round of practice questions for Operation Cove (FACTORS, MULTIPLES, ETC.)
public class TFPractice2 extends Assessment {

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
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
        }
        return multipleChoice;
    }

    public static void main(String[] args) {
        // Test question one
        TFPractice2 test1 = new TFPractice2();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]);
        System.out.println(question1[2]);
        System.out.println(question1[3]);
        System.out.println(question1[4]);
        // Test question two
        TFPractice2 test2 = new TFPractice2();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]);
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);
        // Test question three
        TFPractice2 test3 = new TFPractice2();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);
    }

    // Question One: Which number is a factor of " "?
    public String[] generateQuestionOne() {
        Random random = new Random(); // Will be used to generate the random numbers
        int numInQuestion = random.nextInt(100) + 1; // The number in the question is between 1 and 100
        ArrayList<Integer> possibleFactors = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // Run loop from 1 to numInQuestion
        for (int i = 1; i <= numInQuestion; i++) {
            // If number is divided by i, then i is a factor
            if (numInQuestion % i == 0) {
                possibleFactors.add(i); // Add that number to the possibleFactors array

            }
        }
        // Generate a random factor from possibleFactors to use as an answer
        int answer = possibleFactors.get(random.nextInt(possibleFactors.size()));
        String[] questionOne = new String[6]; // Array will hold question & possible answers
        questionOne[0] = "Which number is a factor of " + numInQuestion + "?"; // Actual question
        questionOne[1] = Integer.toString(answer); // Answer
        questionOne[2] = Integer.toString(answer - 1); // Wrong answer
        questionOne[3] = Integer.toString(answer + 2); // Wrong answer
        questionOne[4] = Integer.toString(answer + 3); // Wrong answer

        return questionOne;

    }

    // Question Two: Which number is a multiple of " "?
    public String[] generateQuestionTwo() {
        Random random = new Random(); // Will be used to generate the random numbers
        int numInQuestion = random.nextInt(50) + 1; // Number in question is between 1 and 50
        // Array of possible multiples
        int[] answers = { (numInQuestion * 2), (numInQuestion * 3), (numInQuestion * 4) };
        // Assign a random multiple to answer
        int answer = answers[ThreadLocalRandom.current().nextInt(3)];
        String[] questionTwo = new String[6]; // Array will hold question & possible answers
        questionTwo[0] = "Which number is a multiple of " + numInQuestion + "?";
        questionTwo[1] = Integer.toString(answer); // Actual answer
        questionTwo[2] = Integer.toString(answer - 2); // Wrong answer
        questionTwo[3] = Integer.toString(answer - 3); // Wrong answer
        questionTwo[4] = Integer.toString(answer + 2); // Wrong answer

        return questionTwo;

    }

    // Question Three: "Round xxx to the 100th place?"
    public String[] generateQuestionThree() {
        Random random = new Random(); // Will be used to generate the random numbers
        int rng = random.nextInt(9); // random number 1 for hundreds place
        int rng2 = random.nextInt(9); // random number 2 for tens place
        int rng3 = random.nextInt(9); // random number 3 for ones place

        String[] questionThree = new String[6]; // Array will hold question & possible answers
        questionThree[0] = "Round " + rng + rng2 + rng3 + " to the 100th place";

        if (rng2 < 5) {

            rng2 = 0;
            rng3 = 0;

        }
        if (rng2 >= 5) {
            rng = rng + 1;
            rng2 = 0;
            rng3 = 0;

        }

        questionThree[1] = rng + "" + rng2 + "" + rng3; // Actual answer
        questionThree[2] = (rng + 1) + "" + (rng2 + 2) + "" + (rng3 + 3); // Wrong answer
        questionThree[3] = (rng + 2) + "" + (rng2 + 3) + "" + (rng3 + 1);
        ; // Wrong answer
        questionThree[4] = (rng + 3) + "" + (rng2 + 1) + "" + (rng3 + 2);
        ;// wrong answer

        return questionThree;

    }

}
