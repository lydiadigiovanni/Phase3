//Assessment class
public class Assessment {
    private String assesmentType;
    private int questionNumber;
    private Boolean completed;
    private int numberCorrect;
    private int numOfQuestions;
    private int currentQuestionNum;

  
    
    public Question getQuestion() {
        return null;
    }
    
    public String getAssesmentType() {
        return assesmentType;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
        
    }

    public int getCurrentQuestionNum() {
        return currentQuestionNum;

    }

    public Boolean getCompleted() {
        return completed;
    }   
}