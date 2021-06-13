package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class loadGameController {
    @FXML
    private ListView statelist;

    @FXML
    private AnchorPane loadgameroot;

    @FXML
    private Button back;

    //ObservableList<DataTable> db = FXCollections.observableArrayList(Main.getDatabase().getDatabaseFiles());

    @FXML
    public void goback(MouseEvent mouseEvent) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("main.fxml"));
        loadgameroot.getChildren().setAll(pane);
    }

    @FXML
    public void initialize(){

        //statelist.setItems(db);
    }

}
