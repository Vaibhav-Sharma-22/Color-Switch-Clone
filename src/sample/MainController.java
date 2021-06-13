package sample;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Main implements Initializable {

    @FXML
    Arc a1,a2,a3,a4;

    @FXML
    private ImageView NewGame;

    @FXML
    private Button exitGame;

    @FXML
    private AnchorPane main;

    @FXML
    private Button loadGame;

    public MainController() throws FileNotFoundException {
    }


    @FXML
    public void exitGame(MouseEvent mouseEvent) {
        try{
            Main.serialize();
        }
        catch(IOException e){

        }
        System.exit(0);
    }

    @FXML
    public void ShowSavedGames(MouseEvent mouseEvent) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        main.getChildren().setAll(pane);
    }

    @FXML
    public void NewGame(MouseEvent mouseEvent) throws Exception{
        Game g = new Game();
        g.start(this.window);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Group grp1 = new Group();
        grp1.getChildren().addAll(a1,a2,a3,a4);
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setDuration(Duration.millis(4000));
        rotate1.setNode(grp1);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(100);
        rotate1.setAutoReverse(false);
        rotate1.play();
        main.getChildren().addAll(grp1);
    }
}
