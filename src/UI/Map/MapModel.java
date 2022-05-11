package UI.Map;
import Backend.Database.Database;
import Backend.Grade.Grade;
import UI.TutoPracTest.TutoPracTestController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class MapModel {
    
    public MapModel() {

    }

    /**
     * Switches over to the tutorialpracticetest page
     * first four letters (tuto, prac, test) get established here, along with
     * the number of the button, (practice1, tutorial4, etc.) 
     */
    public void switchToTutoPracTest(ActionEvent event, Button button, String path, Grade grade, String mapName) {
        String firstFourLetters = button.getId().substring(0, 4);
        String lastLetter = button.getId().substring((button.getId().length()) - 1);        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            TutoPracTestController controller = loader.getController();
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(scene);
            window.show();
            controller.setFirstLetter(firstFourLetters);
            controller.setLastLetter(lastLetter);
            controller.setMapName(mapName);
            controller.setGrade(grade);
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Switches over to the home page
     * @param event
     */
    public void toHomePage(ActionEvent event) {
        try {
            Parent homepageParent = FXMLLoader.load(getClass().getResource("/UI/Homepage/HomePage.fxml"));
            Scene homeScene = new Scene(homepageParent);
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.setScene(homeScene);
            window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }

    /**
     * Setters and getters for assigning the map's boolen array for the checkmarks on the tutorial, practice tests. etc.
     * @param checkmarkindex
     * @param mapName
     */
    public void setCheckmarkBoolean(int checkmarkindex, String mapName) {
        Database.setCheckmarkBoolean(checkmarkindex, mapName);
    }
    
    public Boolean[] getCheckmarkIndex(String mapName) {
        return Database.getMapProgress(mapName);
    }
}
