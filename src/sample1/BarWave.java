package sample1;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BarWave extends Obstacle {
    private Line l1,l2;
    private PathTransition path;
    private Line pathline;
    public BarWave(){
        super();
        path = new PathTransition();
        l1 = new Line(0,0,0,100);
        l2 = new Line(30,0,30,100);
        l1.setStrokeWidth(5);
        l2.setStrokeWidth(5);
        l1.setStroke(Color.AQUA);
        l1.setId("a");
        l2.setStroke(Color.RED);
        l2.setId("r");
        this.group.getChildren().addAll(l1, l2);
    }

    @Override
    public void setRotate() {
        super.setRotate();
    }

    @Override
    public void setGroup() {
        group.setLayoutX(0);
        group.setLayoutX(0);
    }

    @Override
    public Group getGroup() {
        this.setRotate();
        return this.group;
    }

    @Override
    public void setSpeed(float speed) {
        super.setSpeed(speed);
    }

    @Override
    public void move() {
        this.group.setLayoutY(this.getGroup().getLayoutY()+100);
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
