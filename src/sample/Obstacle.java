package sample;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class Obstacle extends Application {

    protected float speed = 400;
    protected Group group;
    protected RotateTransition rotate;

    public Obstacle(){
        group = new Group();
        rotate = new RotateTransition();
    }


    public void setRotate() {

        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setRate(0.07);
        rotate.setDuration(Duration.millis(speed));
        rotate.setNode(group);
        rotate.play();
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
