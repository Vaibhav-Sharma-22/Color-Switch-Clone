package sample;
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.util.Duration;

public class Main extends Application {
    protected Stage window;

    private static Database currentd;
    protected Scene scene;
    public Main() throws FileNotFoundException {
    }

    public static MediaPlayer mediaPlayer;
    @Override
    public void start(Stage primaryStage) throws Exception{
        deserialize();
        addMusic();
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        window = primaryStage;
        Group h = new Group();
        h.getChildren().addAll(root,start_button());
        scene = new Scene(h, 530, 620, Color.BLACK);
        window.setScene(scene);
        window.setTitle("Color Switch");
        window.show();
    }
    public static Database getDatabase(){
        return currentd;
    }
    public static void serialize() throws IOException {
        ObjectOutputStream out=null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("database.txt"));
            out.writeObject(currentd);
        }
        finally {
            out.close();
            //System.out.println("Saved!");
            System.exit(0);
        }
    }
    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException{
        ObjectInputStream in = null;
        try {
            in=new ObjectInputStream (new FileInputStream("database.txt"));
            currentd=(Database) in.readObject();
            in.close();
        }
        catch (FileNotFoundException e){
            currentd=new Database();
        }
        catch (NullPointerException e) {
            currentd=new Database();
            //System.out.println("This user does not exist in the database");
        }
    }
    public void addMusic() {
        Media sound = new Media(new File("C:\\Users\\mudit\\Downloads\\Java-Color-Switch-Game-Development-master\\Color-Switch\\src\\sample\\abc.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(50));
        mediaPlayer.play();
    }

    public Button start_button() throws FileNotFoundException {
        Image img = new Image(new FileInputStream("C:\\Users\\mudit\\Downloads\\Java-Color-Switch-Game-Development-master\\Color-Switch\\src\\sample\\play.jpg"));
        ImageView view = new ImageView(img);
        view.setFitHeight(67.0);
        view.setPreserveRatio(true);
        Button b = new Button();
        b.setTranslateX(222);
        b.setTranslateY(344);
        b.setPrefSize(82,82);
        b.setGraphic(view);
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Game g = new Game();
                    g.start(window);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        return b;
    }
    /*
    public void display_table(){
        TableView<String> table = new TableView<String>();
        Label label = new Label("Saved Games");
        label.setFont(new Font("Arial", 15));
        table.setEditable(true);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        root.getChildren().add(vbox);
    }

    public Button loadSavedGames(){
        Button b = new Button();
        b.setTranslateX(34);
        b.setTranslateY(24);
        b.setPrefSize(113, 34);
        b.setText("Load Game");
        b.setTextFill(Paint.valueOf("#fffdfd"));
        b.setStyle("-fx-background-color: #3d3d3d");
        // to show data
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                display_table();
            }
        });

        return b;
    }

     */

    public static void main(String[] args) {
        launch(args);
    }


}
