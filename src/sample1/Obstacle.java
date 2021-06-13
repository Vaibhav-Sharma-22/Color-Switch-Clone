package sample1;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class Obstacle extends Application {

    protected float speed;
    protected Group group;
    protected RotateTransition rotate;

    public Obstacle(){
        group = new Group();
        rotate = new RotateTransition();
    }


    public void setRotate() {
        this.rotate.setNode(this.group);
        this.rotate.setAutoReverse(false);
        this.rotate.setByAngle(360);
        this.rotate.setDuration(Duration.millis(5000));
        this.rotate.setCycleCount(500);
        this.rotate.play();
    }

    public float getSpeed() {
        return speed;
    }

    public Group getGroup() {

        return group;
    }

    public void setGroup() {

    }

    public void setSpeed(float speed) {
        this.rotate.setDuration(Duration.millis(speed));

    }

    public void move(){
        this.group.setLayoutY(this.getGroup().getLayoutY()+100);
    }
    @Override
    public void start(Stage stage) throws Exception {
    }
}
