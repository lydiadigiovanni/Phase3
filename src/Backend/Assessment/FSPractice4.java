//Purpose: Second round of practice questions for Time & Money Shore (TIME RELATED QUESTIONS)
package Backend.Assessment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FSPractice4 extends Assessment {

    @Override
    public String[][] generateMultipleChoiceQuestion() {
        String[][] multipleChoice = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(1);
        switch (i) {
            case 0:
                multipleChoice[0] = new String[] { "0" };
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
    public String[][] generateUserInputQuestion() {// question 1 and 2 has images to be uploaded
        String[][] userInput = new String[2][1];
        int i = ThreadLocalRandom.current().nextInt(3);
        switch (i) {
            case 0:
                userInput[0] = new String[] { "0" };
                userInput[1] = generateQuestionOne();
                break;
            case 1:
                userInput[0] = new String[] { "1" };
                userInput[1] = generateQuestionTwo();
                break;
            case 2:
                userInput[0] = new String[] { "2" };
                userInput[1] = generateQuestionThree();
                break;
        }
        return userInput;
    }

    public static void main(String[] args) {
        // Test question one
        FSPractice4 test1 = new FSPractice4();
        String[] question1 = test1.generateQuestionOne();
        System.out.println(question1[0]);
        System.out.println(question1[1]);
        System.out.println(question1[2]);
        System.out.println(question1[3]);
        System.out.println(question1[4]);
        // Test question two
        FSPractice4 test2 = new FSPractice4();
        String[] question2 = test2.generateQuestionTwo();
        System.out.println(question2[0]);
        System.out.println(question2[1]);
        System.out.println(question2[2]);
        System.out.println(question2[3]);
        System.out.println(question2[4]);
        // test question three
        FSPractice4 test3 = new FSPractice4();
        String[] question3 = test3.generateQuestionThree();
        System.out.println(question3[0]);
        System.out.println(question3[1]);
        System.out.println(question3[2]);
        System.out.println(question3[3]);
        System.out.println(question3[4]);
    }

    // What time does the clock show? Picture of random clock next to question
    private String[] generateQuestionOne() {
        // String array holds the names of pics to be used in the questions
        String[] clocks = { "One", "Two", "Two Ten", "Two Thirty", "Three Fifty", "Four Thirty Five", "Five Twenty",
                "Six", "Seven", "Seven Thirty", "Eight", "Eight Thirty", "Nine Thirty", "Ten Thirty", "Ten Fifty Five",
                "Eleven", "Eleven Thirty", "Twelve Fifteen" };
        // String array holds the times to be used in the answers
        String[] timeInNumbers = { "1:00", "2:00", "2:10", "2:30", "3:50", "4:35", "5:20", "6:00",
                "7:00", "7:30", "8:00", "8:30", "9:30", "10:30", "10:55", "11:00", "11:30", "12:15" };
        // randomtime contains a random time from the timeInNumbers array to use in the
        // question
        String randomClock = clocks[ThreadLocalRandom.current().nextInt(18)];
        String[] questionOne = new String[6]; // Array will contain questions and possible answers
        /*
         * Add times to an array list so we can remove the correct answer later
         * So we can place incorrect answers in the questionTwo array
         */
        ArrayList<String> times = new ArrayList<String>();
        // Add all the contents of clock array to clockNames array list
        times.add(0, timeInNumbers[0]);
        times.add(1, timeInNumbers[1]);
        times.add(2, timeInNumbers[2]);
        times.add(3, timeInNumbers[3]);
        times.add(4, timeInNumbers[4]);
        times.add(5, timeInNumbers[5]);
        times.add(6, timeInNumbers[6]);
        times.add(7, timeInNumbers[7]);
        times.add(8, timeInNumbers[8]);
        times.add(9, timeInNumbers[9]);
        times.add(10, timeInNumbers[10]);
        times.add(11, timeInNumbers[11]);
        times.add(12, timeInNumbers[12]);
        times.add(13, timeInNumbers[13]);
        times.add(14, timeInNumbers[14]);
        times.add(15, timeInNumbers[15]);
        times.add(16, timeInNumbers[16]);
        times.add(17, timeInNumbers[17]);
        questionOne[0] = "What time does the clock show " + randomClock;
        String answer; // Will contain the answer
        if (randomClock == clocks[0]) { // If the time is 1:00
            answer = times.get(0); // The answer is One
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(1); // Wrong answer 1
            questionOne[3] = times.get(2); // Wrong answer 2
            questionOne[4] = times.get(3); // Wrong answer 3
            questionOne[5] = "1.00";
        }
        if (randomClock == clocks[1]) { // If the time is 2:00
            answer = times.get(1); // The answer is Two
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(4); // Wrong answer 1
            questionOne[3] = times.get(5); // Wrong answer 2
            questionOne[4] = times.get(6); // Wrong answer 3
            questionOne[5] = "2.00";
            

        }
        if (randomClock == clocks[2]) { // If the time is 2:10
            answer = times.get(2); // The answer is Two Ten
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(7); // Wrong answer 1
            questionOne[3] = times.get(8); // Wrong answer 2
            questionOne[4] = times.get(9); // Wrong answer 3
            questionOne[5] = "2.10";

        }
        if (randomClock == clocks[3]) { // If the time is 2:30
            answer = times.get(3); // The answer is Two Thirty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(10); // Wrong answer 1
            questionOne[3] = times.get(11); // Wrong answer 2
            questionOne[4] = times.get(12); // Wrong answer 3
            questionOne[5] = "2.30";

        }
        if (randomClock == clocks[4]) { // If the time is 3:50
            answer = times.get(4); // The answer is Three Fifty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(13); // Wrong answer 1
            questionOne[3] = times.get(14); // Wrong answer 2
            questionOne[4] = times.get(15); // Wrong answer 3
            questionOne[5] = "3.50";

        }
        if (randomClock == clocks[5]) { // If the time is 4:35
            answer = times.get(5); // The answer is Four Thirty Five
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(16); // Wrong answer 1
            questionOne[3] = times.get(17); // Wrong answer 2
            questionOne[4] = times.get(0); // Wrong answer 3
            questionOne[5] = "4.35";

        }
        if (randomClock == clocks[6]) { // If the time is 5:20
            answer = times.get(6); // The answer is Five Twenty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(1); // Wrong answer 1
            questionOne[3] = times.get(4); // Wrong answer 2
            questionOne[4] = times.get(8); // Wrong answer 3
            questionOne[5] = "5.20";

        }
        if (randomClock == clocks[7]) { // If the time is 6:00
            answer = times.get(7); // The answer is Six
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(2); // Wrong answer 1
            questionOne[3] = times.get(4); // Wrong answer 2
            questionOne[4] = times.get(6); // Wrong answer 3
            questionOne[5] = "6.00";

        }
        if (randomClock == clocks[8]) { // If the time is 7:00
            answer = times.get(8); // The answer is Seven
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(9); // Wrong answer 1
            questionOne[3] = times.get(11); // Wrong answer 2
            questionOne[4] = times.get(13); // Wrong answer 3
            questionOne[5] = "7.00";

        }
        if (randomClock == clocks[9]) { // If the time is 7:30
            answer = times.get(9); // The answer is Seven Thirty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(15); // Wrong answer 1
            questionOne[3] = times.get(17); // Wrong answer 2
            questionOne[4] = times.get(3); // Wrong answer 3
            questionOne[5] = "7.30";

        }
        if (randomClock == clocks[10]) { // If the time is 8:00
            answer = times.get(10); // The answer is Eight
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(4); // Wrong answer 1
            questionOne[3] = times.get(6); // Wrong answer 2
            questionOne[4] = times.get(8); // Wrong answer 3
            questionOne[5] = "8.00";

        }
        if (randomClock == clocks[11]) { // If the time is 8:30
            answer = times.get(11); // The answer is Eight Thirty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(3); // Wrong answer 1
            questionOne[3] = times.get(9); // Wrong answer 2
            questionOne[4] = times.get(10); // Wrong answer 3
            questionOne[5] = "8.30";

        }
        if (randomClock == clocks[12]) { // If the time is 9:30
            answer = times.get(12); // The answer is Nine Thirty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(16); // Wrong answer 1
            questionOne[3] = times.get(11); // Wrong answer 2
            questionOne[4] = times.get(0); // Wrong answer 3
            questionOne[5] = "9.30";

        }
        if (randomClock == clocks[13]) { // If the time is 10:30
            answer = times.get(13); // The answer is Ten Thirty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(5); // Wrong answer 1
            questionOne[3] = times.get(15); // Wrong answer 2
            questionOne[4] = times.get(14); // Wrong answer 3
            questionOne[5] = "10.30";

        }
        if (randomClock == clocks[14]) { // If the time is 10:55
            answer = times.get(14); // The answer is Ten Fifty Five
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(0); // Wrong answer 1
            questionOne[3] = times.get(12); // Wrong answer 2
            questionOne[4] = times.get(14); // Wrong answer 3
            questionOne[5] = "10.55";
        }
        if (randomClock == clocks[15]) { // If the time is 11:00
            answer = times.get(15); // The answer is Eleven
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(13); // Wrong answer 1
            questionOne[3] = times.get(3); // Wrong answer 2
            questionOne[4] = times.get(16); // Wrong answer 3
            questionOne[5] = "11.00";

        }
        if (randomClock == clocks[16]) { // If the time is 11:30
            answer = times.get(16); // The answer is Eleven Thirty
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(3); // Wrong answer 1
            questionOne[3] = times.get(9); // Wrong answer 2
            questionOne[4] = times.get(15); // Wrong answer 3
            questionOne[5] = "11.30";

        }
        if (randomClock == timeInNumbers[17]) { // If the time is 12:15
            answer = times.get(17); // The answer is Twelve 15
            questionOne[1] = answer; // The actual answer
            questionOne[2] = times.get(5); // Wrong answer 1
            questionOne[3] = times.get(10); // Wrong answer 2
            questionOne[4] = times.get(16); // Wrong answer 3
            questionOne[5] = "12.15";

        }

        return questionOne;

    }

    // Which clock shows "random time"? //Pics of random clocks in the question
    private String[] generateQuestionTwo() {
        // String array holds the times to be used in the question
        String[] timeInNumbers = { "1:00", "2:00", "2:10", "2:30", "3:50", "4:35", "5:20", "6:00",
                "7:00", "7:30", "8:00", "8:30", "9:30", "10:30", "10:55", "11:00", "11:30", "12:15" };
        // String array holds the names of pics to be used in the answers
        String[] clocks = { "One", "Two", "Two Ten", "Two Thirty", "Three Fifty", "Four Thirty Five", "Five Twenty",
                "Six", "Seven", "Seven Thirty", "Eight", "Eight Thirty", "Nine Thirty", "Ten Thirty", "Ten Fifty Five",
                "Eleven", "Eleven Thirty", "Twelve Fifteen" };
        /*
         * Add clocks to an array list so we can remove the correct answer later
         * So we can place incorrect answers in the questionTwo array
         */
        ArrayList<String> clockNames = new ArrayList<String>();
        // Add all the contents of clock array to clockNames array list
        clockNames.add(0, clocks[0]);
        clockNames.add(1, clocks[1]);
        clockNames.add(2, clocks[2]);
        clockNames.add(3, clocks[3]);
        clockNames.add(4, clocks[4]);
        clockNames.add(5, clocks[5]);
        clockNames.add(6, clocks[6]);
        clockNames.add(7, clocks[7]);
        clockNames.add(8, clocks[8]);
        clockNames.add(9, clocks[9]);
        clockNames.add(10, clocks[10]);
        clockNames.add(11, clocks[11]);
        clockNames.add(12, clocks[12]);
        clockNames.add(13, clocks[13]);
        clockNames.add(14, clocks[14]);
        clockNames.add(15, clocks[15]);
        clockNames.add(16, clocks[16]);
        clockNames.add(17, clocks[17]);
        // randomtime contains a random time from the timeInNumbers array
        String randomTime = timeInNumbers[ThreadLocalRandom.current().nextInt(17)];
        String answer; // Will be used to hold the correct answer
        String[] questionTwo = new String[6]; // Array will hold question and possible answers
        questionTwo[0] = "Which clock shows " + randomTime + "?";
        if (randomTime == timeInNumbers[0]) { // If the time is 1:00
            answer = clockNames.get(0); // The answer is One
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(1); // Wrong answer 1
            questionTwo[3] = clockNames.get(2); // Wrong answer 2
            questionTwo[4] = clockNames.get(3); // Wrong answer 3
            questionTwo[5] = "1.00";

        }
        if (randomTime == timeInNumbers[1]) { // If the time is 2:00
            answer = clockNames.get(1); // The answer is Two
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(4); // Wrong answer 1
            questionTwo[3] = clockNames.get(5); // Wrong answer 2
            questionTwo[4] = clockNames.get(6); // Wrong answer 3
            questionTwo[5] = "2.00";

        }
        if (randomTime == timeInNumbers[2]) { // If the time is 2:10
            answer = clockNames.get(2); // The answer is Two Ten
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(7); // Wrong answer 1
            questionTwo[3] = clockNames.get(8); // Wrong answer 2
            questionTwo[4] = clockNames.get(9); // Wrong answer 3
            questionTwo[5] = "2.10";

        }
        if (randomTime == timeInNumbers[3]) { // If the time is 2:30
            answer = clockNames.get(3); // The answer is Two Thirty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(10); // Wrong answer 1
            questionTwo[3] = clockNames.get(11); // Wrong answer 2
            questionTwo[4] = clockNames.get(12); // Wrong answer 3
            questionTwo[5] = "2.30";

        }
        if (randomTime == timeInNumbers[4]) { // If the time is 3:50
            answer = clockNames.get(4); // The answer is Three Fifty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(13); // Wrong answer 1
            questionTwo[3] = clockNames.get(14); // Wrong answer 2
            questionTwo[4] = clockNames.get(15); // Wrong answer 3
            questionTwo[5] = "3.50";

        }
        if (randomTime == timeInNumbers[5]) { // If the time is 4:35
            answer = clockNames.get(5); // The answer is Four Thirty Five
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(16); // Wrong answer 1
            questionTwo[3] = clockNames.get(17); // Wrong answer 2
            questionTwo[4] = clockNames.get(0); // Wrong answer 3
            questionTwo[5] = "4.35";

        }
        if (randomTime == timeInNumbers[6]) { // If the time is 5:20
            answer = clockNames.get(6); // The answer is Five Twenty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(1); // Wrong answer 1
            questionTwo[3] = clockNames.get(4); // Wrong answer 2
            questionTwo[4] = clockNames.get(8); // Wrong answer 3
            questionTwo[5] = "5.20";

        }
        if (randomTime == timeInNumbers[7]) { // If the time is 6:00
            answer = clockNames.get(7); // The answer is Six
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(2); // Wrong answer 1
            questionTwo[3] = clockNames.get(4); // Wrong answer 2
            questionTwo[4] = clockNames.get(6); // Wrong answer 3
            questionTwo[5] = "6.00";

        }
        if (randomTime == timeInNumbers[8]) { // If the time is 7:00
            answer = clockNames.get(8); // The answer is Seven
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(9); // Wrong answer 1
            questionTwo[3] = clockNames.get(11); // Wrong answer 2
            questionTwo[4] = clockNames.get(13); // Wrong answer 3
            questionTwo[5] = "7.00";

        }
        if (randomTime == timeInNumbers[9]) { // If the time is 7:30
            answer = clockNames.get(9); // The answer is Seven Thirty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(15); // Wrong answer 1
            questionTwo[3] = clockNames.get(17); // Wrong answer 2
            questionTwo[4] = clockNames.get(3); // Wrong answer 3
            questionTwo[5] = "7.30";

        }
        if (randomTime == timeInNumbers[10]) { // If the time is 8:00
            answer = clockNames.get(10); // The answer is Eight
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(4); // Wrong answer 1
            questionTwo[3] = clockNames.get(6); // Wrong answer 2
            questionTwo[4] = clockNames.get(8); // Wrong answer 3
            questionTwo[5] = "8.00";

        }
        if (randomTime == timeInNumbers[11]) { // If the time is 8:30
            answer = clockNames.get(11); // The answer is Eight Thirty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(3); // Wrong answer 1
            questionTwo[3] = clockNames.get(9); // Wrong answer 2
            questionTwo[4] = clockNames.get(10); // Wrong answer 3
            questionTwo[5] = "8.30";

        }
        if (randomTime == timeInNumbers[12]) { // If the time is 9:30
            answer = clockNames.get(12); // The answer is Nine Thirty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(16); // Wrong answer 1
            questionTwo[3] = clockNames.get(11); // Wrong answer 2
            questionTwo[4] = clockNames.get(0); // Wrong answer 3
            questionTwo[5] = "9.30";

        }
        if (randomTime == timeInNumbers[13]) { // If the time is 10:30
            answer = clockNames.get(13); // The answer is Ten Thirty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(5); // Wrong answer 1
            questionTwo[3] = clockNames.get(15); // Wrong answer 2
            questionTwo[4] = clockNames.get(14); // Wrong answer 3
            questionTwo[5] = "10.30";

        }
        if (randomTime == timeInNumbers[14]) { // If the time is 10:55
            answer = clockNames.get(14); // The answer is Ten Fifty Five
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(0); // Wrong answer 1
            questionTwo[3] = clockNames.get(12); // Wrong answer 2
            questionTwo[4] = clockNames.get(14); // Wrong answer 3
        }
        if (randomTime == timeInNumbers[15]) { // If the time is 11:00
            answer = clockNames.get(15); // The answer is Eleven
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(13); // Wrong answer 1
            questionTwo[3] = clockNames.get(3); // Wrong answer 2
            questionTwo[4] = clockNames.get(16); // Wrong answer 3
            questionTwo[5] = "11.00";

        }
        if (randomTime == timeInNumbers[16]) { // If the time is 11:30
            answer = clockNames.get(16); // The answer is Eleven Thirty
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(3); // Wrong answer 1
            questionTwo[3] = clockNames.get(9); // Wrong answer 2
            questionTwo[4] = clockNames.get(15); // Wrong answer 3
            questionTwo[5] = "11.30";

        }
        if (randomTime == timeInNumbers[17]) { // If the time is 12:15
            answer = clockNames.get(17); // The answer is Twelve 15
            questionTwo[1] = answer; // The actual answer
            questionTwo[2] = clockNames.get(5); // Wrong answer 1
            questionTwo[3] = clockNames.get(10); // Wrong answer 2
            questionTwo[4] = clockNames.get(16); // Wrong answer 3
            questionTwo[5] = "12.15";

        }

        return questionTwo;
    }

    // Question Three:
    private String[] generateQuestionThree() {
        Random random = new Random(); // Will be used to generate the random numbers
        int num = random.nextInt(6) + 1; // The number in the question is between 1 and 100
        int num2 = random.nextInt(5) + 1;
        int num3 = random.nextInt(12) + 1;
        int num4 = random.nextInt(12) + 1;

        ArrayList<Integer> intArray = new ArrayList<>(); // ArrayList will holds possible answers / factors
        // inserting random int values in arrayList
        intArray.add(num);
        intArray.add(num2);
        intArray.add(num3);
        intArray.add(num4);

        String[] questionThree = new String[6]; // Array will hold question & possible answers
        questionThree[0] = "All students left school at " + num + ":00. Billy stayed for " + num2 + " more hours. When did he leave?";
        // Actual question

        questionThree[1] = (num + num2) + ""; // Answer
        questionThree[2] = num2 + ""; // Wrong answer
        questionThree[3] = num3 + ""; // Wrong answer
        questionThree[4] = num4 + ""; // Wrong answer

        return questionThree;

    }
}
