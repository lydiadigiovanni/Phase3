//USER SHOULD GO FIRST BECAUSE IT SETS THE GRADE LEVEL WE NEED
import javafx.scene.image.Image;

public class User {
    private String username;
    private String password;
    private String securityQuestionAnswerOne;
    private String securityQuestionAnswerTwo;
    private Image profilePicture;
    private Grade gradeLevel;
    private Image rewards[];

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecurityQuestionAnswerOne() {
        return securityQuestionAnswerOne;
    }

    public String getSecurityQuestionAnswerTwo() {
        return securityQuestionAnswerTwo;
    }

    public Image getProfilePic() {
        return profilePicture;

    }

    public void setGradeLevel() {

    }

   public Grade getGradeLevel() {
    return gradeLevel;

   }
     
}
