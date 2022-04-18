package Backend.Assessment;

import java.util.concurrent.ThreadLocalRandom;

import TrueFalse.GenerateQuestions;

public class KiPractice2 extends Assessment{

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
            case 2:
                multipleChoice[0] = new String[]{"2"};
                multipleChoice[1] = generateQuestionThree();
                break;
            case 3:
                multipleChoice[0] = new String[]{"3"};
                multipleChoice[1] = generateQuestionFour();
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
    

    private String[] generateQuestionOne() {
        int randomNumber;
        int rng = ThreadLocalRandom.current().nextInt(50-1)/2 * 2;
        int[] list = new int[4];
        list[0] = rng;
        list[1] = rng + 2;
        list[2] = rng + 4;
        randomNumber = rng + 6;
        String[] question = new String[6];
        question[0] = "What comes after numbers " + list[0] + ", " + list[1] + ", " + list[2];
        question[1] = Integer.toString(randomNumber);
        question[2] = Integer.toString(randomNumber-1);
        question[3] = Integer.toString(randomNumber+1);
        question[4] = Integer.toString(randomNumber+3);
        return question;
    }

    private String[] generateQuestionTwo() {
        int randomNumber = ThreadLocalRandom.current().nextInt(50-1)/2 * 2;
        String[] question = new String[6];
        question[0] = "What comes after numbers " + randomNumber + ", " + (randomNumber + 3) + ", " + (randomNumber + 6);
        question[1] = Integer.toString(randomNumber + 9);
        question[2] = Integer.toString(randomNumber-1);
        question[3] = Integer.toString(randomNumber+1);
        question[4] = Integer.toString(randomNumber+3);
        return question;
    }

    private String[] generateQuestionThree() {
        int randomNumber = ThreadLocalRandom.current().nextInt(50-1)/2 * 2;
        String[] question = new String[6];
        question[0] = "What is the missing number " + randomNumber + ", " + "____" + ", " + (randomNumber + 6) + ", " + (randomNumber + 9);
        question[1] = Integer.toString(randomNumber + 3);
        question[2] = Integer.toString(randomNumber-1);
        question[3] = Integer.toString(randomNumber+1);
        question[4] = Integer.toString(randomNumber+3);
        return question;
    }

    private String[] generateQuestionFour() {
        int randomNumber = ThreadLocalRandom.current().nextInt(50-1)/2 * 2;
        String[] question = new String[6];
        question[0] = "What is the missing number " + randomNumber + ", " + (randomNumber + 2) + ", " + "____" + ", " + (randomNumber + 6);
        question[1] = Integer.toString(randomNumber + 4);
        question[2] = Integer.toString(randomNumber-1);
        question[3] = Integer.toString(randomNumber+1);
        question[4] = Integer.toString(randomNumber+3);
        return question;
    }
}
