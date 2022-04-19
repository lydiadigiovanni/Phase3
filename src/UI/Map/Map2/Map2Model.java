package UI.Map.Map2;

import UI.TutoPracTest.TutoPracTestController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class Map2Model {

    private Boolean checkmarkIndex[] = new Boolean[]{false, false, false, false, false};
    
    public Map2Model() {

    }

    public void switchToTutoPracTest(ActionEvent event, Button button, String path) {
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
            controller.setMapName(this.getClass().getSimpleName().substring(0,4));
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public void setCheckmarkBoolean(int checkmarkindex) {
        checkmarkIndex[checkmarkindex] = true;
    }
    
    public Boolean[] getCheckmarkIndex() {
        return checkmarkIndex;
    }
}
