package sample;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ball extends Application {

    private Circle c1;
    private double velocity=0;
    private double gravity=0.2f;

    public Ball(){
        this.c1 = new Circle(450,700,10);

        this.c1.setFill(Color.PURPLE);
    }
    public void setColor(){
        this.c1.setFill(Color.WHITE);
    }



    public void gr(){
        velocity += gravity;
        c1.setCenterY(c1.getCenterY() + velocity - 0.5);
    }

    public void setY(){
        velocity = -3.15;
        c1.setCenterY(c1.getCenterY()-velocity);
    }

    public String getColor(){
        if (this.c1.getFill() == Color.PURPLE){
            return "p";
        }
        else if (this.c1.getFill() == Color.RED){
            return "r";
        }
        else if (this.c1.getFill() == Color.YELLOW){
            return "y";
        }
        else{
            return "a";
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    public Circle getC1() {
        return c1;
    }

}
