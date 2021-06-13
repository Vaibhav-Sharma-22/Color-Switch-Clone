package sample1;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rectangle extends Obstacle{

    private Line l1,l2,l3,l4;

    public Rectangle(){
        super();
        this.l1 = new Line(0,0,170,0);
        this.l2 = new Line(0,0,0,180);
        this.l3 = new Line(170,0,170,180);
        this.l4 = new Line(0,180,170,180);
        l1.setStroke(Color.YELLOW);
        l1.setId("y");
        l2.setStroke(Color.PURPLE);
        l2.setId("p");
        l3.setStroke(Color.RED);
        l3.setId("r");
        l4.setStroke(Color.AQUA);
        l4.setId("a");
        l1.setStrokeWidth(15);
        l2.setStrokeWidth(15);
        l3.setStrokeWidth(15);
        l4.setStrokeWidth(15);
        l1.setSmooth(true);
        l2.setSmooth(true);
        l3.setSmooth(true);
        l4.setSmooth(true);
        this.group.getChildren().addAll(l1,l2,l3,l4);
    }


    @Override
    public void setRotate() {
        super.setRotate();
    }

    @Override
    public Group getGroup() {
        this.setRotate();
        return this.group;
    }

    @Override
    public void setGroup() {
        }

    @Override
    public float getSpeed() {
        return super.getSpeed();
    }

    @Override
    public void setSpeed(float speed) {
        this.rotate.setDuration(Duration.millis(speed));

    }

    @Override
    public void move() {
        this.group.setLayoutY(this.getGroup().getLayoutY()+2);
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }


}
