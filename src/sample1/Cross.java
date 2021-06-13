package sample1;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Cross extends Obstacle{
    private Line l1,l2;
    public Cross(){
        super();
        l1 = new Line(0,0,50,100);
        l2 = new Line(50,50,0,100);
        l1.setStroke(Color.PURPLE);
        l1.setId("p");
        l2.setStroke(Color.YELLOW);
        l2.setId("y");
        l1.setStrokeWidth(13);
        l1.setStrokeWidth(13);
        this.group.getChildren().addAll(l1,l2);
    }

    @Override
    public void setRotate() {
        super.setRotate();
    }

    @Override
    public Group getGroup() {
        this.setGroup();
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
        super.setSpeed(speed);
    }

    @Override
    public void move() {
        this.group.setLayoutY(this.getGroup().getLayoutY()+100);

    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }

}
