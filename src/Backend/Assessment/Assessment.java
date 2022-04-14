package Backend.Assessment;

public abstract class Assessment {
    
    public abstract String[][][] generateQuestion();

    public abstract String[][] generateMultipleChoiceQuestion();

    public abstract String[][] generateTrueFalseQuestion();

    public abstract String[][] generateUserInputQuestion();

}
