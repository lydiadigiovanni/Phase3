package UI.Map;

import Backend.Database.Database;
import Backend.Grade.Grade;

public abstract class MapControllerParent {
    public abstract void initialize();
    public abstract void setCheckmarkBoolean(int checkmarkindex);
    
    public Grade getGrade() {
        return Database.getCurrentUserGradeClass();
    }
}
