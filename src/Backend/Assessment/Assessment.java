package Backend.Assessment;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Assessment {
        /**
     * Generates a question of either type multiple choice, true/false, or user input.
     * 0 = multiple choice
     * 1 = true/false
     * 2 = user input
     */
    
    public String[][][] generateQuestion() { 
        int i = ThreadLocalRandom.current().nextInt(3);
        String[][][] typeAndQuestion = new String[2][1][1];
        switch (0) {
            case 0:
                typeAndQuestion[0][0] = new String[]{"0"};
                typeAndQuestion[1] = generateMultipleChoiceQuestion();

                break;
            case 1:
                typeAndQuestion[0][0] = new String[]{"1"};
                typeAndQuestion[1] = generateTrueFalseQuestion();

                break;
            case 2:
                typeAndQuestion[0][0] = new String[]{"2"};
                typeAndQuestion[1] = generateUserInputQuestion();

                break;
        }
        return typeAndQuestion;
    }

    public abstract String[][] generateMultipleChoiceQuestion();

    public abstract String[][] generateTrueFalseQuestion();

    public abstract String[][] generateUserInputQuestion();

}
