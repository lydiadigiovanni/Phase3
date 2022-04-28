package UI.Map;

import Backend.Grade.Grade;

public abstract class MapControllerParent {
    
    private Grade grade;

    public abstract void initialize();
    public abstract void setCheckmarkBoolean(int checkmarkindex);
    
    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
