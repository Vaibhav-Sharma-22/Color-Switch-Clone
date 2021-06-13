package sample;

import javafx.animation.AnimationTimer;
import java.io.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.concurrent.Delayed;

public class Game extends Main implements Iterator {
    @FXML
    private AnchorPane gameroot;
    private DataTable data;
    private Stage Window;
    private AnchorPane pane;
    private Button button1,continuebutton,restatrt,savegame,mainmenu, gamemain, res;
    private Scene scene1,scene2,scene3;
    private Arc a5,a6,a7,a8;
    private Ball Ball;
    private int SCORE=0;
    private Group main,cle;
    private Obstacle circle,cross,barwave,rectangle;
    private List<Obstacle> obs ;
    private Player player;
    TextField score;
    Text display;
    public Game() throws FileNotFoundException {
    }

    public void start(Stage w) throws Exception{
        Window = w;
        Window.setTitle("Color Switch");

        //Ball
        Ball = new Ball();

        obs = new ArrayList<>();

        //score
        score = new TextField("Stars: ");
        score.setPrefWidth(70);
        score.setPrefHeight(30);
        score.setAlignment(Pos.TOP_LEFT);
        score.setStyle("-fx-background-color:grey");

        player = Player.getObj();

        //buttons
        button1 = new Button();
        continuebutton = new Button();
        restatrt = new Button();
        savegame = new Button();
        mainmenu = new Button();

        //obstacles
        circle = new Circle();
        circle.getGroup().setLayoutX(400);
        circle.getGroup().setLayoutY(-50);
        rectangle = new Rectangle();
        rectangle.getGroup().setLayoutX(400);
        rectangle.getGroup().setLayoutY(400);
        barwave = new BarWave();
        barwave.getGroup().setLayoutX(380);
        barwave.getGroup().setLayoutY(-500);
        cross = new Cross();
        cross.getGroup().setLayoutX(400);
        cross.getGroup().setLayoutY(-950);
        obs.add(rectangle);
        obs.add(circle);
        obs.add(barwave);
        obs.add(cross);

        //Ball
        Ball = new Ball();

        //main group initialization
        VBox layout = new VBox(30);
        main = new Group();
        cle = new Group();
        VBox gover = new VBox(30);

        //color change element
        a5 = new Arc(450, 300, 5, 5, 90, 90);
        a6 = new Arc(450, 300, 5, 5, 0, 90);
        a7 = new Arc(450, 300, 5, 5, 180,90);
        a8 = new Arc(450, 300, 5, 5, 270,90);
        a5.setType(ArcType.ROUND);
        a6.setType(ArcType.ROUND);
        a7.setType(ArcType.ROUND);
        a8.setType(ArcType.ROUND);
        a5.setStroke(Color.PURPLE);
        a6.setStroke(Color.AQUA);
        a7.setStroke(Color.RED);
        a8.setStroke(Color.YELLOW);
        a5.setFill(Color.PURPLE);
        a6.setFill(Color.AQUA);
        a7.setFill(Color.RED);
        a8.setFill(Color.YELLOW);
        cle.getChildren().addAll(a5,a6,a7,a8);

        //Image for button1
        Image img = new Image(new FileInputStream("C:\\Users\\mudit\\Downloads\\Java-Color-Switch-Game-Development-master\\Color-Switch\\src\\sample\\download.png"));
        ImageView pause = new ImageView(img);
        pause.setPreserveRatio(true);
        pause.setFitWidth(120);
        pause.setLayoutX(700);
        pause.setLayoutY(150);
        button1.setGraphic(pause);

        //Image for star
        Image img1 = new Image(new FileInputStream("C:\\Users\\mudit\\Downloads\\Java-Color-Switch-Game-Development-master\\Color-Switch\\src\\sample\\download - Copy.png"));
        ImageView star = new ImageView(img1);
        star.setPreserveRatio(true);
        star.setFitWidth(50);
        star.setFitHeight(50);
        star.setLayoutX(430);
        star.setLayoutY(200);


        //Styling of buttons
        button1.setStyle("-fx-background-color:black");
        button1.setTextFill(Color.WHITE);
        button1.setLayoutX(700);
        button1.setLayoutY(200);

        //buttons on scene2
        continuebutton.setText("Continue");
        continuebutton.setStyle("-fx-background-color:grey");
        continuebutton.setTextFill(Color.WHITE);
        continuebutton.setPrefWidth(100);
        continuebutton.setPrefHeight(60);
        restatrt.setText("RESTART");
        restatrt.setStyle("-fx-background-color:grey");
        restatrt.setTextFill(Color.WHITE);
        restatrt.setPrefWidth(100);
        restatrt.setPrefHeight(60);
        savegame.setText("SAVE GAME");
        savegame.setStyle("-fx-background-color:grey");
        savegame.setTextFill(Color.WHITE);
        savegame.setPrefWidth(100);
        savegame.setPrefHeight(60);
        mainmenu.setText("MAIN MENU");
        mainmenu.setStyle("-fx-background-color:grey");
        mainmenu.setTextFill(Color.WHITE);
        mainmenu.setPrefWidth(100);
        mainmenu.setPrefHeight(60);

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(continuebutton,restatrt,savegame,mainmenu);

        player.setScore(4);
        AnimationTimer gravity = new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(Ball.getC1().getCenterY()>700){
                    Ball.getC1().setCenterY(700);
                }
                if (Ball.getC1().getCenterY()<400){
                    star.setLayoutY(star.getLayoutY()+2);
                }
                for (Obstacle a : obs) {
                    if (Ball.getC1().getCenterY() < 400) {
                        a.getGroup().setLayoutY(a.getGroup().getLayoutY() + 2);
                        //System.out.println("rect"+rectangle.getGroup().getLayoutY());
                    }
                    if (a.getGroup().getLayoutY()>940){
                        a.getGroup().setLayoutY(a.getGroup().getLayoutY()-1500);
                    }
                }
                Shape intersect = Shape.intersect((Shape) cle.getChildren().get(2),Ball.getC1());
                if (intersect.getBoundsInParent().getWidth()!=-1){
                    colorelement(Ball,cle);
                    cle.setLayoutY(cle.getLayoutY()-400);
                }


                for (Obstacle a : obs) {
                    for (Node child : a.getGroup().getChildren()) {
                        Shape inter = Shape.intersect(Ball.getC1(), (Shape) child);
                        if (inter.getBoundsInParent().getWidth() != -1) {
                            //System.out.println("child color"+child.getId()+" ball c"+Ball.getColor());
                            if (!Ball.getColor().equals(child.getId())) {
                                //game over
                                this.stop();
                                gamemain = new Button();
                                gamemain.setText("Back to main menu");
                                gamemain.setStyle("-fx-background-color:grey");
                                gamemain.setTextFill(Color.WHITE);
                                gamemain.setPrefWidth(150);
                                gamemain.setPrefHeight(60);
                                res = new Button();
                                res.setText("Want To Resume");
                                res.setStyle("-fx-background-color:grey");
                                res.setTextFill(Color.WHITE);
                                res.setPrefWidth(150);
                                res.setPrefHeight(60);
                                //display.setText(score.getText());
                                gover.setAlignment(Pos.CENTER);
                                gover.getChildren().addAll(res,gamemain,restatrt);
                                scene3 = new Scene(gover,400,500);
                                scene3.setFill(Color.BLACK);
                                Window.setScene(scene3);
                                Window.show();
                                res.setOnMouseClicked(e -> {
                                    Ball.setColor();
                                    this.start();
                                    player.setScore(-4);
                                    Window.setScene(scene1);
                                    Window.show();
                                });
                                if(player.getScore()<4){
                                    res.setDisable(true);
                                }
                                gamemain.setOnMouseClicked  (e->{
                                    Parent root = null;
                                    try {
                                        root = FXMLLoader.load(getClass().getResource("main.fxml"));
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    Group h = new Group();
                                    try {
                                        h.getChildren().addAll(root,start_button());
                                    } catch (FileNotFoundException ex) {
                                        ex.printStackTrace();
                                    }
                                    scene = new Scene(h, 530, 620, Color.BLACK);
                                    Window.setScene(scene);
                                    Window.show();

                                });
                            }
                        }
                    }
                }

                if(Ball.getC1().intersects(star.getBoundsInParent())){
                    //increase score.
                    star.setLayoutY(star.getLayoutY()-150);
                    player.setScore(1);
                    SCORE+=5;
                    score.setText("Stars: "+player.getScore());
                    addtofile();
                }
                for (Obstacle a:obs){
                    if (a.getSpeed()>500) {
                        if (player.getScore() % 7 == 0 && player.getScore() != 0) {
                            a.setSpeed(30);
                        }
                    }
                }
                Ball.gr();
            }
        };
        savegame.setOnAction(actionEvent -> {

            //data.update(SCORE,Ball,obs,circle,rectangle,cross,barwave);
            //Main.getDatabase().removeData(data);
            //data.saveGame();
            System.out.println("Game Saved");
        });
        scene1 = new Scene(main,900,900);
        scene1.setFill(Color.BLACK);

        layout.setStyle("-fx-background-color:black");
        scene2 = new Scene(layout,900,900);

        scene1.setOnMouseClicked(e-> {
                    Ball.setY();
                    gravity.start();
        });


        main.getChildren().addAll(button1,Ball.getC1(),rectangle.getGroup(), cross.getGroup(),circle.getGroup(), barwave.getGroup(),cle,star,score);

        Window.setScene(scene1);
        button1.setOnMouseClicked(e->{

            gravity.stop();
            Window.setScene(scene2);
        });
        continuebutton.setOnMouseClicked(e-> {
            gravity.start();
            Window.setScene(scene1);
        });
        restatrt.setOnMouseClicked(e->{
            try {
                start(this.Window);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        Window.show();
    }
    public void getHIGHSCORE(){

    }
    public void addtofile(){
        try{
            PrintWriter fileout = new PrintWriter(new FileWriter("datascore.txt"));
            fileout.println(SCORE);
            fileout.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void colorelement(Ball ball, Group drp){
        List<Color> colors = new ArrayList<>();
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.AQUA);
        colors.add(Color.PURPLE);
        int rand = (int) (Math.random()*(3-0+1)+0);
        ball.getC1().setFill(colors.get(rand));
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
    /*
    public static void main(String[] args) {
        launch(args);
    }

     */
}
