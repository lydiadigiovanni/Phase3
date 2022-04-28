//Purpose: Controller in the MVC structure for the homepage
package UI.Homepage;
import Backend.Grade.Grade;
import Backend.Grade.GradeKi; //TODO: REMOVE THISLATER
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomePageController {

    @FXML
    private Button Island1Button;

    @FXML
    private Button Island2Button;

    @FXML
    private Button Island3Button;

    @FXML
    private Button LogOutButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private Label island1Name;

    @FXML
    private Label island2Name;

    @FXML
    private Label island3Name;

    private HomePageModel model = new HomePageModel();

    private Grade grade;

    public HomePageController() {
        super();
        grade = new GradeKi(); //TODO: GET THIS FROM DATBASE
    }
    @FXML
    void Island2ButtonPressed(ActionEvent event) {
        model.goToIsland(event, Island2Button, "/UI/Map/Map2/Map2View.fxml", grade);
    }

    @FXML
    void island1ButtonPressed(ActionEvent event){
        /*Call goToIsland() from HomePageModel;
        When Island1Button is pressed, the software takes you back to the map!*/
        model.goToIsland(event, Island1Button, "/UI/Map/Map1/MapView.fxml", grade);
    }

    @FXML
    void island3ButtonPressed(ActionEvent event) {
        model.goToIsland(event, Island2Button, "/UI/Map/Map3/Map3View.fxml", grade);
    }

    @FXML
    void logOutButtonPressed(ActionEvent event) {

    }

    @FXML
    void profileButtonPressed(ActionEvent event) {
        model.goToProfile(event, ProfileButton);
    }

    @FXML
    public void initialize() {        
        island1Name.setText(grade.getIsland1Name());
        island2Name.setText(grade.getIsland2Name());
        island3Name.setText(grade.getIsland3Name());
    }

}
